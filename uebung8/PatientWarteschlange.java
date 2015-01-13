/**EXERCISE 8
 * @author LUCIE BECHTOLD / CYRIL WALLE 
 * @version 1.0
 */

import java.util.regex.*;
 
public class PatientenWarteschlange
{
    int size;
    Patient[] patientWarteSchlange;
    
    /**
     * Constructor
     */
    public PatientenWarteSchlange (int maxSize)
    {
        this.size = 0;
        this.patientWarteSchlange = new PatientWarteSchlange[maxSize];
    }
    
    /**
     * Method neuerPatient
     *
     * @param patient (Patient)
     */
    public void neuerPatient (Patient patient)
    {
        check(size < 10, "Warteliste ist voll");
        this.patientWarteSchlange[this.size] = patient;
        this.size++;
    }
    
    /**
     * Method neuerPatient
     *
     * @param patient (Patient)
     * @return naechster (Patient)
     */
    public Patient derNaechsteBitte ()
    {
        Patient naechster = patientWarteSchlange[0];
        
        for (int i = size ; i > 0 ; i--)
        {
            patientWarteSchlange[i - 1] = patientWarteSchlange[i];
        }
        
        return naechster;
    }
    
    /**
     * Method entfernePatient
     *
     * deletes a patient when entering its number from the waiting list
     *
     * @param patientNumber (int)
     */
    public String entfernePatient (int patientNummer)
    {
        int i = this.getPatientVonNummer(patientNummer);
        if (i == -1) {
        	return "Faillure";
        }
        for (int j = i ; j < this.size ; j++)
        {
            this.patientWarteSchlange[j] = this.patientWarteSchlange[j + 1];
        }
        this.size--;
        
        return "Patient geloescht: " + patientWarteSchlange[i].nummer + "\t" + patientWarteSchlange[i].name;
    }
        
    public String toString() {
        String res = ("Warteliste \nPnr \tName\n");
        
        for (int i = size ; i >= 0 ; i--)
        {
            res += Patient.nummer + "\t" + Patient.name + "\n";
        }
        
        return res;
    }
    
    /**
     * Method getPatientVonNummer
     * 
	 * finds the rank of the article in the table with its number
	 * 
	 * @param  patientNumber (int)
     * @return i (int) the rank of the article with the asked number
	 */
    public int getPatientVonNummer (int patientNummer)
    {
        for (int i = 0 ; i < this.size ; i++)
        {
            if (patientNummer == this.table[i].getNummer())
            {
                return i;
            }
        }
        return -1;
    }
    
    /**
     * Method check
     *
     * @param condition (boolean), message (String)
     * throws RuntimeError if condition false.
     */
    public static void check(boolean condition, String message)
    {
        if (!condition) {
            throw new Exception(message);
        }
    }
}