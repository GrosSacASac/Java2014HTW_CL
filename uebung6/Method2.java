/**Second part of the exercise
 * @author LUCIE BECHTOLD / CYRIL WALLE 
 * @version 2.0
 */
 
public class Method2
{
    final static int SIZE_TABLE_MAX = 100;
    String[] string;
    
     /**
    * Method countUpperAndLowerCase
    * 
    * @param  string (String[]), sizeTable (int)
    */
    public static String countLetters (String[] string)
    {
        int letters = 0;
        int sizeTable = table.length;
        for (int i = 0; i < sizeTable; i++)
        {
            if (isCharLetter(string[i],sizeTable) == true)
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
    public static boolean isCharLetter (String string)
    {
        for (int i = 0; i < string.length(); i++)
        {
            if (!Character.isLetter(string.charAt(i)))
            {
                return false;
            }
        }
        return true;
    }
}