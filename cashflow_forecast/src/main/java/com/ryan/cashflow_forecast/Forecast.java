/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ryan.cashflow_forecast;
import java.util.ArrayList;
import java.util.Date;
import static javax.swing.JOptionPane.showMessageDialog;
import java.io.Serializable;
import java.util.Calendar;

/**
 *
 * @author ryanf
 */
public class Forecast implements Serializable{
    
    Date start;
    private static final int COUNT_MONTHS = 12;
    
    ArrayList<Float> income = new ArrayList<>();
    ArrayList<Float> expenditure = new ArrayList<>();
    ArrayList<Float> surplus = new ArrayList<>();

    ArrayList<Transaction> transactions = new ArrayList<>();

    
    // method add transaction.
    // method calculate forecast.
    
    public Forecast(){
        showMessageDialog(null, "New forecast sucessfully created!");
        
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(ArrayList<Transaction> transactions) {
        this.transactions = transactions;
    }

       
    // add transaction 
    public void addTransaction(Transaction transaction){
        this.transactions.add(transaction);

    }
    
    public void deleteTransaction(int index){
        this.transactions.remove(index);              
    }
    
    public void reIndexTrans(){
        // re-index all the transactions in transList after one has been removed.
        int len = this.transactions.size();
        for (int i = 0; i < len; i++){
            this.transactions.get(i).setIndex(i);
        }
    }
    
    public int transactionIndex(){
        int index;
        if (this.transactions.isEmpty()){
            index = 0;
        }
        else{
            int len = this.transactions.size();            
            index = len;
        }
        return index;
    }
    
    
    public void createForecast(){
        
        // iterates through transactions, splitting expenditure and income.
        // updates the income, expenditure and surplus lists with the entered transactions.


        this.income.clear();
        this.expenditure.clear();
        this.surplus.clear();
        
        for (int mth = 0; mth < COUNT_MONTHS; mth++){
            
            float monthIncomeTotal = 0;
            float monthExpTotal = 0;
            
            for (int i = 0; i < transactions.size(); i++){
                Transaction t = transactions.get(i);
                String type = t.getType();
                ArrayList<Integer> schedule = t.getTransSched();
                
                
                try {
            
                // split income and expenditure
                    if ("Income".equals(type) && schedule.get(i) == 1){
                        float amt = t.getAmount();
                        monthIncomeTotal = monthIncomeTotal + amt;               
                    }
            
                    if ("Expenditure".equals(type) && schedule.get(i) == 1){
                        float amt = t.getAmount();
                        monthExpTotal = monthExpTotal + amt;          
                    }
                }
                catch(Exception e){
                    
                    showMessageDialog(null, "There was an error sorting the transactions!");
                }
            
            }
            
            try{
                
                float mthSurplus = monthIncomeTotal - monthExpTotal;
                income.add(monthIncomeTotal);
                expenditure.add(monthExpTotal);
                surplus.add(mthSurplus);
            }
            
            catch(Exception e){
                
                showMessageDialog(null, "There was an error compiling monthly income and expenditure!");
                        
            }
        }
       
            
    }
    
    public static ArrayList monthList(){
        
        ArrayList<Integer> months = new ArrayList<>();
        int MONTHS = 12;
        
        // gets current month
        Date now = Calendar.getInstance().getTime();
        Calendar calNow = Calendar.getInstance();
        calNow.setTime(now);
        int thisMonth = calNow.get(Calendar.MONTH);
        
        // populates the month list
        for (int i = 0; i < MONTHS; i++){
            
            if (thisMonth < 12){
                months.set(i, thisMonth);
                thisMonth++;
                }
            else {
                thisMonth = thisMonth - 12;
                months.set(i, thisMonth);
                thisMonth++;
            }
        }
        return months;       
    }
    

    }
           

