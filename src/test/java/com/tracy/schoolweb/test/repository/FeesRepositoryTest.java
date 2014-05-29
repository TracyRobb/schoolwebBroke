/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tracy.schoolweb.test.repository;

import com.tracy.schoolweb.app.conf.ConnectionConfig;
import com.tracy.schoolweb.domain.Fees;
import com.tracy.schoolweb.repository.FeesRepository;
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
public class FeesRepositoryTest {
    
    public static ApplicationContext ctx;
    private long id;
    private FeesRepository repo;
    
    public FeesRepositoryTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void createFees() {
        repo = ctx.getBean(FeesRepository.class);
        Fees f = new Fees.Builder(123).outstand(4500.0).build();
        
        repo.save(f);
        id = f.getId();
        Assert.assertNotNull(f);
    }
    
    @Test(dependsOnMethods = "createFees")
    public void readFees(){
        
        repo = ctx.getBean(FeesRepository.class);
        Fees e = repo.findOne(id);
        Assert.assertEquals(e.getOutstand(), 0.0);   
    }

    @Test(dependsOnMethods = "readFees")
    private void updateFees(){
        
         repo = ctx.getBean(FeesRepository.class);
         Fees e = repo.findOne(id);
         Fees updatedE = new Fees.Builder(101)
                .fees(e).outstand(0.0).build();
        
         repo.save(updatedE);
         
         Fees newExam = repo.findOne(id);
         Assert.assertEquals(newExam.getOutstand(), 0.0);
         
    }
    
    @Test(dependsOnMethods = "updateFees")
    private void deleteFees(){
         repo = ctx.getBean(FeesRepository.class);
         Fees s = repo.findOne(id);
         repo.delete(s);
         
         Fees sDeleted = repo.findOne(id);
         
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
