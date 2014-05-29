/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tracy.schoolweb.test.repository;

import com.tracy.schoolweb.app.conf.ConnectionConfig;
import com.tracy.schoolweb.domain.Subject;
import com.tracy.schoolweb.domain.Textbook;
import com.tracy.schoolweb.repository.SubjectRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author Tracy
 */
public class SubjectRepositoryTest {
    
    public static ApplicationContext ctx;
    private long id;
    private SubjectRepository repo;
    
    public SubjectRepositoryTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void createSubject() {
        
        repo = ctx.getBean(SubjectRepository.class);
        Textbook t = new Textbook.Builder("Divide Maths")
                .author("Sally Kim")
                .publisher("Penguin Publishers")
                .build();
        
        Subject s = new Subject.Builder("Technical Maths")
                .modules("Dividing by zero")
                .textbook(t)
                .build();
        repo.save(s);
        id = s.getId();
        Assert.assertNotNull(s);
    }
    
    
    @Test(dependsOnMethods = "createSubject")
    public void readSubject(){
        
        repo = ctx.getBean(SubjectRepository.class);
        Subject s = repo.findOne(id);
        Assert.assertEquals(s.getName(), "Technical Maths");   
    }

    @Test(dependsOnMethods = "readSubject")
    private void updateSubject(){
        
         repo = ctx.getBean(SubjectRepository.class);
         Subject s = repo.findOne(id);
         Subject updatedS = new Subject.Builder("Technical Science")
                .subject(s)
                .modules("Dividing by one")
                 .build();
        
         repo.save(updatedS);
         
         Subject newSubject = repo.findOne(id);
         Assert.assertEquals(newSubject.getModules(), "Dividing by one");
         
    }
    
    @Test(dependsOnMethods = "updateSubject")
    private void deleteSubject(){
         repo = ctx.getBean(SubjectRepository.class);
         Subject s = repo.findOne(id);
         repo.delete(s);
         
         Subject sDeleted = repo.findOne(id);
         
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
