/**Description of the article
 * @author LUCIE BECHTOLD / CYRIL WALLE 
 * @version 2.0
 */
public class Collection
{
    Article[] table;
    int N;
    final static int DEFAULT_MAX_SIZE = 1000;
    
    public collection (int maxSize)
    {
        this.N = 0;
        this.table = new Article[maxSize];
    }
    
    public collection ()
    {
        this(DEFAULT_MAX_SIZE);
    }
    
     /**
    * Method newArticle
    * 
    * creates a new article
    */
    public void newArticle (Article article)
    {
        this.table[this.N] = article;
        this.N++;
    }
    
     /**
    * Method deleteArticle
    *
    * deletes an article when entering its number
    *
    * @param articleNumber (int)
    */
    public void deleteArticle (int articleNumber)
    {
        int i = this.getArticleFromNumber(articleNumber);
        for (int j=i ; j<this.N ; j++)
        {
            this.table[j] = this.table [j+1];
        }
        this.N--;
    }
    
     /**
    * Method getArticleFromNumber
    * 
	* finds the rank of the article in the table with its number
	* 
	* @param  articleNumber (int)
    * @return i (int) the rank of the article with the asked number
	*/
    public getArticleFromNumber (int articleNumber)
    {
        for (int i=0; i<this.N ; i++)
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