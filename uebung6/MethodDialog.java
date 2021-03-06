/**Interface to try the methods class 
 * @author LUCIE BECHTOLD / CYRIL WALLE 
 * @version 1.0
 */

import de.htw.saarland.stl.Stdin;

public class MethodDialog
{
    final static byte EXIT = 0;
    final static byte ARITHMETIC_AVERAGE = 1;
    final static byte STRING_LETTER_COUNT = 2;
    final static byte INSERTION_SORTING = 3;
    
    public void start ()
    {
        byte answer = 0;
        System.out.println("------------------------\nWelcome");
        
        do
        {
            System.out.println( "------------------------\nPlease choose one of the following function to use :\n\t" + 
                                "[" + ARITHMETIC_AVERAGE + "]\tCalculate the arithmetic average, find the closest and furthest number from it.\n\t" + 
                                "[" + STRING_LETTER_COUNT + "]\tCalculate how many string are composed of only letters.\n\t" + 
                                "[" + INSERTION_SORTING + "]\tSorts a table.\n\t" +
                                "[" + EXIT + "]\tExit the program.");
            answer = askByte("");
            tryThis(answer);
        } while (answer != EXIT);
        System.out.println("Program exited.");
    }
    
    public void tryThis(byte answer) {
        switch (answer) {
            case ARITHMETIC_AVERAGE:
                tryArithmeticAverage();
                break;
                
            case STRING_LETTER_COUNT:
                tryStringLetterCount();
                break;
                
            case INSERTION_SORTING:
                tryInsertionSorting();
                break;
        }
    }
    
    /**
     * Method tryArithmeticAverage
     * tries arithmetic average (Method1.main)
     * throws Error if there is an error
     */
    public void tryArithmeticAverage () {
        try {
            int sizeTable = askInt("Enter the size of the table you want to create :\t");
            double[] table = createNewTableNumberDouble(sizeTable);
            System.out.println(Method1.calculateArithmAverAndOthers(table));
        } catch (Error e) {
            System.out.println("Error: " + e);
        }
    }
    
    /**
     * Method tryStringLetterCount
     * tries stringLetterCount
     * throws Error if there is an error
     */
    public void tryStringLetterCount () {
        try {
            int sizeTable = askInt("Enter the size of the table you want to create :\t");
            String[] table = createNewTableString(sizeTable);
            System.out.println("Strings consisting only of letters : " + Method2.countStringsWithUniCaseLetters(table));
        } catch (Error e) {
            System.out.println("Error: " + e);
        }
    }
    
    /**
     * Method tryInsertionSorting
     * tries insertionSorting
     * throws Error if there is an error
     */
    public void tryInsertionSorting () {
        try {
            int sizeTable = askInt("Enter the size of the table you want to create :\t");
            int[] table = createNewTableNumberInt(sizeTable);
            System.out.println("The sorted table is : ");
            Method3.insertionSort(table);
            for (int i = 0; i < sizeTable; i++)
            {
                System.out.println(table[i]);
            }
        } catch (Error e) {
            System.out.println("Error: " + e);
        }
    }
    
    /**
     * Method createNewTableNumberInt
     * @param sizeTable (int)
     * @return table (int[])
     */
    public int[] createNewTableNumberInt (int sizeTable)
    {
        int number;
        int[] table = new int[sizeTable];
        for (int i = 0; i < sizeTable; i++)
        {
            table[i] = askInt("Enter a number (int) :\t");
        }
        return table;
    }    
    
    /**
     * Method createNewTableNumberDouble
     * @param sizeTable (int)
     * @return table (double[])
     */
    public double[] createNewTableNumberDouble (int sizeTable)
    {
        double number;
        double[] table = new double[sizeTable];
        for (int i = 0; i < sizeTable; i++)
        {
            table[i] = askDouble("Enter a number (double) :\t");
        }
        return table;
    }    
    
    /**
     * Method createNewTableString
     * @param sizeTable (int)
     * @return table (String[])
     */
    public String[] createNewTableString (int sizeTable)
    {
        String text;
        String[] table = new String[sizeTable];;
        for (int i = 0; i < sizeTable; i++)
        {
            table[i] = askString("Enter your text :\t");
        }
        return table;
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
     * Method askString
     * @param message (String)
     * @return (String) the entered String.
     */
    public static String askString(String message) {
        String input;
        try {
            input = Stdin.readlnString(message);
        }catch (Exception e) {
            System.out.println("\nEnter your text !");
            input = askString(message);
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
    
    /**
     * Method main
     * start the interface
     * @param args
     */
    public static void main(String[] args)
    {
        new MethodDialog().start();
    }
}