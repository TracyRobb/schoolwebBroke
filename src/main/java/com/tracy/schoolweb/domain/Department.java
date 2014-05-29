/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tracy.schoolweb.domain;

import com.tracy.schoolweb.domain.Teacher;
import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

/**
 *
 * @author student
 */
@Entity
public class Department implements Serializable{
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "subject_id")
    private Subject sub;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;
    
    private Department()
    {
        
    }
    
    private Department(Builder builder) {
        id = builder.id;
        name = builder.name;
        sub = builder.sub;
        teacher = builder.teacher;
        
    }
    
    public static class Builder{
        private long id;
        private String name;
        private Subject sub;
        private Teacher teacher;

        public Builder(String value) {
            this.name = value;
        }

        public Builder sub(Subject value){
            sub = value;
            return this;
        }
        
        public Builder teacher(Teacher value){
            teacher = value;
            return this;
        }
        
        public Builder depart(Department dept)
        {
            this.id = dept.getId();
            this.name = dept.getName();
            this.sub = dept.getSub();
            this.teacher = dept.getTeacher();
            return this;
        }
        
        public Department build(){
            return new Department(this);
        }
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Subject getSub() {
        return sub;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 11 * hash + (int) (this.id ^ (this.id >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Department other = (Department) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
 
}
