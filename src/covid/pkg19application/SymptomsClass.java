/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package covid.pkg19application;

/**
 * This class store symptoms info
 * @author Enxhi Tabaku
 */
public class SymptomsClass {
      
    
    private String ID;
    private String RESULT;
    private String BREATHINGDIFFICULTY;
    private String TEMPERATURE;
    private String DRYCOUGH;
    private String SORETHROAT;
    private String DIARRHEA;  
    private String FATIGUE;
    private String HEADACHE;
    private String RUNNYNOSE;
    private String SORENESS;          
    private String ANOSMIA;

    /**
     *
     * @param ID store user id
     * @param BREATHINGDIFFICULTY store user symptom input
     * @param TEMPERATURE store user symptom input
     * @param DRYCOUGH store user symptom input
     * @param SORETHROAT store user symptom input
     * @param DIARRHEA store user symptom input
     * @param FATIGUE store user symptom input
     * @param HEADACHE store user symptom input
     * @param RUNNYNOSE store user symptom input
     * @param SORENESS store user symptom input
     * @param ANOSMIA store user symptom input
     * @param RESULT store user symptom input
     */
    public SymptomsClass(String ID,String BREATHINGDIFFICULTY, String TEMPERATURE,
            String DRYCOUGH, String SORETHROAT, String DIARRHEA, String FATIGUE, 
            String HEADACHE, String RUNNYNOSE, String SORENESS, String ANOSMIA,String RESULT )
    {
        this.ID=ID;
        this.ANOSMIA=ANOSMIA;
        this.BREATHINGDIFFICULTY=BREATHINGDIFFICULTY;
        this.DIARRHEA=DIARRHEA;
        this.DRYCOUGH=DRYCOUGH;
        this.FATIGUE=FATIGUE;
        this.HEADACHE=HEADACHE;
        this.RUNNYNOSE=RUNNYNOSE;
        this.SORENESS=SORENESS;
        this.SORETHROAT=SORETHROAT;
        this.TEMPERATURE=TEMPERATURE;
        this.RESULT=RESULT;
    }
    
    /**
     * This Constructor Will Take As Paramether A String And Split It With The Delimeter ","
     * @param str the string to read from file 
     */
    public SymptomsClass(String str){
                
        String[]tokenize=str.split(",");//split the long string
        this.ID=tokenize[0];
        this.BREATHINGDIFFICULTY=tokenize[1];
        this.TEMPERATURE=tokenize[2];
        this.DRYCOUGH=tokenize[3];
        this.SORETHROAT=tokenize[4];
        this.HEADACHE=tokenize[5];
        this.RUNNYNOSE=tokenize[6];
        this.FATIGUE=tokenize[7];
        this.SORENESS=tokenize[8];
        this.DIARRHEA=tokenize[9];
        this.ANOSMIA=tokenize[10];
        this.RESULT=tokenize[11];
        
    }
 

    /**
     *
     * @return String to get the input
     */
    protected String getBREATHINGDIFFICULTY() {
        return BREATHINGDIFFICULTY;
    }

    /**
     *
     * @param BREATHINGDIFFICULTY to set the corresponding value
     */
    protected void setBREATHINGDIFFICULTY(String BREATHINGDIFFICULTY) {
        this.BREATHINGDIFFICULTY = BREATHINGDIFFICULTY;
    }

    /**
     *
     * @return String the input
     */
    protected String getTEMPERATURE() {
        return TEMPERATURE;
    }

    /**
     *
     * @param TEMPERATURE the input
     */
    protected void setTEMPERATURE(String TEMPERATURE) {
        this.TEMPERATURE = TEMPERATURE;
    }

    /**
     *
     * @return String to get the input
     */
    protected String getDRYCOUGH() {
        return DRYCOUGH;
    }

    /**
     *
     * @param DRYCOUGH to set the corresponding value
     */
    protected void setDRYCOUGH(String DRYCOUGH) {
        this.DRYCOUGH = DRYCOUGH;
    }

    /**
     *
     * @return String to get the input
     */
    protected String getSORETHROAT() {
        return SORETHROAT;
    }

    /**
     *
     * @param SORETHROAT to set the corresponding value
     */
    protected void setSORETHROAT(String SORETHROAT) {
        this.SORETHROAT = SORETHROAT;
    }

    /**
     *
     * @return String to get the input
     */
    protected String getDIARRHEA() {
        return DIARRHEA;
    }

    /**
     *
     * @param DIARRHEA to set the corresponding value
     */
    protected void setDIARRHEA(String DIARRHEA) {
        this.DIARRHEA = DIARRHEA;
    }

    /**
     *
     * @return String to get the input
     */
    protected String getFATIGUE() {
        return FATIGUE;
    }

    /**
     *
     * @param FATIGUE to set the corresponding value
     */
    protected void setFATIGUE(String FATIGUE) {
        this.FATIGUE = FATIGUE;
    }

    /**
     *
     * @return String to get the input
     */
    protected String getHEADACHE() {
        return HEADACHE;
    }

    /**
     *
     * @param HEADACHE to set the corresponding value
     */
    protected void setHEADACHE(String HEADACHE) {
        this.HEADACHE = HEADACHE;
    }

    /**
     *
     * @return String
     */
    protected String getRUNNYNOSE() {
        return RUNNYNOSE;
    }

    /**
     *
     * @param RUNNYNOSE to set the corresponding value
     */
    protected void setRUNNYNOSE(String RUNNYNOSE) {
        this.RUNNYNOSE = RUNNYNOSE;
    }

    /**
     *
     * @return String
     */
    protected String getSORENESS() {
        return SORENESS;
    }

    /**
     *
     * @param SORENESS to set the corresponding value
     */
    protected void setSORENESS(String SORENESS) {
        this.SORENESS = SORENESS;
    }

    /**
     *
     * @return String
     */
    protected String getANOSMIA() {
        return ANOSMIA;
    }

    /**
     *
     * @param ANOSMIA to set the corresponding value
     */
    protected void setANOSMIA(String ANOSMIA) {
        this.ANOSMIA = ANOSMIA;
    }

    /**
     *
     * @return String
     */
    protected String getID() {
        return ID;
    }

    /**
     *
     * @param ID to set the corresponding value
     */
    protected void setID(String ID) {
        this.ID = ID;
    }
    
    protected String getRESULT() {
        return RESULT;
    }

    protected void setRESULT(String RESULT) {
        this.RESULT = RESULT;
    }
     
     /**
      * This Method Will Print The String Representation of the Object spliting via a delimeter(,) .
      * @return String Object Representation 
      */
    @Override
    public String toString(){
        return this.ID+","+this.BREATHINGDIFFICULTY+","+this.TEMPERATURE+","
                +this.DRYCOUGH+","+this.SORETHROAT+","+this.HEADACHE+","
                +this.RUNNYNOSE+","+this.FATIGUE+","+this.SORENESS+","
                +this.DIARRHEA+","+this.ANOSMIA+","+this.getRESULT();
    }


}
