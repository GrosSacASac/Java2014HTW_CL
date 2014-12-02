/**Description of the article
 * @author LUCIE BECHTOLD / CYRIL WALLE 
 * @version 2.0
 */
public class Article
{
   
    private int number;
    private String description;
    private int stock;
    private double price;
    private final static int STOCK_NOT_SPECIFIED = 0;

     /**
    * Constructor Article (with all parameters)
    * 
    * @param  number (int), price (double), stock (int), description (String)
    */
    public Article(int number, double price, int stock, String description)
    {
        check(number < 10000 && number > 999, "The article number must be 4-digits long.");
        check(stock >= 0 : "Needs to be positive");
        
        this.number = number; //number
        this.setPrice(price); //price
        this.stock = stock; //stock
        this.setDescription(description); //description
    }
    
     /**
    * Constructor Article (with 3 parameters)
    * 
    * @param  number (int), price (double), description (String)
    */
    public Article(int number, double price, String description)
    {
        this(number, price, STOCK_NOT_SPECIFIED, description);
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
        check (amount <= stock , "Impossible to deduce more than available");
		this.stock = this.stock - amount;
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
		this.stock = this.stock + amount;
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
    * Method setPrice
    * 
    * @param price (double)
    */
    public void setPrice(double price) 
    {
        check(price > 0 , "The price must be superior as 0");
        this.price = price;
    }
    
     /**
    * Method getPrice
    */
    public double getPrice() 
    {
        return this.price;
    }
    
     /**
    * Method getNumber
    */
    public int getNumber() 
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