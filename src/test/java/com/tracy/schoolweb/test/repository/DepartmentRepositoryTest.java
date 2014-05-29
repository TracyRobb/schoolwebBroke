/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tracy.schoolweb.test.repository;

import com.tracy.schoolweb.app.conf.ConnectionConfig;
import com.tracy.schoolweb.domain.Department;
import com.tracy.schoolweb.domain.Subject;
import com.tracy.schoolweb.domain.Teacher;
import com.tracy.schoolweb.repository.DepartmentRepository;
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
public class DepartmentRepositoryTest {
    
    public static ApplicationContext ctx;
    private long id;
    private DepartmentRepository repo;
    
    public DepartmentRepositoryTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void createDepartmet() {
        
        repo = ctx.getBean(DepartmentRepository.class);
       
        Subject s = new Subject.Builder("Technical Maths")
                .modules("Dividing by zero")
                .build();
        
        Department d = new Department.Builder("Mathematical")
                .sub(s)
                .build();
        
        repo.save(d);
        id = d.getId();
        Assert.assertNotNull(d);

    }
    
    @Test(dependsOnMethods = "createDepartmet")
    public void readDepartment(){
        
        repo = ctx.getBean(DepartmentRepository.class);
        Department s = repo.findOne(id);
        Assert.assertEquals(s.getName(), "Mathematical");   
    }

    @Test(dependsOnMethods = "readDepartment")
    private void updateDepartment(){
        
         repo = ctx.getBean(DepartmentRepository.class);
 
         Department d = repo.findOne(id);
         Subject t = new Subject.Builder("Technical Maths")
                .modules("Dividing by zero")
                .build();
         Department updatedD = new Department.Builder("Mathematical")
                .sub(t)
                .depart(d)
                .build();
        
         repo.save(updatedD);
         
         Department newDepartment = repo.findOne(id);
         Assert.assertEquals(newDepartment.getSub().getModules(), "Dividing by zero");
         
    }
    
    @Test(dependsOnMethods = "updateDepartment")
    private void deleteDepartment(){
         repo = ctx.getBean(DepartmentRepository.class);
         Department d = repo.findOne(id);
         repo.delete(d);
         
         Department sDeleted = repo.findOne(id);
         
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
