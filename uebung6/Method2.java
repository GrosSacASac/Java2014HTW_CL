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
    public static String countStringsWithUniCaseLetters (String[] strings)
    {
        int letters = 0;
        int sizeTable = strings.length;
        for (int i = 0; i < sizeTable; i++)
        {
            if (isOnlyLetter(strings[i]) == true)
            {
                letters++;
            }
        }
        return  "Strings constituated only of letters : " + letters;
    }
    
     /**
    * Method isOnlyLetter
    * 
    * @param  string (String), sizeTable (int)
    * @return isLetter (boolean)
    */
    public static boolean isOnlyLetter (String strings)
    {
        for (int i = 0; i < strings.length(); i++)
        {
            if (!Character.isLetter(strings.charAt(i)))
            {
                return false;
            }
        }
        return true;
    }
}