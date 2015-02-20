
/**
 * Utilities to be reused in other classes
 * 
 * @author 
 * @version 2
 */
public class Library
{
    /**
     * Check the boolean test, throws error eventually
     */
    public static void check(boolean test, String msg)
    {
        if(!test)
        {
            throw new RuntimeException(msg);
        }
    }
  
    /**
     * Shifts lefts all the elements of an array removing the object at index index
     * @param Object[] array 
     * @param index, index of the element to be forgotten
     * @param reach; how many elements are moved
     */
    public static void shiftLeftArray(Object[] array, int index, int reach)
    {
        for(int i = index; i < reach -1; i++)
        {
            array[i] = array[i+1];
        }
        array[reach-1] = null;
    }
}
