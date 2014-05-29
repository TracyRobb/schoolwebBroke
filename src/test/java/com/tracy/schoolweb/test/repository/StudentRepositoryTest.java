/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tracy.schoolweb.test.repository;

import com.tracy.schoolweb.app.conf.ConnectionConfig;
import com.tracy.schoolweb.domain.Address;
import com.tracy.schoolweb.domain.Student;
import com.tracy.schoolweb.repository.StudentRepository;
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
public class StudentRepositoryTest {
    
    public static ApplicationContext ctx;
    private long id;
    private StudentRepository repo;
    
    public StudentRepositoryTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void createStudent() {
        
        repo = ctx.getBean(StudentRepository.class);
        Address a = new Address.Builder(37)
                .streetName("Orchid")
                .areaName("Goodwood")
                .areaCode("7460")
                .build();
        
        Student s = new Student.Builder("Tracy")
                .lastName("Robb")
                .address(a)
                .build();
                
        repo.save(s);
        id = s.getId();
        Assert.assertNotNull(s);
    }
    
    @Test(dependsOnMethods = "createStudent")
    public void readStudent(){
        
        repo = ctx.getBean(StudentRepository.class);
        Student s = repo.findOne(id);
        Assert.assertEquals(s.getFirstName(), "Tracy");   
    }

    @Test(dependsOnMethods = "readStudent")
    private void updateStudent(){
        
         repo = ctx.getBean(StudentRepository.class);
         Student s = repo.findOne(id);
         Student updatedS = new Student.Builder("Tracy")
                .student(s)
                .lastName("Killian")
                 .build();
        
         repo.save(updatedS);
         
         Student newStud = repo.findOne(id);
         Assert.assertEquals(newStud.getLastName(), "Killian");
         
    }
    
    @Test(dependsOnMethods = "updateStudent")
    private void deleteStudent(){
         repo = ctx.getBean(StudentRepository.class);
         Student s = repo.findOne(id);
         repo.delete(s);
         
         Student sDeleted = repo.findOne(id);
         
         Assert.assertNull(sDeleted);
           
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
