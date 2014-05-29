/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tracy.schoolweb.test.services;

import com.tracy.schoolweb.app.conf.ConnectionConfig;
import com.tracy.schoolweb.domain.Subject;
import com.tracy.schoolweb.repository.SubjectRepository;
import com.tracy.schoolweb.services.TotalSubjectService;
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
public class TotalSubjectServiceTest {
    
    public static ApplicationContext ctx;
    

    private TotalSubjectService service;
    private SubjectRepository subjectRepository;
    
    public TotalSubjectServiceTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void hello() {
        service = ctx.getBean(TotalSubjectService.class);
         List<Subject> subjects = service.getTotalSubject();
         
         Assert.assertEquals( subjects.size(),0, " Expect no Subjects");
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
        subjectRepository = ctx.getBean(SubjectRepository.class);
        subjectRepository.deleteAll();
    }
}
