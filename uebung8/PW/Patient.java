/**EXERCISE 8
 * @author LUCIE BECHTOLD / CYRIL WALLE 
 * @version 1.0
 */

import java.util.regex.*;
 
public class Patient
{
    static int nummer;
    static String name;
    
    /**
     * Constructor
     */
    public Patient (int nummer, String name)
    {
        check(nummer<10000 && nummer>999, "Das Patientnummer muss 4-stellig sein.");
        //check(name.matches("([A-Z]{1}[a-z]+, [A-Z]{1}[a-z]+)"), "Schlechten Format.");
        
        this.nummer = nummer;
        this.name = name;
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