/**Description of the article
 * @author LUCIE BECHTOLD / CYRIL WALLE 
 * @version 2.0
 */
public class Stock
{
    int[] table;
    int N;
    
     /**
    * Method newArticle
    * 
    * creates a new article
    */
    public void newArticle ()
    {
        this.table[this.N] = new Article();
        this.N++;
    }
    
     /**
    * Method deleteArticle
    *
    * deletes an article
    *
    * @param i (int)
    */
    public void deleteArticle (int articleNumber)
    {
        int i = this.getArticleByNumber(articleNumber);
        for (int j=i ; j<this.N ; j++)
        {
            this.table[j] = this.table [j+1];
        }
        this.N--;
    }
    
	/**
    * Method reduceStock
    * 
	* reduces the stock of a certain amount
	* 
	* @param  amount (int)
	*/
	public void reduceStock (int amount)
	{
        check (amount>0 , "Needs to be positive");
		this.stock = this.stock + amount;
	}
    
	/**
    * Method augmentStock
    * 
	* augments the stock of a certain amount
	* 
	* @param  amount (int)
	*/
	public void augmentStock (int amount) 
	{
        check (amount>0 , "Needs to be positive");
        check (amount<=stock , "Impossible to deduce more than available");
		this.stock = this.stock - amount;
	}
    
     /**
    * Method augmentPrice
    * 
	* augments the price of a certain percentage
	* 
	* @param  percentage (byte)
	*/
    public void augmentPrice (byte percentage)
    {
        percentage /= 100;
        price += price*percentage;
    }
    
     /**
    * Method reducePrice
    * 
	* reduces the price of a certain percentage
	* 
	* @param  percentage (byte)
	*/
    public void reducePrice (byte percentage)
    {
        percentage /= 100;
        price -= price*percentage;
    }
    
     /**
    * Method getArticleByNumber
    * 
	* finds the rank of the article in the table with its number
	* 
	* @param  articleNumber (int)
    * @return i (int) the rank of the article with the asked number
	*/
    public getArticleByNumber (int articleNumber)
    {
        for (int i=0; i<N ; i++)
        {
            if (articleNumber == table[i].getNumber())
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
