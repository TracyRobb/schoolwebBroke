/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tracy.schoolweb.domain;

import java.io.Serializable;
import javax.persistence.Embeddable;

/**
 *
 * @author student
 */
@Embeddable
public class Address implements Serializable{
    
    private int houseNumber;
    private String streetName;
    private String areaName;
    private String areaCode;
    
    private Address()
    {
        
    }
    
    private Address(Builder builder) 
    {
        houseNumber = builder.houseNumber;
        streetName = builder.streetName;
        areaName = builder.areaName;
        areaCode = builder.areaCode;

    }
    
    public static class Builder{
        private int houseNumber;
        private String streetName;
        private String areaName;
        private String areaCode;

        public Builder(int houseNumber) {
            this.houseNumber = houseNumber;
        }


        public Builder streetName(String value){
            streetName = value;
            return this;
        }

        public Builder areaName(String value){
            areaName = value;
            return this;
        }
        
        public Builder areaCode(String value){
            areaCode = value;
            return this;
        }

        public Address build(){
            return new Address(this);
        }
    }

    public int getHouseNumber() {
        return houseNumber;
    }

    public String getStreetName() {
        return streetName;
    }

    public String getAreaName() {
        return areaName;
    }

    public String getAreaCode() {
        return areaCode;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + this.houseNumber;
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
        final Address other = (Address) obj;
        if (this.houseNumber != other.houseNumber) {
            return false;
        }
        return true;
    }
    
    
    
}
