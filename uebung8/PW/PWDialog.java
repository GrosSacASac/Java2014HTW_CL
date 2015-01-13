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
        static final byte PATIENTEN_WARTENSCHLANGE = 1;
        
        byte antwort;
        
        do {
            System.out.println("\n\nWarteliste\n\t" +
            "Patientenwarteliste[" + PATIENTEN_WARTENSCHLANGE + "]\n\t" +
            "EXIT[" + EXIT + "]\n");
            antwort = askByte("");
            tryThis(antwort);
        } while (antwort != EXIT);
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
}