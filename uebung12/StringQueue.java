
/**
 * StringQueue
 * 
 * @version 1
 */
public class StringQueue implements Queue {
    private int size;
    private String[] queue;//Internally we use  array
    private final static int QUEUE_DEFAULT_SIZE = 250;
    private static final String ERROR_STRING_REQUIRED = "ERROR_STRING_REQUIRED";
    
    /**
     * Constructor
     * 
     * @param int size
     */
    public StringQueue(int size)
    {
        queue = new String[size];
        size = 0;
    }
    
    /**
     * Constructor 2
     */
    public StringQueue() 
    {
        this(QUEUE_DEFAULT_SIZE);
    }


    /**
     * returns true if empty
     */
    public boolean empty()
    {
        return (size == 0);
    }

    /**
     * returns true if full
     */
    public boolean full()
    {
        return (queue.length <= size);
    }

    /**
     * gibt die Anzahl der Elemente in der Queue aus.
     * @return  size.
     */
    public int size()
    {
        return  size;
    }

    /**
     * append object to the queue
     */
    public void addLast(Object o) throws StringQueueException
    {
        check(!full(), ERROR_QUEUE_MAX_SIZE);
        check(o instanceof String, ERROR_STRING_REQUIRED);
        queue[size] = (String)o;
        size ++;
    }

    /** 
     * pop first element
     */
    @Override
    public String removeFirst()throws StringQueueException
    {
        check(!empty(),ERROR_QUEUE_IS_EMPTY);

        String string = queue[0];
        Library.shiftLeftArray(queue, 0, size);
        size--;
        return string;
    } 

    /**
     * 
     */
    @Override
    public String get(int index)
    {
        Library.check(index < size,ERROR_INDEX_TOO_HIGH);
        return queue[index];
    }
    
    /**
     * Ueberpruefung der Bedinggung, Ausloesung eine StringQueueException.
     */
    public void check(boolean test, String msg)throws StringQueueException
    {
        if(!test)
        {
            throw new StringQueueException(msg);
        }
    }
}
