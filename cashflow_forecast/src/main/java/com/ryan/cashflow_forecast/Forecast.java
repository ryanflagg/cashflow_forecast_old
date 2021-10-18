/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ryan.cashflow_forecast;
import java.util.ArrayList;
import java.util.Date;
/**
 *
 * @author ryanf
 */
public class Forecast {
    
    Date start;
    int countMonths = 12;
    
    ArrayList<ArrayList> forecast = new ArrayList<>();

    ArrayList<Transaction> transactions = new ArrayList<>();

    
    // method add transaction.
    // method calculate forecast.
    
    public Forecast(){
        
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }
    
    // add transaction 
    public void addTransaction(Transaction transaction){
        transactions.add(transaction);
    }
    
    // create forecast iterates through transactions, splitting expenditure and income.
    public void createForecast(){
        ArrayList<ArrayList> month = new ArrayList<>();
        for (int mth = 0; mth < this.countMonths; mth++){
            
            ArrayList<Float> income = new ArrayList<>();
            ArrayList<Float> expenditure = new ArrayList<>();
            
            for (int i = 0; i < transactions.size(); i++){
                Transaction t = transactions.get(i);
                String type = t.getType();
                     
                try {
            // split income and expenditure
                    if ("Income".equals(type)){
                        float amt = t.getAmount();
                        income.add(amt);               
                    }
            
                    if ("Expense".equals(type)){
                        float amt = t.getAmount();
                        expenditure.add(amt);
                    }
                }
                catch(Exception e){
                    System.out.println("There was an error sorting the transactions!");
                }               
            }
            
            try{
                month.add(income);
                month.add(expenditure);
            }
            
            catch(Exception e){
                System.out.println("There was an error adding a transaction"
                        + "to the month!");
            }
        }
        
        try{
            forecast.add(month);
        }
        
        catch(Exception e){
            System.out.println("There was an error adding the month to the forecast!");
        }
    }
}
