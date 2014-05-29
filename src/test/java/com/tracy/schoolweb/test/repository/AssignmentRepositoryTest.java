/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tracy.schoolweb.test.repository;

import com.tracy.schoolweb.app.conf.ConnectionConfig;
import com.tracy.schoolweb.domain.Address;
import com.tracy.schoolweb.domain.Assignment;
import com.tracy.schoolweb.domain.Student;
import com.tracy.schoolweb.repository.AssignmentRepository;
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
public class AssignmentRepositoryTest {
    
    public static ApplicationContext ctx;
    private long id;
    private AssignmentRepository repo;
    
    public AssignmentRepositoryTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void createAssignment() {
        
        repo = ctx.getBean(AssignmentRepository.class);
        
        Address ad = new Address.Builder(37)
                .streetName("Orchid")
                .areaName("Goodwood")
                .areaCode("7460")
                .build();
        Student s = new Student.Builder("Megan")
                .lastName("Robb")
                .address(ad)
                .build();
        
        Assignment a = new Assignment.Builder(86.0)
                   .Student(s)
                .build();
                
        repo.save(a);
        id = a.getId();
        Assert.assertNotNull(a);
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
