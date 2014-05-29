/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tracy.schoolweb.test.services;

import com.tracy.schoolweb.app.conf.ConnectionConfig;
import com.tracy.schoolweb.domain.Assignment;
import com.tracy.schoolweb.repository.AssignmentRepository;
import com.tracy.schoolweb.services.TotalAssignmentService;
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
public class TotalAssignmentServiceTest {
    
    public static ApplicationContext ctx;
    

    private TotalAssignmentService service;
    private AssignmentRepository assRepository;
    
    
    public TotalAssignmentServiceTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void totalAssignment() {
        service = ctx.getBean(TotalAssignmentService.class);
         List<Assignment> ass = service.getTotalAssignment();
         
         Assert.assertEquals( ass.size(),0, " Expect no Assignment");
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
        assRepository = ctx.getBean(AssignmentRepository.class);
        //assRepository.deleteAll();
    }
}
