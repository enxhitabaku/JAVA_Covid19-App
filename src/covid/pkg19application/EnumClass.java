/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package covid.pkg19application;

/**
 *  Symptoms that can be encountered 
 *  <li>{@link #BREATHINGDIFFICULTY}</li>
 *  <li>{@link #TEMPERATURE}</li>
 *  <li>{@link #DRYCOUGH}</li>
 *  <li>{@link #SORETHROAT}</li>
 *  <li>{@link #DIARRHEA}</li>
 *  <li>{@link #TEMPERATURE}</li>
 *  <li>{@link #HEADACHE}</li>
 *  <li>{@link #FATIGUE}</li>
 *  <li>{@link #RUNNYNOSE}</li>
 *  <li>{@link #SORENESS}</li>
 *  <li>{@link #ANOSMIA}</li>
 * 
 */

/**
 * This Is An EnumarationClass: Will be used to store final values
 * @author Enxhi Tabaku
 */
enum EnumClass {
   
    // This will call enum constructor with one int argument 
    
    BREATHINGDIFFICULTY(40),
    TEMPERATURE(20),
    DRYCOUGH(20),
    SORETHROAT(10),
    DIARRHEA(3),
    HEADACHE(1),
    FATIGUE(1),
    RUNNYNOSE(1),
    SORENESS(1),
    ANOSMIA(2); //LOSS OF SMELL
    //MAx 99%

    
  
    /**
     * declaring private variable for getting values 
     */ 
    private final int symptoms; 
  
    /**
     * This method will get the @value symptoms value
     * @return symptoms
     */
    public int getSymptoms() 
    { 
        return this.symptoms; 
    } 
  
    /**
     * Enum Constructor
     * @param symptoms 
     */
    private EnumClass(int symptoms) 
    { 
        this.symptoms=symptoms;
    } 
    
}
