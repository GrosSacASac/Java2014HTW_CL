/**
 * @author LUCIE BECHTOLD / CYRIL WALLE 
 * @version 2.0
 */
public class Method2
{
    final static SIZE_TABLE_MAX = 100;
    String[SIZE_TABLE_MAX] string;
    int sizeTable = 0;
    
     /**
    * Constructor Article (with all parameters)
    *
    * Creates a new table containing all the strings to use.
    * 
    * @param  text (String), sizeTable (int)
    */
    public Method2 (String text, int sizeTable)
    {
        this.string[sizeTable] = text;
        sizeTable++;
    }
    
     /**
    * Method countUpperAndLowerCase
    * 
    * @param  string (String[]), sizeTable (int)
    */
    public String countUpperAndLowerCase (string[] string, int sizeTable)
    {
        int upperCase = 0;
        int lowerCase = 0;
        for (int i = 0; i <= sizeTable; i++)
        {
            if (isUpperCase(string,sizeTable) == true)
            {
                upperCase++;
            }
            else if (isLowerCase(string, sizeTable) == true)
            {
                lowerCase++;
            }
        }
        return  "Uppercase strings : " + upperCase + 
                "\nLowercase strings : " + lowerCase;
    }
    
     /**
    * Method isUpperCase
    * 
    * @param  string (String), sizeTable (int)
    * @return isUpperCase (boolean)
    */
    public boolean isUpperCase (String string, int sizeTable)
    {
        for (int i = 0; i <= string.length(); i++)
        {
            if (isUpperCase(string.charAt(i)) == false)
            {
                return false;
            }
        }
        return true;
    }
    
     /**
    * Method isLowerCase
    * 
    * @param  string (String), sizeTable (int)
    * @return isLowerCase (boolean)
    */
    public void isLowerCase (String string, int sizeTable)
    {
        for (int i = 0; i <= string.length(); i++)
        {
            if (isLowerCase(string.charAt(i)) == false)
            {
                return false;
            }
        }
        return true;
    }
        
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