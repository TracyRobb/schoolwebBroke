/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tracy.schoolweb.services.Impl;

import com.tracy.schoolweb.domain.Subject;
import com.tracy.schoolweb.repository.SubjectRepository;
import com.tracy.schoolweb.services.TotalSubjectService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Tracy
 */

@Service
public class TotalSubjectServiceImpl implements TotalSubjectService{

    @Autowired
    private SubjectRepository subjectRepository;
    
    @Override
    public List<Subject> getTotalSubject() {
        return subjectRepository.findAll();
    }
    
}
