/**EXERCISE 8
 * @author LUCIE BECHTOLD / CYRIL WALLE 
 * @version 1.0
 */

import java.util.regex.*;
 
public class PatientenWarteschlange
{
    int size;
    Patient[] warteSchlange;
    
    /**
     * Constructor
     */
    public PatientenWarteschlange (int maxSize)
    {
        this.size = 0;
        this.warteSchlange = new patient[maxSize];
    }
    
    /**
     * Method newPatient
     *
     * @param patient (Patient)
     */
    public void neuerPatient (Patient patient)
    {
        check(size < 10, "Warteliste ist voll");
        this.warteSchlange[this.size] = patient;
        this.size++;
    }
    
    public void derNaechsteBitte (int patientNumber)
    {
        for ( int i = size ; i < 
    }
    
    /**
     * Method removePatient
     *
     * deletes a patient when entering its number from the waiting list
     *
     * @param patientNumber (int)
     */
    public void entfernePatient (int patientNumber)
    {
        int i = this.patientFromNumber(patientNumber);
        if (i == -1) {
        	return;
        }
        for (int j = i ; j < this.size ; j++)
        {
            this.patient[j] = this.patient[j + 1];
        }
        this.size--;
    }
    
    /**
     * Method patientFromNumber
     * 
	 * finds the rank of the article in the table with its number
	 * 
	 * @param  patientNumber (int)
     * @return i (int) the rank of the article with the asked number
	 */
    public patientFromNumber (int patientNumber)
    {
        for (int i=0; i<this.size ; i++)
        {
            if (patientNumber == this.table[i].getNumber())
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
            throw new RuntimeException(message);
        }
    }
}