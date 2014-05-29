/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tracy.schoolweb.domain;

import com.tracy.schoolweb.domain.Student;
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
public class Exam implements Serializable{
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private long examNum;
    private double mark;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "exam_id")
    private Subject sub;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "test_id")
    private Student studentID;
    
    private Exam()
    {
        
    }
    
    private Exam(Builder builder) {
        id = builder.id;
        mark = builder.mark;
        sub = builder.sub;
        studentID = builder.studentID;

    }
    
    public static class Builder{
        private long id;
        private long examNum;
        private double mark;
        private Subject sub;
        private Student studentID;

        public Builder(long examNum) {
            this.examNum = examNum;
        }

        public Builder mark(double value){
            mark = value;
            return this;
        }

        public Builder subject(Subject value){
            sub = value;
            return this;
        }
        
        public Builder Student(Student value){
            studentID = value;
            return this;
        }
        
        public Builder exam(Exam exam)
        {
            this.id = exam.getId();
            this.examNum = exam.getExamNum();
            this.mark = exam.getMark();
            this.sub = exam.getSubject();
            this.studentID = exam.getStudentID();
            return this;
        }

        public Exam build(){
            return new Exam(this);
        }
    }

    public void calcMark(int score, int total) {
        mark = score/total * 100;
    }
    
    public long getId() {
        return id;
    }
    
    public long getExamNum(){
        return examNum;
    }
    
    public double getMark() {
        return mark;
    }

    public Subject getSubject() {
        return sub;
    }
    
    public Student getStudentID() {
        return studentID;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + (int) (this.id ^ (this.id >>> 32));
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
        final Exam other = (Exam) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    

    
}
