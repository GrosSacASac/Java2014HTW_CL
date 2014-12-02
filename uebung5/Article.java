/**Description of the article
 * @author LUCIE BECHTOLD / CYRIL WALLE 
 * @version 2.0
 */
public class Article
{
   
    private String number;
    private String description;
    private int stock;
    private double price;
    final static int STOCK_NOT_SPECIFIED = 0;

    //constructor
    public Article(String number, String description, int stock)
    {
        check(number < 10000 && number > 999, "The article number must be 4-digits long.");
        check(stock >= 0 : "Needs to be positive");
        check(price > 0 , "The price must be superior as 0");
        
        this.number = number; //number
        this.setDescription(description); //description
        this.stock = stock; //stock
        this.price = price; //price
    }
    
    public Article(String number, String description)
    {
        this(number, description, STOCK_NOT_SPECIFIED);
    }

     /**
    * Method reduceStock
    * 
    * reduces the stock of a certain amount
    * 
    * @param  amount (int)
    */
    public void reduceStock(int amount)
    {
        check(amount > 0 , "Needs to be positive");
        this.stock = this.stock + amount;
    }
    
	 /**
    * Method augmentStock
    * 
    * augments the stock of a certain amount
    * 
    * @param  amount (int)
    */
    public void augmentStock(int amount) 
    {
        check(amount > 0 , "Needs to be positive");
        check(amount <= this.stock , "Impossible to deduce more than available");
        this.stock = this.stock - amount;
    }
    
     /**
    * Method toString
    * 
    * prints the content of the article
    */
    public String toString()
    {
        return("Article: " + this.number +
               " description: " + this.description +
               " stock: " + this.stock);
    }
    
     /**
    * Method setDescription
    * 
    * @param description (String)
    */
    public void setDescription(String description) 
    {
        check(description != null && !description.isEmpty() , "Cannot be empty");
        this.description = description;
    }
    
     /**
    * Method getNumber
    */
    public String getNumber() 
    {
        return this.number;
    }
    
     /**
    * Method getDescription
    */
    public String getDescription() 
    {
        return this.description;
    }
    
     /**
    * Method getStock
    */
    public int getStock() 
    {
        return this.stock;
    }
    
     /**
    * Method check
    *
    * @param condition (boolean), message (String)
    * throws RuntimeError if condition false.
    */
    public static void check(boolean condition, String message)
    {
        if (!condition) {
            throw new RuntimeError(message);
        }
    }
}