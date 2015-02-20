/**
 * Class to manipulate files with ease
 *  loadText and saveText
 * needs Dialogs
 * @version 3.1
 */

import java.io.*;
import java.util.Scanner;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;

public class EasyFiles {
    //Errors
    public static final String CANCELED = "CANCELED";
    public static final String INCORRECT_INPUT = "INCORRECT_INPUT";
    public static final String ERROR_WRITE_DISC = "ERROR_WRITE_DISC";
    public static final String ERROR_LOAD_DISC = "ERROR_LOAD_DISC";
    public static final String ERROR_CLOSE_FILE = "ERROR_CLOSE_FILE";
    
    //Saves and loads
    public static final String EMPTY = "file is empty";
    
    //Reports
    public static final String READING = "\nReading: ";
    public static final String WRITING = "\nWriting: ";
          
    /**
     * Saves text in filename
     *
     * @param String fileName, String Text
     */
    public static void saveText(String fileName, String Text) {
        Writer writer = null;
        try {
            writer = new BufferedWriter(new OutputStreamWriter(
                        new FileOutputStream(fileName),StandardCharsets.UTF_8));
            writer.write(Text);
        } catch (IOException ex) {
            Dialogs.print(ERROR_WRITE_DISC);
        } finally {
            try {
                writer.close();
            } catch (Exception ex) {
                Dialogs.print(ERROR_CLOSE_FILE);
            }
        }
    }
       
              
    /**
     * Load text from filename
     *
     * @param String fileName
     * @return String Text
     */
    public static String loadText(String fileName) {      
        String text = "";
        final StringBuilder stringBuilder = new StringBuilder();
        try {
            final BufferedReader reader = Files.newBufferedReader(Paths.get(fileName), StandardCharsets.UTF_8);
            String line;
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line).append('\n');
            }
            text = stringBuilder.toString();
        } catch (IOException e) {
            Dialogs.print(ERROR_LOAD_DISC);
        }
        return text;
    }
    
    /*alternative loadText
    public static String loadText(String FileName) {
        if (!isNormalFile(FileName) ) {
            return "";
        }else if (!isReadableFile(FileName)) {
            return "";
        }//else
        try {
            Scanner reader = new Scanner (new File(FileName));
            StringBuilder buffer = new StringBuilder("");
            while(reader.hasNext()){
                buffer.append(reader.nextLine() + "\n");
            }
            return buffer.toString();
        } catch (FileNotFoundException e) {
            return "";
        }
    }*/
}
