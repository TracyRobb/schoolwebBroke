/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tracy.schoolweb.domain;

import com.tracy.schoolweb.domain.Student;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
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
public class Sport implements Serializable{
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String coach;
    private String season;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "Sport_id")
    private List<Student> students;
    
    private Sport()
    {
        
    }
    
    private Sport(Builder builder) 
    {
        id = builder.id;
        name = builder.name;
        coach = builder.coach;
        season = builder.season;
        students = builder.students;

    }

    
    
    public static class Builder{
        
        private Long id;
        private String name;
        private String coach;
        private String season;
        private List<Student> students;

        public Builder(String value) {
            this.name = value;
        }


        public Builder coach(String value){
            coach = value;
            return this;
        }
        
        public Builder season(String value){
            season = value;
            return this;
        }
        
        public Builder students(List<Student> value){
            students = value;
            return this;
        }
        
        public Builder winter(Sport a)
        {
            id = a.getId();
            name = a.getName();
            coach = a.getCoach();
            season = a.getSeason();
            students = a.getStudents();
            return this;
        }

        public Sport build(){
            return new Sport(this);
        }
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name; 
    }

    public String getCoach() {
        return coach;
    }
    
    private String getSeason() {
        return season;
    }
    
    public List<Student> getStudents() {
        return students;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + (int) (this.id ^ (this.id >>> 32));
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
        final Sport other = (Sport) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    
    
    
    
}
