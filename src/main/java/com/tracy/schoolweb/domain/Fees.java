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
public class Fees implements Serializable{
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private long feeNumber;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fee_id")
    private Student stud;
    private double outstandingAmount;
    
    public double CalcFees()
    {
        outstandingAmount = stud.getSubjects().size() * 1700 * 1.5;
        return outstandingAmount;
    }
    
    private Fees()
    {
        
    }
    
    private Fees(Builder builder) {
        stud = builder.stud;
        
    }
    
    public static class Builder{
        
        private long id;
        private long feeNumber;
        private double outstandingAmount;
        private Student stud;
        
        public Builder (long feeNumber){
            this.feeNumber = feeNumber;
            
        } 
        
        public Builder outstand(double outstandingAmount){
            this.outstandingAmount = outstandingAmount;
            return this;
        }
        
        public Builder(Student stud) {
            this.stud = stud;
        }

        public Builder fees(Fees fee)
        {
            this.id = fee.getId();
            this.feeNumber = fee.getFeeNum();
            this.outstandingAmount = fee.getOutstand();
            this.stud = fee.getStud();
            return this;
        }
        
        
        public Fees build(){
            return new Fees(this);
        }
    }
    
    public long getId() {
        return id;
    }
    
    public long getFeeNum(){
        return feeNumber;
    }
    
    public double getOutstand(){
        return outstandingAmount;
    }

    public Student getStud() {
        return stud;
    }

    @Override
    public int hashCode() {
        int hash = 7;
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
        final Fees other = (Fees) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    
    
    
    
}
