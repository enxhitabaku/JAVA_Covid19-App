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
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This Class Will Store User Information
 * @author Enxhi Tabaku
 */
public class UserClass {
    
   protected static String ID;//Store the user Id temporary
    /**
     *
     * @param name
     * @param surname
     * @param email
     * @param zip
     * @param id
     * @param password
     */
    
    private String name;
    private String surname;
    private String email;
    private String zip;
    private String id;
    private String password;
   
    /**
     * This Constructor assigns the corresponding values to the variables
     * @param id
     * @param name
     * @param surname
     * @param email
     * @param zip 
     * @param password
     */
    UserClass(String id, String name, String surname, String email, String zip, String password){
        
        this.id=id;
        this.name=name;
        this.surname=surname;
        this.email=email;
        this.zip=zip;
        this.password=password;
        
    }
    
    /**
     * This Constructor Will Split The String Taken As Paramether via The Delimeter " "
     * @param str 
     */
    UserClass(String str){
        String []token;
        token=str.split(" ");
        
        this.id=token[0];
        this.name=token[1];
        this.email=token[2];
        this.password=token[3];
        this.zip=token[4];
        
        
    }
    
    /**
     *This Method will get the name
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name to set the corresponding value
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return surname to get the corresponding value
     */
    public String getSurname() {
        return surname;
    }

    /**
     *
     * @param surname to set the corresponding value
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }

    /**
     *
     * @return email to get the corresponding value
     */ 
    public String getEmail() {
        return email;
    }

    /**
     *
     * @param email to set the corresponding value
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     *
     * @return zip to get the corresponding value
     */
    public String getZip() {
        return zip;
    }

    /**
     *
     * @param zip to set the corresponding value
     */
    public void setZip(String zip) {
        this.zip = zip;
    }

    /**
     *
     * @return id to get the corresponding value
     */
    public String getId() {
        return id;
    }

    /**
     *
     * @param id to set the corresponding value
     */
    public void setId(String id) {
        this.id = id;
    }
    
    /**
     *
     * @return password to get the corresponding value
     */
    public String getPassword() {
        return password;
    }
    /**
     *
     * @param password to set the corresponding value
     */
    public void setPassword(String password) {
        this.password = password;
    }
    
    /**
     * This Method Will Verify Email And Password in order to log in
     * @param fileToSearch the file to be searched for user data
     * @param searchEmail the email input from user
     * @param searchPassw the pass input from user
     * @return boolean value 
     */
    /*
    protected static boolean verifyLogIn(ArrayList<UserClass>fileToSearch,String searchEmail,String searchPassw){
        boolean validate=false;
        boolean validateEmail=false;

        for(int i=0;i<fileToSearch.size();i++){
            if(fileToSearch.get(i).getEmail().equals(searchEmail))
            {
                String password=String.valueOf( fileToSearch.get(i).getPassword() );
                if(password.equals(searchPassw))
                {
                    validateEmail=true;//Email is OK
                    return validate=true;//Logged In Succesfully
                }//end of Nested If    
                else{
                    JOptionPane.showMessageDialog(null, "Wrong Passsword");
                    validateEmail=true;//Username is OK
                }//End of nested Else
            }//end of If    
        }//End of For     

            if(!validateEmail)
            {
                JOptionPane.showMessageDialog(null, "Wrong Email");
            }//End of If

                return validate;
    }
    */
    static boolean verifyLogInDB(String emailToSearch, String passToSearch){
        boolean validate=false;
        
        try {
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/javaproject?zeroDateTimeBehavior=convertToNull","root","");

            PreparedStatement state=con.prepareStatement("SELECT * FROM Users WHERE email=? AND password=? ");
            state.setString(1, emailToSearch);
            state.setString(2, passToSearch);

            ResultSet rs= state.executeQuery();

            if(rs.next()){
                System.out.println("Valid User");//Debug
                validate=true;
             }else
                System.out.println("Invalid User");//Debug
                
      
           
       } catch (SQLException ex) {
           Logger.getLogger(UserClass.class.getName()).log(Level.SEVERE, null, ex);
       }
       
        return validate;
    }
    
