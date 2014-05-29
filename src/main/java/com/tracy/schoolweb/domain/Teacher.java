/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tracy.schoolweb.domain;


import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

/**
 *
 * @author student
 */
@Entity
public class Teacher implements Serializable{
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String firstName;
    private String lastName;
    
    @Embedded
    private Address address;
    
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "teacher_id")
    private List<Student> students;
    
    
    private Teacher()
    {
        
    }
    
    private Teacher(Builder builder) {
        id = builder.id;
        firstName = builder.firstName;
        lastName = builder.lastName;
        address = builder.address;
        students = builder.students;
        

    }
    
    public static class Builder{
        private long id;
        private String firstName;
        private String lastName;
        private Address address;
        private List<Student> students;

        public Builder(String value) {
            this.firstName = value;
        }


        public Builder lastName(String value){
            lastName = value;
            return this;
        }
        
        public Builder address(Address value){
            address = value;
            return this;
        }
        
        public Builder students(List<Student> value){
            students = value;
            return this;
        }
        
        public Builder teacher(Teacher teacher)
        {
            this.id = teacher.getId();
            this.firstName = teacher.getFirstName();
            this.lastName = teacher.getLastName();
            this.address = teacher.getAddress();
            this.students = teacher.getStudents();
            return this;
        }

        public Teacher build(){
            return new Teacher(this);
        }
    }
    

    public long getId() {
        return id;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName; 
    }

    public Address getAddress() {
        return address;
    }
    

    public List<Student> getStudents() {
        return students;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + (int) (this.id ^ (this.id >>> 32));
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
        final Teacher other = (Teacher) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    
    
    
    
    
    
}
