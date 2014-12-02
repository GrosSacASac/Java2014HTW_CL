/**Description of the article
 * @author LUCIE BECHTOLD / CYRIL WALLE 
 * @version 2.0
 */
public class Depot
{
    private Article[] table;
    private int size;//how many articles in table 
    private,final static int DEFAULT_MAX_SIZE = 1000;
    
     /**
    * Constructor Depot (with all parameters)
    * 
    * @param  maxSize (int)
    */
    public Depot (int maxSize)
    {
        this.size = 0;
        this.table = new Article[maxSize];
    }
    
     /**
    * Constructor Depot (with no specific parameters)
    */
    public Depot ()
    {
        this(DEFAULT_MAX_SIZE);
    }
    
     /**
    * Method addArticle
    * 
    * adds a new article
    */
    public void addArticle (Article article)
    {
        this.table[this.size] = article;
        this.size++;
    }
    
     /**
    * Method deleteArticle
    *
    * deletes an article when entering its number
    *
    * @param articleNumber (int)
    */
    public void removeArticle (int articleNumber)
    {
        int i = this.articleFromNumber(articleNumber);
        if (i == -1) {
        	return;
        }
        for (int j = i ; j < this.size ; j++)
        {
            this.table[j] = this.table[j + 1];
        }
        this.size--;
    }
    
     /**
    * Method articleFromNumber
    * 
	* finds the rank of the article in the table with its number
	* 
	* @param  articleNumber (int)
    * @return i (int) the rank of the article with the asked number
	*/
    public articleFromNumber (int articleNumber)
    {
        for (int i=0; i<this.size ; i++)
        {
            if (articleNumber == this.table[i].getNumber())
            {
                return i;
            }
        }
        return -1;
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