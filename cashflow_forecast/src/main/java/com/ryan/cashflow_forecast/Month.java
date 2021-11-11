/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ryan.cashflow_forecast;

import java.util.ArrayList;

/**
 *
 * @author ryanf
 */
public class Month {
    
    public void Month(){
    }
    
    public static ArrayList<String> getMonths(){
        ArrayList<String> months = new ArrayList<>();
        months.add("January");
        months.add("February");
        months.add("March");
        months.add("April");
        months.add("May");
        months.add("June");
        months.add("July");
        months.add("August");
        months.add("September");
        months.add("October");
        months.add("November");
        months.add("December");
        return months;
    }
    
    public static ArrayList<String> monthSorter(String month){
        //creates a list of months in order starting from january
        ArrayList<String> months = new ArrayList<>();
        months.add("January");
        months.add("February");
        months.add("March");
        months.add("April");
        months.add("May");
        months.add("June");
        months.add("July");
        months.add("August");
        months.add("September");
        months.add("October");
        months.add("November");
        months.add("December");
        
        int startMthIdx = 0;
        
        for (int i = 0; i < months.size(); i++){
            if (months.get(i).equals(month)){
                startMthIdx = i;
            }
        }
        
        // creat a new list with months re-ordered with supplied month 1st
        ArrayList<String> reOrderedMonths = new ArrayList<>();
        
        for (int i = 0; i < months.size(); i++){
            if (startMthIdx < 12){
                reOrderedMonths.add(months.get(startMthIdx));
                startMthIdx ++;
            }
            
            else{
                startMthIdx = startMthIdx - 12;
                reOrderedMonths.add(months.get(startMthIdx));
                startMthIdx ++;
            }
        
        }
        
        return reOrderedMonths;
}
}
