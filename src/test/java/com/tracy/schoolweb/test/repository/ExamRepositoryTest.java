/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tracy.schoolweb.test.repository;

import com.tracy.schoolweb.app.conf.ConnectionConfig;
import com.tracy.schoolweb.domain.Exam;
import com.tracy.schoolweb.repository.ExamRepository;
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
public class ExamRepositoryTest {
    
    public static ApplicationContext ctx;
    private long id;
    private ExamRepository repo;
    
    public ExamRepositoryTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void createExam() {
    
        repo = ctx.getBean(ExamRepository.class);
        
        Exam e = new Exam.Builder(1001)
                .mark(68)
                .build();
        
        repo.save(e);
        id = e.getId();
        Assert.assertNotNull(e);
    
    }
    
    @Test(dependsOnMethods = "createExam")
    public void readExam(){
        
        repo = ctx.getBean(ExamRepository.class);
        Exam e = repo.findOne(id);
        Assert.assertEquals(e.getMark(), 68.0);   
    }

    @Test(dependsOnMethods = "readExam")
    private void updateExam(){
        
         repo = ctx.getBean(ExamRepository.class);
         Exam e = repo.findOne(id);
         Exam updatedE = new Exam.Builder(101)
                .exam(e).mark(75).build();
        
         repo.save(updatedE);
         
         Exam newExam = repo.findOne(id);
         Assert.assertEquals(newExam.getMark(), 75.0);
         
    }
    
    @Test(dependsOnMethods = "updateExam")
    private void deleteExam(){
         repo = ctx.getBean(ExamRepository.class);
         Exam s = repo.findOne(id);
         repo.delete(s);
         
         Exam sDeleted = repo.findOne(id);
         
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
