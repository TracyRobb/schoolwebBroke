/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tracy.schoolweb.domain;



import com.tracy.schoolweb.domain.Subject;
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
public class Student implements Serializable{
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String firstName;
    private String lastName;
    
    @Embedded
    private Address address;
    
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "student_id")
    private List<Subject> subjects;
    
    private Student()
    {
        
    }
    
    private Student(Builder builder) {
        id = builder.id;
        firstName = builder.firstName;
        lastName = builder.lastName;
        address = builder.address;
        subjects = builder.subjects;
    }
    
    public static class Builder{
        
        private long id;
        private String firstName;
        private String lastName;
        private Address address;
        private List<Subject> subjects;

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
        
        public Builder stubjects(List<Subject> value){
            subjects = value;
            return this;
        }
        
        public Builder student(Student student)
        {
            this.id = student.getId();
            this.firstName = student.getFirstName();
            this.lastName = student.getLastName();
            this.address = student.getAddress();
            this.subjects = student.getSubjects();
            return this;
        }

        public Student build(){
            return new Student(this);
        }
    }
    
    public Long getId() {
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

    public List<Subject> getSubjects() {
        return subjects;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + (int) (this.id ^ (this.id >>> 32));
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
        final Student other = (Student) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    
    
    
    
    
    
}
