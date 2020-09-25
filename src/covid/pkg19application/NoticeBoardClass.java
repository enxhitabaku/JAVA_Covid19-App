/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package covid.pkg19application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This class calculate the data to be displayed in the form
 * @author Enxhi Tabaku
 */
public class NoticeBoardClass {
            
    //declaring private variables
    private String ID;
    private String zip;
    private String avg;
  
    public NoticeBoardClass(String ID, String zip, String avg){
    
        this.ID=ID;
        this.zip=zip;
        this.avg=avg;
        
    }
    /*
    public NoticeBoardClass(String str){
        
        String[]token=str.split(" ");
        
        this.ID=token[0];
        this.zip=token[1];
        this.avg=token[2];
        
    }
    
    
    public String toString(){
        return this.getID()+" "+this.getZip()+" "+this.getAvg();
    }
    */
    
    /**
     * This Method Will Return the area data of infected users
     * Only the one with average result equal or higher than 70% will be considered potentially infected
     * @param fileList the data file to read from
     * @return infectedAreas
     */
    /*
    protected static ArrayList<String> infectedAreas(ArrayList<NoticeBoardClass>fileList){
    
        ArrayList<String>infectedAreas = new ArrayList<>();

            for(int i=0;i<fileList.size();i++){
                Integer intAvg=Integer.valueOf(fileList.get(i).getAvg()); //In order to compare we turn the avg to integer value
                if(intAvg>=70){
                    infectedAreas.add( fileList.get(i).getZip()); // add to the list the potential infected users
                }
            }//End of FOR
            
        return infectedAreas;
    }
    */
        
    /**
     * This method will return the total String value of the infected users
     * @param infectedAreas the list of all the infected users based on their zip
     * @return infectedAreas.size()
     */
    /*
    protected static String TottalNo(ArrayList<String>infectedAreas){
        return String.valueOf( infectedAreas.size() );
    }
    */
    
    /**
     * This method will return the most infected city zip code
     * @param infectedAreas the list of all the infected users based on their zip 
     * @return key
     */
    /*
    protected static String PotentialInfectedCity(ArrayList<String>infectedAreas){
         // Create HashMap to store zip and it's frequency 
        HashMap<String, Integer> hs = new HashMap<String, Integer>(); 
  
        // Iterate through array of words 
        for (int i = 0; i < infectedAreas.size(); i++) { 
            // If zip already exist in HashMap then increase it's count by 1 
            String zip=infectedAreas.get(i);
            if (hs.containsKey( zip ) )
            { 
                hs.put(zip, hs.get(zip) + 1); 
            } 
            // Otherwise add zip to HashMap 
            else { 
                hs.put(zip, 1); 
            } 
        } 
  
        // Create set to iterate over HashMap 
        Set<Map.Entry<String, Integer> > set = hs.entrySet(); 
        String key = ""; 
        int value = 0; 
  
        for (Map.Entry<String, Integer> me : set) { 
            // Check for zip having highest frequency 
            if (me.getValue() > value) { 
                value = me.getValue(); 
                key = me.getKey(); 
            } 
        } 

       return key;
    } 
    */
    
    /**
     * This Method will count the infected number of users in the potential infected city
     * @param infectedAreas the arrayList of infected Areas
     * @param key the infected no of users
     * @return String representation of the potential infected people
     */
    /*
    protected static String PotentialInfectedNo(ArrayList<String>infectedAreas,String key){

        int count=0;//initializ variable to count 
        
        for(int i=0;i<infectedAreas.size();i++){
            if(key.equals( infectedAreas.get(i) ) ){
                count++;
            }
        }//End of For
        
        return String.valueOf(count);
    }
    */
    
    /**
     * This method will return the infected people in the user area based on his zip code
     * @param infectedAreas the list of all the infected users based on their zip
     * @return areaCount
     */
    /*
    protected static String AreaInfectedNo(ArrayList<String>infectedAreas){
        //Get the user ID based on his email. 
        HashMap<String,String>mapID=(HashMap<String,String>) UserClass.storeDBemailAndID();
        String ID=mapID.get( LogIn.email );
        //Get the user ZIP based on his ID
        HashMap<String,String>mapZIP= (HashMap<String,String>) UserClass.storeDBidAndZIP();
        String ZIP=mapZIP.get(ID);

        int areaCount=0;//initializ variable to count the no of area infected people
        
        for(int i=0;i<infectedAreas.size();i++){
            
            if(ZIP.equals( infectedAreas.get(i) ) ){//if the user ZIP match any of the zip returned from the arrayList
                areaCount++;//increment no of infected people
            }
        }//End of For
        
        return String.valueOf(areaCount);
    }
   */
     
    protected String getID() {
        return ID;
    }

    protected void setID(String ID) {
        this.ID = ID;
    }

    protected String getZip() {
        return zip;
    }

    protected void setZip(String zip) {
        this.zip = zip;
    }

    protected String getAvg() {
        return avg;
    }

    protected void setAvg(String avg) {
        this.avg = avg;
    }
    

   
}
