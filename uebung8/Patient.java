/**EXERCISE 8
 * @author LUCIE BECHTOLD / CYRIL WALLE 
 * @version 1.0
 */

import java.util.regex.*;
 
public class Patient
{
    int nummer
    String name
    
    /**
     * Constructor
     */
    public Patient (int nummer, String name)
    {
        check(nummer<10000 && nummer>999, "Das Patientnummer muss 4-stellig sein.");
        check();
        
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