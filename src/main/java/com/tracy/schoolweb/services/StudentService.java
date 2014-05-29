/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tracy.schoolweb.services;

import com.tracy.schoolweb.domain.Student;

/**
 *
 * @author Tracy
 */
public interface StudentService extends Services<Student, Long>{
    
    public Student getStudentByName(String name);
    public int getNumberOfStudent();
    
    
}
