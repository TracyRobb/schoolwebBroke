/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tracy.schoolweb.services.Impl;

import com.tracy.schoolweb.domain.Student;
import com.tracy.schoolweb.repository.StudentRepository;
import com.tracy.schoolweb.services.TotalStudentService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Tracy
 */
@Service
public class TotalStudentServiceImpl implements TotalStudentService{
    
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<Student> getTotalStudent() {
         return studentRepository.findAll();
    }
    
}
