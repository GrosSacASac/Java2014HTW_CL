/**Dialog Depot
 * @author LUCIE BECHTOLD / CYRIL WALLE 
 * @version 2.0
 */

 
 import de.htw.saarland.stl.Stdin;

public class DepotDialog
{
    //for 1 article
    final byte REDUCE_STOCK = 1;
    final byte AUGMENT_STOCK = 2;
    final byte SET_DESCRIPTION = 3;
    final byte SET_PRICE = 4; 
    //for entire depot
    final byte SELECT_ARTICLE = 5;  
    final byte APPLY_PERCENTAGE_ALL = 6;  
    final byte REMOVE_ARTICLE = 7;  
    final byte ADD_ARTICLE = 8;
    final byte EXIT = 0;
    
    private Depot depot;
    
    public void start () {
        
        this.createNewDepot();
        this.editDepotLoop();
    }
    
    private void editDepotLoop() {
        byte answer;
        do {
        
            System.out.println("Your Depot : " + this.depot + 
            "\n----------\nChoose :\n\t[ " + SELECT_ARTICLE +
            " ]\tSELECT_ARTICLE\n\t[ "  + APPLY_PERCENTAGE_ALL +
            " ]\tAPPLY_PERCENTAGE_ALL\n\t[ " + REMOVE_ARTICLE +
            " ]\tREMOVE_ARTICLE\n\t[ " + EXIT + " ]\tExit\n");
            answer = Stdin.askByte();
            
            try
            {
                switch (answer)
                {
                    case SELECT_ARTICLE:
                        this.editArticle();
                        break;
                    
                    case APPLY_PERCENTAGE_ALL:
                        this.applyPercentageAll();
                        break;
                    
                    case REMOVE_ARTICLE:
                        this.removeArticle();
                        break;
                        
                    case ADD_ARTICLE:
                        this.addArticle();
                        break;
                    case CHANGE_PRIZE_NEGATIVE:
                        break;
                }
            } catch (Exception e)
            {
                System.out.println(e);
            }
        } while (answer != EXIT);
    }
    
    public void editArticle() {
    
        System.out.println("Create article : \n");
        Article article = this.depot.articleFromNumber(askInt("Give number of the article you want to edit"));
        if (article == null) {
            System.out.println("Not found : \n");
            return;
        }
        do {
            System.out.println("Your Article : " + article +
            "\n----------\nChoose :\n\t[ " + REDUCE_STOCK +
            " ]\tReduce the stock\n\t[ "  + AUGMENT_STOCK +
            " ]\tAugment the stock\n\t[ " + SET_DESCRIPTION +
            " ]\tSet the description\n\t[ " + EXIT +
            " ]\tExit\n");
            answer = Stdin.askByte("");
            
            try
            {
                switch (answer)
                {
                    case REDUCE_STOCK:
                        this.reduceStock(article);
                        break;
                    
                    case AUGMENT_STOCK:
                        this.augmentStock(article);
                        break;
                    
                    case SET_DESCRIPTION:
                        this.setDescription(article);
                        break;
                        
                    case SET_PRICE:
                        this.setPsetPrice(article)
                        break;
                }
            } catch (AssertionError e) {
                System.out.println(e);
            }
        } while (answer != EXIT);
    }
    
    
     /**
    * 
    */
    public void applyPercentageAll () //
    {
        double percentage = askDouble("Percentage : \n\t");
        this.depot.applyPercentageAll(percentage);
    }
    
     /**
    * 
    */
    public void removeArticle () //
    {
        double number = askInt("Article Number to remove : \n\t");
        this.depot.removeArticle(number);
    }
    
     /**
    * 
    */
    public void addArticle () //
    {
        Article article = this.createNewArticle();
        this.depot.addArticle(article);
    }
    
    public Article createNewArticle ()
    {
        Article article;
        do
        {
            try 
            {
                int answer = System.readlnByte("Creation of a new article...\nDo you want to enter a specific stock ? (Y/N)\n\t");
                number = Stdin.readlnString("Enter the number of the article :\nThe number needs to be 4-digits long and positive.\n\t");
                description = Stdin.readlnString("Enter the description of the article :\nThe description can't be empty.\n\t");
                price = Stdin.readlnString("Enter the description of the article :\nThe description can't be empty.\n\t");
                
                if (answer = "Y")
                    {
                        stock = Stdin.readlnInt("Enter the stock of the article :\nThe stock can't be negative.\n\t");
                        article = new Article(number,price,stock,description);
                    }
                else
                    {
                        article = new Article(number,price,description);
                    }
                System.out.println("Article created.");
            }catch (RuntimeError e)
            {
                error = 1;
            }
        } while (error == 1);
        return article;
    }

    public void setPrice (Article article) //change the stock : reducing
    {
        double price = askDouble("How much do you want to retrieve ?\n\t");
        article.setPrice(price);
    }

    public void reduceStock (Article article) //change the stock : reducing
    {
        int amount = Stdin.readlnInt("How much do you want to retrieve ?\n\t");
        article.reduceStock(amount);
    }
    
    public void augmentStock (Article article) //change the stock : adding
    {
        int amount = Stdin.readlnInt("How much do you want to add ?\n\t");
        article.augmentStock(amount);
    }
    
    public void setDescription (Article article) //change the description of the article
    {
        String newDescription = Stdin.readlnString("Enter the new description : \n\t");
        article.setDescription(newDescription);
    }
    
    /**
     * Method askByte
     * @param message (String)
     * @return (byte) the entered number.
     */
    public static byte askByte(String message) {
        byte input;
        try {
            input = Stdin.readlnByte(message);
        }catch (Exception e) {
            System.out.println("\nEnter a number between " + Byte.MIN_VALUE + " and " + Byte.MAX_VALUE + " !");
            input = askByte(message);
        }
        return input;
    }
    
    /**
     * Method askInt
     * @param message (String)
     * @return (int) the entered number.
     */
    public static int askInt(String message) {
        int input;
        try {
            input = Stdin.readlnInt(message);
        }catch (Exception e) {
            System.out.println("\nEnter a number between " + Integer.MIN_VALUE + " and " + Integer.MAX_VALUE + " !");
            input = askInt(message);
        }
        return input;
    }
    
    /**
     * Method askLong
     * @param message (String)
     * @return (long) the entered number.
     */
    public static long askLong(String message) {
        long input;
        try {
            input = Stdin.readlnLong(message);
        }catch (Exception e) {
            System.out.println("\nEnter a number between " + Long.MIN_VALUE + " and " + Long.MAX_VALUE + " !");
            input = askLong(message);
        }
        return input;
    }
    
    /**
     * Method askDouble
     * @param message (String)
     * @return (double) the entered number.
     */
    public static double askDouble(String message) {
        double input;
        try {
            input = Stdin.readlnDouble(message);
        }catch (Exception e) {
            System.out.println("\nEither the number is not between " + Double.MIN_VALUE + " and " + Double.MAX_VALUE + " or the number is too precise for the double specification." );
            input = askDouble(message);
        }
        return input;
    }
    
    public static void main(String[] args)
    {
        new DepotDialog().start();
    }
}