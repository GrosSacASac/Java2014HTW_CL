/**
 * @author LUCIE BECHTOLD / CYRIL WALLE 
 * @version 2.0
 */
public class Method2
{
    final static SIZE_TABLE_MAX = 100;
    String[SIZE_TABLE_MAX] string;
    int sizeTable = 0;
    
    public Method2 (String text)
    {
        this.string[sizeTable] = text;
        sizeTable++;
    }
    
    public String countUpperAndLowerCase ()
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