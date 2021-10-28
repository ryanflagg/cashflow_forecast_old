package com.ryan.cashflow_forecast;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.ArrayList;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import static javax.swing.JOptionPane.showMessageDialog;

/**
 *
 * @author ryanf
 */
public class Persistence {
    
    private static final String filePath = "C:\\Users\\ryanf\\Documents\\Forecast App\\save";
    
    public void Persistence(){
        // TODO: add arg for user to provide path 
    }
    
    public void saveState(Forecast forecast){
        
        try{
            FileOutputStream fileOut = new FileOutputStream(filePath);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(forecast);
            objectOut.close();
        }
        
        catch(Exception e){
            showMessageDialog(null, "There was an error saving the forecast!");
        }
    }
    
    public Object loadState(){
        
        try{
            FileInputStream file = new FileInputStream(filePath);
            ObjectInputStream objectIn = new ObjectInputStream(file);
            
            Object object = objectIn.readObject();
            return object;           
        }
        
        catch(Exception e){
            showMessageDialog(null, "There was an error loading the forecast!");
            return null;
        }
        
    }
}
