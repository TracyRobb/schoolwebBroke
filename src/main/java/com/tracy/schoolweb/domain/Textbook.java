/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tracy.schoolweb.domain;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


/**
 *
 * @author student
 */
@Entity
public class Textbook implements Serializable{
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String textbookName;
    private String author;
    private String publisher;
    
    private Textbook()
    {
        
    }
    
    private Textbook(Builder builder) {
        textbookName = builder.textbookName;
        author = builder.author;
        publisher = builder.publisher;
    }
    
    public static class Builder{
        
        private Long id;
        private String textbookName;
        private String author;
        private String publisher;

        public Builder(String textbookName) {
            this.textbookName = textbookName;
        }


        public Builder author(String value){
            author = value;
            return this;
        }
        
        public Builder publisher(String value){
            publisher = value;
            return this;
        }

        public Textbook build(){
            return new Textbook(this);
        }
    }


    public String getName() {
        return textbookName;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublisher() {
        return publisher;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 31 * hash + Objects.hashCode(this.textbookName);
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
        final Textbook other = (Textbook) obj;
        if (!Objects.equals(this.textbookName, other.textbookName)) {
            return false;
        }
        return true;
    }

    
}
