/**
 * @author LUCIE BECHTOLD / CYRIL WALLE 
 * @version 2.0
 */
public class Method1
{
    
    
     /**
    * Method check
    *
    * @param condition (boolean), message (String)
    * throws AssertionError if condition false.
    */
    public static void check(boolean condition, String message)
    {
        if (!condition) {
            throw new AssertionError(message);
        }
    }
}