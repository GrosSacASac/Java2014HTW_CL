/**
 * Interface Queue
 * 
 * @author 
 * @version 2
 */
public interface Queue {
    
    //shared Error messages
    static final String ERROR_QUEUE_IS_EMPTY = "ERROR QUEUE IS EMPTY";
    static final String ERROR_INDEX_TOO_HIGH = "ERROR_INDEX_TOO_HIGH";
    static final String ERROR_QUEUE_MAX_SIZE = "ERROR_QUEUE_MAX_SIZE";
    
    //Queue Methods
    void addLast(Object o)throws PersonQueueException,StringQueueException;
    Object removeFirst()throws PersonQueueException,StringQueueException;
    
    //bonus
    Object get(int i)throws PersonQueueException,StringQueueException;
    
    
    //get intell
    boolean empty();
    boolean full();   
    int size();
}
