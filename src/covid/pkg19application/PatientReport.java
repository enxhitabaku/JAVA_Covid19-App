/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package covid.pkg19application;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 * This class shows user symptoms history
 * @author Enxhi Tabaku
 */
public class PatientReport extends javax.swing.JFrame {
    
    //Static values to be used multiple times
     protected static String res="*";
     protected static final HashMap<String,String>MAPID=(HashMap<String,String>) UserClass.storeDBemailAndID();
     protected static String ID=MAPID.get( LogIn.email );
     protected static Integer avg=0;
    /**
     * Creates new form PatientReport
     */
    public PatientReport() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Covid-19 App");
        setMinimumSize(new java.awt.Dimension(898, 508));
        setResizable(false);
        getContentPane().setLayout(null);

        jTextArea1.setEditable(false);
        jTextArea1.setBackground(new java.awt.Color(204, 255, 255));
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("DialogInput", 0, 18)); // NOI18N
        jTextArea1.setForeground(new java.awt.Color(0, 0, 0));
        jTextArea1.setRows(5);
        String text=String.valueOf(
            writeToTextArea(
                readHistory(
                    "C:\\Users\\user\\Desktop\\Users_Report.txt")) );
        jTextArea1.setText(text);
        jTextArea1.setToolTipText("");
        jTextArea1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jTextArea1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jTextArea1.setRequestFocusEnabled(false);
        jTextArea1.setSelectedTextColor(new java.awt.Color(51, 51, 51));
        jTextArea1.setSelectionColor(new java.awt.Color(255, 153, 0));
        jScrollPane1.setViewportView(jTextArea1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(0, 40, 900, 470);

        jButton1.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jButton1.setText("Back");
        jButton1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.setFocusable(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(827, 0, 70, 30);

        jLabel1.setBackground(new java.awt.Color(153, 255, 255));
        jLabel1.setFont(new java.awt.Font("Aharoni", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 102, 51));
        String header=writeHeader();
        jLabel1.setText(header);
        jLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel1.setOpaque(true);
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 900, 45);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        MainMenu menu=new MainMenu();
        
        menu.setVisible(true);
        menu.setLocationRelativeTo(null);
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed
    
    /**
     *This Method Will Read from file and store to the list the id,zip and avg
     * @param pathName the path of the respective file
     * @return ArrayList of Strings
     */
   
    protected static ArrayList<SymptomsClass> readHistory(String pathName){
        //method to read the File if the path is passed as paramether 
        ArrayList<SymptomsClass> fileHistory = new ArrayList<>();
        
        try{
            File file=new File(pathName);
            Scanner read=new Scanner(file);
            
            while(read.hasNextLine()){
                String data = read.nextLine();  //Read the next line of the file and store it to the variable
                SymptomsClass symptom=new SymptomsClass(data);  //call the sring parametherized constructor
                
                if(ID.equals(symptom.getID() ) ) //check if the id matches the one in the file
                {    
                    fileHistory.add(symptom);   //store the symptoms to the list
                }    
            }//End of while
            read.close();   
        }catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null,"Creating file...","File Not Found",JOptionPane.ERROR_MESSAGE); //File not Found    
            e.printStackTrace();
        }
        catch(IndexOutOfBoundsException e){
            JOptionPane.showMessageDialog(null,"An error occurred.","ERROR INDEX OUT OF BOUNDURY",JOptionPane.ERROR_MESSAGE); //File not Found    
            e.printStackTrace();
        }
        catch(NullPointerException e){
            e.printStackTrace();
        }

        return fileHistory;//return a List of the items in the file witch match the user id.
    }

    /**
     *This Method will write to the text Area
     * @param myList an ArrayList of SymptomsClass Object
     * @return StringBuffer
     */
   
    protected StringBuffer writeToTextArea(ArrayList<SymptomsClass>myList) {
         
        StringBuffer str=new StringBuffer();//Initializng Str Buffer to store the Strings
        
        SymptomsClass[]myArray=myList.toArray(new SymptomsClass[myList.size()]);//from List to Array
            if(myArray.length==0)
            {
                str.append("No Symptoms Entered Yet . . .");
            }
            else
            {
                splitAndWrite(str, myArray);
            }    
        return str;//return the string buffer, this value will be used to the jTextArea.setText() method, to display the text in GUI form.
    }

    /**
     * This Method Will Search For The Lines Of Text Which Match The ID.
     * This Method Will Split The Line Of Text Returned From The  File And Append Them To The String Buffer 
     * @param str the string to be splited 
     * @param myArray the array of Object to loop through
     * @return StringBuffer 
     */
    protected StringBuffer splitAndWrite(StringBuffer str, SymptomsClass[]myArray){

        String word="s";
        ArrayList<Integer>myAvg=new ArrayList<>();//Initializing ArrayList to store the values for computing average 
        for(int i=0;i<myArray.length;i++)//loop through myArray to get all the elements of it, they will be Symptoms of the user (Objects).
                {
                    
                    str.append("Day ").append(i+1).append(" ");//Append values to str buffer. EveryTime the user submitted a syptom is a day more.
                    
                    String[]tokenize=String.valueOf(myArray[i]).split(",");//split the lines of myArray into tokens

                    for(int j=1;j<tokenize.length;j++)//Start from 1 to not include the ID and loop through the tokens
                    {
                        if(j==11)//we know that the 11th index token will be RESULT
                        {
                            str.append(tokenize[j]).append("%\n");//append a % sign near the result and a new line
                            Integer intValueStr=Integer.valueOf(tokenize[j]);
                            myAvg.add(intValueStr);    //Add Integer to the list so later will be computed the avarage to be displayed
                        }
                        if( !tokenize[j].equals("") && j!=11)//if no null values and not the 11index
                        {
                            str.append(tokenize[j]).append("  "); //append the tokens to the string buffer
                        }
                        
                    }//End nested For
                }//End For
        perBukuri(str, myAvg);//to display some text,the average .
                
        return str;
    }

    /**
     * This Method Will Compute The Average of probability percentages 
     * @param myAvg ArrayList to store the values for computing average
     * @return avg
     */
    protected Integer calculateAvarage(ArrayList<Integer>myAvg) {
        Integer sum=0;
        Integer avg=0;
        if( !myAvg.isEmpty() )
        {
            for(int i=0;i<myAvg.size();i++)
                sum+=myAvg.get(i);
            
            avg=sum/myAvg.size();
        }
        return avg;
    }

    /**
     * This Method Will Display Some Line Of Text Into The Text Area
     * @param str StringBuffer to append different String values
     * @param myAvg ArrayList of Integers to store values for computing average
     * @return StringBuffer
     */
    protected StringBuffer perBukuri(StringBuffer str,ArrayList<Integer>myAvg){
        //Strings to be appended
                String text1="\n\n Computing Avarage . . . \n\n";
                String text2="               ";
                String text3="% Probability To Have COVID-19";
                avg=calculateAvarage(myAvg);
                //Append the average to the end of str buffer
                return str.append(text1).append(text2).append(avg).append(text3);
    }

    /**
     * This Method Will Write Into The jLabel a.k.a Header Of The History Page
     * @return String value
     */
    protected String writeHeader(){
        
        HashMap<String,String>myMap=(HashMap<String,String>) UserClass.storeIDtoDB(); //Import the hashMap from FirstPage Class
        
        return "Welcome, "+myMap.get(ID)+" !  Have a look at your history . . .";//Get the value of the specific key a.k.a the Name of the corresponding ID 
    }

    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PatientReport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PatientReport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PatientReport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PatientReport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PatientReport().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    protected javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
