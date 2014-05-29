/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tracy.schoolweb.domain;

import java.io.Serializable;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author student
 */
@Entity
public class Subject implements Serializable{
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String module;
    @Embedded
    private Textbook textbook;
    
    private Subject()
    {
        
    }
    
    private Subject(Builder builder) {
        id = builder.id;
        name = builder.name;
        module = builder.module;
        textbook = builder.textbook;
    }
    
    public static class Builder{
        
        private Long id;
        private String name;
        private String module;
        private Textbook textbook;

        public Builder(String name) {
            this.name = name;
        }

        public Builder id(Long value){
            id = value;
            return this;
        }

        public Builder modules(String value){
            module = value;
            return this;
        }
        
        public Builder textbook(Textbook value){
            textbook = value;
            return this;
        }
        
        public Builder subject(Subject subject)
        {
            id = subject.getId();
            name = subject.getName();
            module = subject.getModules();
            textbook = subject.getTextbook();
            return this;
        }

        public Subject build(){
            return new Subject(this);
        }
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getModules() {
        return module;
    }

    public Textbook getTextbook() {
        return textbook;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 13 * hash + (int) (this.id ^ (this.id >>> 32));
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
        final Subject other = (Subject) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    
}
