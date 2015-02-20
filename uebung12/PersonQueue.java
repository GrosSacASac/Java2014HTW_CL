/**
 *PersonQueue
 * 
 * @author
 * @version 1.1251
 */
import java.util.*;
public class PersonQueue implements Queue {

    private int size;
    private ArrayList<Person> queue;//Internally we use  List
    //private final static int QUEUE_DEFAULT_SIZE = 250;
    
    
    private static final String ERROR_PERSON_REQUIRED = "ERROR_PERSON_REQUIRED";
    
    /**
     * Constructor
     * 
     */
    public PersonQueue() {
        this.queue = new ArrayList<Person>();
        this.size = 0;
    }
    
    /**
     * returns true if empty
     */
    public boolean empty() {
        return (this.size == 0);
    }

    /**
     * a list can't be full right ?
     */
    public boolean full() {
        return false;
    }

    /**
     * gibt die Anzahl der Elemente in der Queue aus.
     * @return  size.
     */
    public int size() {
        return this.size;
    }

    /**
     * append object to the queue
     */
    public void addLast(Object o) throws PersonQueueException {
        check(!full(), ERROR_QUEUE_MAX_SIZE);
        check(o instanceof Person, ERROR_PERSON_REQUIRED);
        queue.add((Person)o);
        this.size ++;

    }

    /** 
     * pop first element
     */
    @Override
    public Person removeFirst() throws PersonQueueException {
        check(!empty(), ERROR_QUEUE_IS_EMPTY);
        Person person = queue.get(0);
        queue.remove(0);
        this.size--;
        return person;
    } 

    /**
     * 
     */
    @Override
    public Person get(int index) throws PersonQueueException {
        check(!empty(), ERROR_QUEUE_IS_EMPTY);
        Library.check(index < this.size, ERROR_INDEX_TOO_HIGH);
        return queue.get(index);
    }
    
    /**
     * check boolean
     */
    public void check(boolean test, String message)throws PersonQueueException {
        if(!test) {
            throw new PersonQueueException(message);
        }
    }
}
