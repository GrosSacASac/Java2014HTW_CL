/**
 * Interactive testing of queues
 * 
 * @version 3
 */

public class QueueDialog {
    private Queue stringQueue  = new StringQueue();
    private Queue personQueue = new PersonQueue();
    private Queue currentQueue = stringQueue;
    private byte mode = 0;

    //for mode
    public static final byte STRING_MODE = 0;
    public static final byte PERSON_MODE = 1;
    
    //for menus
    public static final byte ADD_LAST = 1;
    public static final byte REMOVE_FIRST = 2;
    public static final byte PRINT = 3;
    public static final byte CHANGE_MODE = 4;
    public static final byte SAVE = 5;
    public static final byte LOAD = 6;
    public static final byte EXIT = 0;

    //Errors
    public static final String CANCELED = "CANCELED";
    public static final String INCORRECT_INPUT = "INCORRECT_INPUT";
    
    //Saves
    public static final String STRING_QUEUE_EXTENSION = ".stringqueue";
    public static final String PERSON_QUEUE_EXTENSION = ".personqueue";
    public static final String EMPTY = "file is empty";
    public static final String SUCCES = "Succes !";
    
    //Menus
    public static final String END = "END";
    public static final String ASK_STRING = "\nA String: ";
    public static final String ASK_FILENAME = "\nGive me a file name (without extension): ";
    public static final String ASK_NAME = "\nName: ";
    public static final String ASK_FIRST_NAME = "\nFirst Name: ";
    public static final String SWITCHED = "\nSwitched !\n";
    public static final String READING = "\nReading: ";
    public static final String WRITING = "\nWriting: ";
    public static final String RELEASED = "\nhas been released from the queue\n";
    public static final String MAIN_MENU ="\nMENU: \n"
            + ADD_LAST     +"- AddLast\n"
            + REMOVE_FIRST +"- RemoveFirst\n"
            + PRINT        +"- Print\n"
            + CHANGE_MODE  +"- Switch PersonQueue/StringQueue\n"
            + SAVE         +"- Save in file\n"
            + LOAD         +"- Load Queue from file\n"
            + EXIT         +"- EXIT\n" + "\nChoose: ";
    /**
     * Init, then main loop that does:
     * 1) ask
     * 2) Try what asked 
     */
    public void start() throws StringQueueException,PersonQueueException {
        byte selectedOperation;
        
        fill();
        do {
            selectedOperation = inputSelectedOperation();
            try {
                doOperation(selectedOperation);
            }
            catch (StringQueueException e) {
                Dialogs.print(e);
            }
            catch (PersonQueueException e) {
                Dialogs.print(e);
            }
            catch (RuntimeException e) {
                Dialogs.print(e);
            }
        } while(selectedOperation != EXIT);
    }
    
    /**
     * Fill object so that they are not empty, and user can play yith Queues immediatly
     */
    public void fill() throws StringQueueException,PersonQueueException {
        this.stringQueue.addLast("abcdefgh");
        this.stringQueue.addLast("qwertz");
        this.stringQueue.addLast("lolipop");
        this.personQueue.addLast(new Person("JULIE","RICHTER"));
        this.personQueue.addLast(new Person("GREGORY","OELPUTZER"));
        this.personQueue.addLast(new Person("VICTORIA","STROH"));
    }  

    /**
     * Shows a menu and ask what to do
     * @return byte
     */
    public static byte inputSelectedOperation() {
        return  Dialogs.askByte(MAIN_MENU);
    } 

   
    /**
     * Return an entire queue as a String
     * @param queue
     */
    public static String print(Queue queue) throws StringQueueException,PersonQueueException {
        StringBuffer stringBuffer = new StringBuffer();
        for(int i = queue.size() - 1; i >= 0; i--) {
            stringBuffer.append(queue.get(i)).append(",\n");
        }
        return stringBuffer.toString();
    }
    
