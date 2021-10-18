/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ryan.cashflow_forecast;
import java.util.Date;
/**
 *
 * @author ryanf
 */
public class Transaction {
    
    Date date;
    String freq;
    float amount;
    String name;
    String type;
    
    public Transaction(float amount, String name, String type){
        
        this.amount = amount;
        //this.freq = frequency;
        //this.date = date;
        this.name = name;
        this.type = type;
        
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getFreq() {
        return freq;
    }

    public void setFreq(String freq) {
        this.freq = freq;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
       
}
