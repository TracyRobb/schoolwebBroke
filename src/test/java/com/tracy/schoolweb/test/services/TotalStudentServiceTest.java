/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tracy.schoolweb.test.services;

import com.tracy.schoolweb.app.conf.ConnectionConfig;
import com.tracy.schoolweb.domain.Student;
import com.tracy.schoolweb.repository.StudentRepository;
import com.tracy.schoolweb.services.TotalStudentService;
import com.tracy.schoolweb.test.ConnectionConfigTest;
import java.util.List;
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
public class TotalStudentServiceTest {
    public static ApplicationContext ctx;
    

    private TotalStudentService service;
    private StudentRepository studentRepository;
    
    public TotalStudentServiceTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void totalStudents() {
         service = ctx.getBean(TotalStudentService.class);
         List<Student> student = service.getTotalStudent();
         
         Assert.assertEquals( student.size(),1, " Expect 1 Students");
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
        studentRepository = ctx.getBean(StudentRepository.class);
        //studentRepository.deleteAll();
    }
}
