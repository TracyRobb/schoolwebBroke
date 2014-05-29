/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tracy.schoolweb.test.repository;

import com.tracy.schoolweb.app.conf.ConnectionConfig;
import com.tracy.schoolweb.domain.Address;
import com.tracy.schoolweb.domain.Teacher;
import com.tracy.schoolweb.repository.TeacherRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.testng.Assert;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author Tracy
 */
public class TeacherRepositoryTest {
    
    public static ApplicationContext ctx;
    private long id;
    private TeacherRepository repo;
    
    public TeacherRepositoryTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void createTeacher() {
        repo = ctx.getBean(TeacherRepository.class);
        Address a = new Address.Builder(37)
                .streetName("Orchid")
                .areaName("Goodwood")
                .areaCode("7460")
                .build();
        
        Teacher t = new Teacher.Builder("Tania")
                .lastName("Ferrerai")
                .address(a)
                .build();
                
        repo.save(t);
        id = t.getId();
        Assert.assertNotNull(t);
    }
    
    @Test(dependsOnMethods = "createTeacher")
    public void readTeacher(){
        
        repo = ctx.getBean(TeacherRepository.class);
        Teacher t = repo.findOne(id);
        Assert.assertEquals(t.getFirstName(), "Tania");   
    }

    @Test(dependsOnMethods = "readTeacher")
    private void updateTeacher(){
        
         repo = ctx.getBean(TeacherRepository.class);
         Teacher t = repo.findOne(id);
         Teacher updatedT = new Teacher.Builder("Tania")
                .teacher(t)
                .lastName("Killian")
                .build();
        
         repo.save(updatedT);
         
         Teacher newTeach = repo.findOne(id);
         Assert.assertEquals(newTeach.getLastName(), "Killian");
         
    }
    
    @Test(dependsOnMethods = "updateTeacher")
    private void deleteTeacher(){
         repo = ctx.getBean(TeacherRepository.class);
         Teacher t = repo.findOne(id);
         repo.delete(t);
         
         Teacher tDeleted = repo.findOne(id);
         
         Assert.assertNull(tDeleted);
           
     }

    @BeforeClass
    public static void setUpClass() throws Exception {
        ctx = new AnnotationConfigApplicationContext(ConnectionConfig.class);
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }
}
