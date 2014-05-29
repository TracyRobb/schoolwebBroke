/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tracy.schoolweb.repository;


import com.tracy.schoolweb.domain.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/**
 *
 * @author Tracy
 */
@Repository
public interface SubjectRepository extends JpaRepository<Subject, Long>{
    
}
