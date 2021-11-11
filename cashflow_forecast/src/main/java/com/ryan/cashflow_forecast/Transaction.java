/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ryan.cashflow_forecast;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
/**
 *
 * @author ryanf
 */
public class Transaction implements Serializable {
    
    int index;
    Date next;  // of 1st payment
    Date end; // final payment date.
    //boolean ongoing;
    String freq; // monthly / weekly / quarterly / yearly
    float amount; // £££££
    String name;  //rent, gas etc...
    String type;  //income or expenditure
    

    
    public Transaction(int i, Date next, String frequency, float amount, String name, String type){
        
        this.index = i;
        this.next = next;
        //this.ongoing = ongoing;
        this.freq = frequency;
        this.amount = amount;
        this.name = name;
        this.type = type; 
        
        
    }
    
    public ArrayList getTransSched(){
        ArrayList monthList = Forecast.monthList();
        ArrayList transactionSched = this.transactionSchedule(next, freq, monthList);
        return transactionSched;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public Date getNext() {
        return next;
    }

    public void setNext(Date next) {
        this.next = next;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    //public boolean isOngoing() {
    //    return ongoing;
    //}

    //public void setOngoing(boolean ongoing) {
    //    this.ongoing = ongoing;
    //}

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

    public ArrayList transactionSchedule(Date start, String freq, ArrayList months){
        
        ArrayList<Integer> schedule = new ArrayList<>();
        ArrayList<Integer> monthList = months;
        
        int MONTHS = 12;
      
        // gets start month
        Calendar calStart = Calendar.getInstance();
        calStart.setTime(start);
        int startMonth = calStart.get(Calendar.MONTH);

        // populates transaction schedule
        for (int i = 0; i < MONTHS; i++){
            schedule.add(0);
        }
        if ("monthly".equals(freq) || "weekly".equals(freq)) {
            schedule.clear();
            for (int i = 0; i < MONTHS; i++){
            schedule.add(1);
            }
        }
        
        else if("annually".equals(freq)){
            
            for (int i = 0; i<12; i++){
                if (monthList.get(i) == startMonth){
                    schedule.set(i,1);
                }
            }
            
        }
        
        else if("quarterly".equals(freq)){
        
            for (int i = 0; i<12; i++){
                if (monthList.get(i) == startMonth){
                    schedule.set(i,1);
                    schedule.set(i + 3, 1);
                    schedule.set(i + 6, 1);
                    schedule.set(i + 9, 1);
                }
            } 
        }    
        return schedule;
        }
       
    
}
