/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tracy.schoolweb.presentation.rest;

import com.tracy.schoolweb.domain.Student;
import com.tracy.schoolweb.services.StudentService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Tracy
 */
@Controller  
@RequestMapping(value = "api/student") 
public class StudentRestController {
    @Autowired
    private StudentService studentService;
    
    @RequestMapping(value = "create",method = RequestMethod.POST) 
    @ResponseBody
    public String create(@RequestBody Student stud)
    { 
        studentService.persist(stud);
        
        System.out.println(" Create the Called ");
        return "Stud Created";
    }
    
    @RequestMapping(value = "update",method = RequestMethod.PUT)
    @ResponseBody
    public String update(@RequestBody Student stud) {
        studentService.merge(stud);
        System.out.println(" Update Called ");
        return "stud Update";
    }

    @RequestMapping(value = "id/{id}",method = RequestMethod.GET) 
    @ResponseBody
    public Student getClub(@PathVariable Long id) {
        
        System.out.println(" ID called ");
        return studentService.find(id);
    }

    @RequestMapping(value = "stud",method = RequestMethod.GET)
    @ResponseBody
    public List<Student> getClubs() {
        System.out.println("The studS");
        return studentService.findAll();
    }

    @RequestMapping(value = "name/{name}",method = RequestMethod.GET) 
    @ResponseBody
    public Student getClubByName(@PathVariable String name) {
        Student stud = studentService.getStudentByName(name); 
        if(stud!=null){
            return stud;
        }
        return null;
    }
}
