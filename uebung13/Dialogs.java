/**Dialogs helps to get input from user
 * askType for all needed type
 * @author LUCIE BECHTOLD / CYRIL WALLE 
 * @version 3.0
 */

import de.htw.saarland.stl.Stdin;
public class Dialogs {

    private static final String BYTE_ERROR = "\nEnter a number between " + Byte.MIN_VALUE + " and " + Byte.MAX_VALUE;
    private static final String INTEGER_ERROR = "\nEnter a number between " + Integer.MIN_VALUE + " and " + Integer.MAX_VALUE;
    private static final String STRING_ERROR = "\nFailure : wrong string";
    private static final String DOUBLE_ERROR = "DOUBLE_ERROR";
    
    /**
     * Method print
     * @param message (String)
     */
    public static void print(Object message) {
        System.out.println(message.toString());
    }
    /**
     * Method askByte
     * @param message (String)
     * @return (byte) input.
     */
    public static byte askByte(String message) {
        byte input;
        try {
            input = Stdin.readlnByte(message);
        }catch (Exception e) {
            print(BYTE_ERROR);
            print(e);
            return askByte(message);
        }
        return input;
    }
    
    /**
     * Method askInt
     * @param message (String)
     * @return (int) input.
     */
    public static int askInt(String message) {
        int input;
        try {
            input = Stdin.readlnInt(message);
        }catch (Exception e) {
            print(INTEGER_ERROR);
            print(e);
            return askInt(message);
        }
        return input;
    }
    
    /**
     * Method askString
     * @param message (String)
     * @return (String) the input.
     */
    public static String askString(String message) {
        String input;
        try {
            input = Stdin.readlnString(message);
        }catch (Exception e) {
            print(STRING_ERROR);
            print(e);
            return askString(message);
        }
        return input;
    }
}
