package com.ryan.cashflow_forecast;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import static javax.swing.JOptionPane.showMessageDialog;

/**
 *
 * @author ryanf
 */
public class Persistence {
    
    private static final String FILE_PATH = "save.txt";
    
    public void Persistence(){
        // TODO: add arg for user to provide path 
    }
    
    public void saveState(ArrayList<Transaction> list){
        
        try{
            ArrayList<Transaction> transList = list;
            
            
            FileOutputStream fileOut = new FileOutputStream(FILE_PATH);
            ObjectOutputStream Objout = new ObjectOutputStream(fileOut);
            Objout.writeObject(transList);
            Objout.close();
        }
        
        catch(IOException io){
            showMessageDialog(null, "IOException: There was an error saving the forecast!");
            io.printStackTrace();
        }
        
        catch(Exception e){
            showMessageDialog(null, "There was an error saving the forecast!");
            e.printStackTrace();
        }
    }
    
    public ArrayList<Transaction> loadState(){
        
        try{
            FileInputStream file = new FileInputStream(FILE_PATH);
            ObjectInputStream objectIn = new ObjectInputStream(file);
            
            ArrayList<Transaction> transList = new ArrayList<>();
            transList = (ArrayList<Transaction>)objectIn.readObject();
            
            return transList;
                
            }
            
        
        
        catch(Exception e){
            showMessageDialog(null, "There was an error loading the forecast!");
            e.printStackTrace();
            return null;
        }
        
    }
}