    /**
     * Change mode
     */
    public void changeMode() {
        if (this.mode == STRING_MODE) {
            this.mode = PERSON_MODE;
            this.currentQueue = this.personQueue;
        } else {
            this.mode = STRING_MODE;
            this.currentQueue =  this.stringQueue ;
        }
    }
                    
    /**
     * ADDs an item to the queue
     *@param 
     */
    public void addLast() throws StringQueueException,PersonQueueException {
        if (this.mode == STRING_MODE) {
            this.currentQueue.addLast(Dialogs.askString(ASK_STRING));
        } else {
            this.currentQueue.addLast(new Person(
            Dialogs.askString(ASK_NAME),
            Dialogs.askString(ASK_FIRST_NAME) ));
        }
    }
             
    /**
     */
    public void saveQueue() throws StringQueueException,PersonQueueException {
        String fileName;
        if (this.mode == STRING_MODE) {
            fileName = Dialogs.askString(ASK_FILENAME) + STRING_QUEUE_EXTENSION;
        } else {
            fileName = Dialogs.askString(ASK_FILENAME) + PERSON_QUEUE_EXTENSION;
        }
        Dialogs.print(WRITING + fileName);
        EasyFiles.saveText(fileName, print(this.currentQueue));
    }
    
    /**
     */
    public static StringQueue stringQueueFromText(String text) throws StringQueueException {
        String item;
        StringQueue stringQueue = new StringQueue();
        String[] temp = text.split(",");
        int i = temp.length - 1;
        while (i >= 0) {
            item = temp[i].trim();
            if (!item.isEmpty()) {
                stringQueue.addLast(item);
            }
            i--;
        }
        return stringQueue;
    }
    /**
     */
    public static PersonQueue personQueueFromText(String text) throws PersonQueueException {
        String[] temp = text.split(",");
        int i = temp.length - 1;
        String item;
        String[] names;
        PersonQueue personQueue = new PersonQueue();
        temp = text.split(",");
        i = temp.length - 1;
        while (i >= 0) {
            item = temp[i].trim();
            names = item.split(Person.SEPARATOR);
            if (!item.isEmpty()) {
                personQueue.addLast(new Person(names[0].trim(),
                                               names[1].trim()));
            }
            i--;
        }
        return personQueue;
    }
    /**
     */
    public void loadQueue() throws StringQueueException,PersonQueueException {
        String fileName;
        String text;
        
        if (this.mode == STRING_MODE) {
            fileName = Dialogs.askString(ASK_FILENAME)+ STRING_QUEUE_EXTENSION;
        } else {
            fileName = Dialogs.askString(ASK_FILENAME)+ PERSON_QUEUE_EXTENSION;
        }
        
        Dialogs.print(READING + fileName);
        text = EasyFiles.loadText(fileName).trim();
        if (text.isEmpty()) {
            Dialogs.print(EMPTY);
            return;
        }
        
        if (this.mode == STRING_MODE) {
            this.stringQueue = stringQueueFromText(text);
            this.currentQueue = this.stringQueue;
        } else {
            this.personQueue = personQueueFromText(text);
            this.currentQueue = this.personQueue;
        }
        Dialogs.print(SUCCES);
    }
                    
    /**

     * Does the asked action
     *@param selectedOperation 
     */
    public void doOperation(byte selectedOperation) throws StringQueueException,PersonQueueException {
        
        switch (selectedOperation) {  
            case ADD_LAST:
                addLast();
                break;
            case REMOVE_FIRST:
                Dialogs.print(this.currentQueue.removeFirst() + RELEASED);
                break;
            case PRINT:
                Dialogs.print(print(this.currentQueue));
                break;
            case CHANGE_MODE:
                changeMode();                
                Dialogs.print(SWITCHED);
                break;
            case SAVE:
                saveQueue();
                break;
            case LOAD:
                loadQueue();
                break;
            case EXIT:
                Dialogs.print(END);
                break;
        }
    }

    public static void main(String[] args) {
        QueueDialog d = new QueueDialog();
        try {
            d.start();
        }
        catch(Exception e) {
            Dialogs.print(e);//we should not land here
        }
    }
}
