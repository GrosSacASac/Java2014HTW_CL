/**Description of the article
 * @author LUCIE BECHTOLD / CYRIL WALLE 
 * @version 2.0
 */
public class Stock
{
    int[] table;
    int N;
    
    public void newArticle ()
    {
        this.table[this.N] = new Article();
        this.N++;
    }
    
    
     /**
    * Method solveLinearEquality
    *
    * finds x where ax + b = 0,
    * a,b are given reals
    *
    * @param a (double), b (double)
    * @return (String) solution of a linear equality 
    */
    public void deleteArticle (int i)
    {
        for (int j=i ; j<this.N ; j++)
        {
            this.table[j] = this.table [j+1];
        }
        this.N--;
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
