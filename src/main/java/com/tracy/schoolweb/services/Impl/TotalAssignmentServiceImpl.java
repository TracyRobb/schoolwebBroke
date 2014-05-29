/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tracy.schoolweb.services.Impl;

import com.tracy.schoolweb.domain.Assignment;
import com.tracy.schoolweb.repository.AssignmentRepository;
import com.tracy.schoolweb.services.TotalAssignmentService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Tracy
 */
@Service
public class TotalAssignmentServiceImpl implements TotalAssignmentService{
    
    @Autowired
    private AssignmentRepository assignmentRepository;

    @Override
    public List<Assignment> getTotalAssignment() {
        return assignmentRepository.findAll();
    }
    
}
