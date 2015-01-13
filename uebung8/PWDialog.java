/**EXERCISE 8
 * @author LUCIE BECHTOLD / CYRIL WALLE 
 * @version 1.0
 */

import java.util.regex.*;
 
public class PWDialog
{
    public void PWDialog (){}
    
    public void start() 
    {
        static final byte EXIT = 0;
        static final byte NEUER_PATIENT = 1;
        static final byte DER_NAECHSTE_BITTE = 2;
        static final byte ENTFERNEN_PATIENT = 3;
        
        byte antwort;
        
        PatientenWarteschlange patientenWarteschlange;
        
        int maxSize = askInt("Wie lange wollen Sie Ihren Wartenschlange ?");
        
        new PatientenWarteschlange(maxSize);
        
        do {
            System.out.println("\n\nWarteliste\n\t" +
            "Neuer Patient[" + NEUER_PATIENT + "]\n\t" +
            "EXIT[" + EXIT + "]\n");
            antwort = askByte("");
            tryThis(antwort);
            
            try
            {
                switch (answer)
                {
                    case NEUER_PATIENT:
                        this.neuerPatient();
                        break;
                        
                    case DER_NAECHSTE_BITTE:
                        this.derNaechsteBitte();
                        break;
                        
                    case ENTFERNEN_PATIENT:
                        this.entfernenPatient();
                        break;
                }
            } catch (Exception e)
            {
                System.out.println(e);
            }
        } while (antwort != EXIT);
    }
    
    public void neuerPatient () //new patient
    {
        int patientNummer = askInt("Geben Sie bitte den Patientnummer (zwischen 1000 und 9999). Beispiel :\n1549\tLeo, Marc\n\t");
        String patientName = askString("Geben Sie bitte den Patientname (Name und Vorname mit zuerst Grossbuchstabe, ein Komma und ein Leerzeichnen).");
        Patient patient = new patient(patientNummer,patientName);
    }
    
    public void derNaechsteBitte () //next patient
    {
        Patient naechster = patientWarteSchlange.derNaechsteBitte();
    }
    
    public void entfernenPatient () //delete patient
    {
        int patientNummer = askInt("Welchen Patient wollen Sie entfernen ? Geben Sie bitte den Patientnummer.");
        patientWarteSchlange.entfernenPatient(patientNummer);
    }
    
    /**
     * Method askByte
     * @param message (String)
     * @return (byte) the entered number.
     */
    public static byte askByte(String message) {
        byte input;
        try {
            input = Stdin.readlnByte(message);
        }catch (Exception e) {
            System.out.println("\nEnter a number between " + Byte.MIN_VALUE + " and " + Byte.MAX_VALUE + " !");
            input = askByte(message);
        }
        return input;
    }
    
    /**
     * Method askInt
     * @param message (String)
     * @return (int) the entered number.
     */
    public static int askInt(String message) {
        int input;
        try {
            input = Stdin.readlnInt(message);
        }catch (Exception e) {
            System.out.println("\nEnter a number between " + Integer.MIN_VALUE + " and " + Integer.MAX_VALUE + " !");
            input = askInt(message);
        }
        return input;
    }
    
    /**
     * Method askString
     * @param message (String)
     * @return (String) the entered number.
     */
    public static String askString(String message) {
        byte input;
        try {
            input = Stdin.readlnString(message);
        }catch (Exception e) {
            System.out.println("\nFailure : wrong string");
            input = askString(message);
        }
        return input;
    }
}