     /**
     *This method will generate an unique ID
     * @return id of users
     */
    protected static String generateId(){
        
        Set<String>storeId =(Set<String>) storeIDtoDB().keySet(); //return a Set of keys from the Map

        int uniqueId=new Random().nextInt(900)+100; //Generate random 3digits No
         ID=String.valueOf(uniqueId);//Pass the number as string value
       
        //Proccess a Unique Id 
        if(!storeId.contains(ID)){//if the key set Does not contain the generated id
            return ID;//return that unique id 
        }
       else{
            while(storeId.contains(ID)){//if the set contains the random Id genereated
                uniqueId=new Random().nextInt(900)+100;//reset the generated id till it's unique
                ID=String.valueOf(uniqueId);//pass the value as a String
            }
            return ID;//reurn the unique id found
        }

    }
   
    /**
     *This method will Store the Id in a Map to search them later
     * @return HashMap
     */
    /*
    protected static Map<String,String> storeId(){ 
        ArrayList<UserClass>myList=LogIn.readUsers("C:\\Users\\user\\Desktop\\Covid19Users.txt");
            
        HashMap<String,String>myMap=new HashMap<>();//Initializing Map
            for(UserClass i: myList)
            {
                myMap.put(i.getId(),i.getName());//Enter the Id as Keys and Name as Values. Name to be stored for later use.
            }
            //NOTE: For the history section in base of the key you can get the value (name) to display in the GUI form
      return myMap;
    }
    */
    protected static Map<String,String>storeIDtoDB(){
        Connection con=Covid19Application.dbConnect();
        HashMap<String,String>myMap=new HashMap<>();
        Statement st=null;
        ResultSet rs=null;
        try{
            st=con.createStatement();
            rs=st.executeQuery("SELECT * FROM users");
            while(rs.next()){
                String id= rs.getString("ID");
                String name=rs.getString("Name");
                myMap.put(id, name);
                System.out.println("ID: "+id+" Name: "+name);
            }
        
        } catch (SQLException ex) {
           Logger.getLogger(UserClass.class.getName()).log(Level.SEVERE, null, ex);
       }
        return myMap;
    }
    
    protected static Map<String,String>storeDBidAndZIP(){
        Connection con=Covid19Application.dbConnect();
        HashMap<String,String>myMap=new HashMap<>();
        Statement st=null;
        ResultSet rs=null;
        try{
            st=con.createStatement();
            rs=st.executeQuery("SELECT * FROM users");
            while(rs.next()){
                String id= rs.getString("ID");
                String zip=rs.getString("Zip");
                myMap.put(id, zip);
            }
        
        } catch (SQLException ex) {
           Logger.getLogger(UserClass.class.getName()).log(Level.SEVERE, null, ex);
       }
        return myMap;
    }
    
    protected static Map<String,String>storeDBemailAndID(){
        Connection con=Covid19Application.dbConnect();
        HashMap<String,String>myMap=new HashMap<>();
        Statement st=null;
        ResultSet rs=null;
        try{
            st=con.createStatement();
            rs=st.executeQuery("SELECT * FROM users");
            while(rs.next()){
                String email= rs.getString("Email");
                String id=rs.getString("ID");
                myMap.put(email, id);
                
            }
        
        } catch (SQLException ex) {
           Logger.getLogger(UserClass.class.getName()).log(Level.SEVERE, null, ex);
       }
        return myMap;
    }
    
     /**
     *This method will Store the Id as keys and Zip as values in a Map to access them later
     * @return HashMap
     */
    /*
    protected static Map<String,String> storeIdAndZip(){
        ArrayList<UserClass>myList=LogIn.readUsers("C:\\Users\\user\\Desktop\\Covid19Users.txt");
            
        HashMap<String,String>myMap=new HashMap<>();//Initializing Map
            for(UserClass i: myList)
            {
                myMap.put(i.getId(),i.getZip());//Enter the Id as Keys and ZIP as Values.
            }

      return myMap;
    }
    */
    /**
     *This method will Store the Id as values and email as keys in a Map to access them later
     * @return HashMap
     */
    /*
    protected static HashMap<String,String> storeEmailAndId(){
        ArrayList<UserClass>myList=LogIn.readUsers("C:\\Users\\user\\Desktop\\Covid19Users.txt");
            
        HashMap<String,String>myMap=new HashMap<>();//Initializing Map
            for(UserClass i: myList)
            {
                myMap.put(i.getEmail(),i.getId());//Enter the email as Keys and id as Values.
            }

      return myMap;
    }
    */
    
    /**
     * This Method Will Write The String Representation Of The Object
     * @return String value of this Object
     */
    
    @Override
    public String toString(){
        return this.id+" "+this.name+" "+this.email+" "+this.password+" "+this.zip+" "+this.surname;
    }
    
}
