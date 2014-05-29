/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tracy.schoolweb.services.Impl;

import com.tracy.schoolweb.domain.Student;
import com.tracy.schoolweb.repository.StudentRepository;
import com.tracy.schoolweb.services.StudentService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Tracy
 */
public class StudentServiceImpl implements StudentService{
    
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student getStudentByName(String name) {
        List<Student> studs = findAll();
        Student foundStud = null;
        for (Student stud : studs) {
            if (stud.getFirstName().equalsIgnoreCase(name)) {
                foundStud = stud;
            }
        }
        return foundStud;
    }

    @Override
    public int getNumberOfStudent() {
        List<Student> studs = findAll();
        return studs.size();
    }

    @Override
    public Student find(Long id) {
        return studentRepository.findOne(id);
    }

    @Override
    public Student persist(Student entity) {
         return studentRepository.save(entity); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Student merge(Student entity) {
        if(entity.getId() != null)
            return studentRepository.save(entity);
        return null;
    }

    @Override
    public void remove(Student entity) {
        studentRepository.delete(entity);
    }

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    
    
}
