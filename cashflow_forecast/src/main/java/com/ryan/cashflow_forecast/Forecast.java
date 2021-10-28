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
/**
 *
 * @author ryanf
 */
public class Forecast implements Serializable{
    
    Date start;
    int countMonths = 12;
    
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

   
    
    // add transaction 
    public void addTransaction(Transaction transaction){
        this.transactions.add(transaction);

    }
    
    public void deleteTransaction(int index){
        showMessageDialog(null, "before: " + index);
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
        showMessageDialog(null, "transaction list size = " + index);
        return index;
    }
    
    
    public void createForecast(){
        
        // iterates through transactions, splitting expenditure and income.
        // updates the income, expenditure and surplus lists with the entered transactions.

        this.income.clear();
        this.expenditure.clear();
        this.surplus.clear();
        
        for (int mth = 0; mth < this.countMonths; mth++){
            
            float monthIncomeTotal = 0;
            float monthExpTotal = 0;
            
            for (int i = 0; i < transactions.size(); i++){
                Transaction t = transactions.get(i);
                String type = t.getType();
                     
                try {
            // split income and expenditure
                    if ("Income".equals(type)){
                        float amt = t.getAmount();
                        monthIncomeTotal = monthIncomeTotal + amt;               
                    }
            
                    if ("Expenditure".equals(type)){
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
    
    private void saveState(String fileName){
        // only need to save args for forecast constructor and transaction attributes
        // create 2 files 1 for forecats constructor and 1 for transactions
        // forecast constructor, small txt 1 arg per line.
        // transactions, attributes for each object on a single line delimited with ","
        // iterate over transaction objects create strings to write to file
        // for read, iterate over each line in txt file passing each arg to constructor
    }
}
