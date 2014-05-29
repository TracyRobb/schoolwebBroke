/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tracy.schoolweb.test.services;

import com.tracy.schoolweb.domain.Address;
import com.tracy.schoolweb.domain.Student;
import com.tracy.schoolweb.repository.StudentRepository;
import com.tracy.schoolweb.services.Impl.StudentServiceImpl;
import com.tracy.schoolweb.services.StudentService;
import com.tracy.schoolweb.test.ConnectionConfigTest;
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
public class StudentServiceTest {
    
    public static ApplicationContext ctx;
    private StudentServiceImpl service;
    private StudentRepository repo;
    private Long id;
    
    public StudentServiceTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void createStudent() {
        
        service = ctx.getBean(StudentServiceImpl.class);
        Address a = new Address.Builder(37)
                .streetName("Orchid")
                .areaName("Goodwood")
                .areaCode("7460")
                .build();
        
        Student s = new Student.Builder("Tracy")
                .lastName("Robb")
                .address(a)
                .build();
                
        service.merge(s);
        id = s.getId();
        Assert.assertNotNull(s);
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        ctx = new AnnotationConfigApplicationContext(ConnectionConfigTest.class);
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
