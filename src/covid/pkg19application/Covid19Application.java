/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package covid.pkg19application;

import java.sql.*;


/**
 * @version 1.2.0.0 
 * @author Enxhi Tabaku
 */
public class Covid19Application {

    /**
     * Main Method to execute the program
     * @param args ..
     */
    
    public static void main(String[] args) {       
        LogIn menu=new LogIn();
       
        menu.setVisible(true);
        menu.setLocationRelativeTo(null);
        
         
    }
    
    static Connection dbConnect(){
        Connection con=null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/javaproject?zeroDateTimeBehavior=convertToNull","root","");
            System.out.println("Succefully Connected");
        } catch (Exception e){
            e.printStackTrace();
        }
        return con;
    }
    
    
}
