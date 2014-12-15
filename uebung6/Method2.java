/**
 * @author LUCIE BECHTOLD / CYRIL WALLE 
 * @version 2.0
 */
public class Method2
{
    final static SIZE_TABLE_MAX = 100;
    String[SIZE_TABLE_MAX] string;
    //int sizeTable = 0;
    
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
        //sizeTable++;
    }
    
     /**
    * Method countUpperAndLowerCase
    * 
    * @param  string (String[]), sizeTable (int)
    */
    public String countLetters (string[] string, int sizeTable)
    {
        int letters = 0;
        for (int i = 0; i < sizeTable; i++)
        {
            if (isUpperCase(string,sizeTable) == true)
            {
                letters++;
            }
        }
        return  "Strings constituated only of letters : " + letters;
    }
    
     /**
    * Method isLetter
    * 
    * @param  string (String), sizeTable (int)
    * @return isLetter (boolean)
    */
    public boolean isLetter (String string, int sizeTable)
    {
        for (int i = 0; i <= string.length(); i++)
        {
            if (isLetter(string.charAt(i)) == false)
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