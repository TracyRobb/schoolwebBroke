/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tracy.schoolweb.test.repository;

import com.tracy.schoolweb.app.conf.ConnectionConfig;
import com.tracy.schoolweb.domain.Sport;
import com.tracy.schoolweb.repository.SportRepository;
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
public class SportRepositoryTest {
    
    public static ApplicationContext ctx;
    private long id;
    private SportRepository repo;
    
    public SportRepositoryTest() {
        
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void createSport() {
        
        repo = ctx.getBean(SportRepository.class);

        Sport a = new Sport.Builder("Hockey")
                .coach("Mrs Man")
                .season("Winter")
                .build();
                
        repo.save(a);
        id = a.getId();
        Assert.assertNotNull(a);
    }
    
    @Test(dependsOnMethods = "createSport")
    public void readSport(){
        
        repo = ctx.getBean(SportRepository.class);
        Sport s = repo.findOne(id);
        Assert.assertEquals(s.getCoach(), "Mrs Man");   
    }
    
    @Test(dependsOnMethods = "readSport")
    private void updateSport(){
        
         repo = ctx.getBean(SportRepository.class);
         Sport s = repo.findOne(id);
         Sport updatedS = new Sport.Builder("Hockey")
                .winter(s)
                .coach("Mrs Balls Chutney")
                 .build();
        
         repo.save(updatedS);
         
         Sport newAllYear = repo.findOne(id);
         Assert.assertEquals(newAllYear.getCoach(), "Mrs Balls Chutney");
         
    }
    
    @Test(dependsOnMethods = "updateSport")
    private void deleteSport(){
         repo = ctx.getBean(SportRepository.class);
         Sport s = repo.findOne(id);
         repo.delete(s);
         
         Sport sDeleted = repo.findOne(id);
         
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
