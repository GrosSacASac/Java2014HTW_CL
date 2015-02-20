
/**
 * Person can store name and firstName
 * 
 * @author 
 * @version 2.2
 */
public class Person
{
    private String name;
    private String firstName;

    public static final String SEPARATOR = ";";
    private static final String ERROR_EMPTY_NAME = "Name must not be empty";
    private static final String ERROR_EMPTY_FIRST_NAME = "First name must not be empty";

    /**
     * Constructor
     *  
     * @param name
     * @param firstName
     */
    public Person(String name, String firstName)
    {
        setName(name);
        setFirstName(firstName);
    }

    public String getName()
    {
        return name;
    }
    
    public String getFirstName()
    {
        return firstName;
    }
    
    public void setName(String name)
    {
        Library.check( (name != null) && (!name.trim().isEmpty()), ERROR_EMPTY_NAME );
        this.name = name;
    }
   
    public void setFirstName(String firstName)
    {
        Library.check( (firstName != null) && (!firstName.trim().isEmpty()), ERROR_EMPTY_FIRST_NAME );
        this.firstName = firstName;
    } 
    
    public String toString()
    {
        return getName() + SEPARATOR + " " + getFirstName();
    }
}
