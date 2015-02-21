/*
To do:
javadocs
use Exception ?*/

/*usage
java CountLineOfCodes CountLineOfCodes.java Info.java -r
{"CountLineOfCodesException.java", "Info.java", "CountLineOfCodes.java", "-n"}
{"CountLineOfCodesException.java", "Info.java", "CountLineOfCodes.java", "-c"}
{"CountLineOfCodesException.java", "Info.java", "CountLineOfCodes.java", "-r"}
*/
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
    
public class CountLineOfCodes {

    public static final String TOTAL = "Total: ";
    public static final String TOTAL_LINES_OF_CODE = "\nTotal lines of code: ";
    public static final String FILES = "of file(s)";
    
    public static boolean isLineOfCode(String line) {
        if (line.length() > 0) {
            if (line.charAt(0) == '/' && line.length() > 1 && line.charAt(1) == '/') {
                return false;//comment
            } else {
                //not comment
                return true;
            }
        }
        return false;//not code but empty
    }
    
    public static Info infoFromContent(String fileName, String Text) {
        Info info = new Info(fileName);
        String[] lines = Text.split("\n");
        int length = lines.length;
        int codeLines = 0;
        int commentLines = 0;
        for (int i = 0; i < length; i++) {
            lines[i] = lines[i].trim();
            if (!lines[i].isEmpty()) {
                if (isLineOfCode(lines[i])) {
                    codeLines++;
                } else {
                    commentLines++;
                }
            }
        }
        info.add(codeLines);
        info.add(commentLines);
        info.add((length - codeLines) - commentLines);//empty lines
        info.add(length);
        return info;
    }
    
    public static  ArrayList<Info> infosFromFileNames(String[] fileNames) {
        ArrayList<Info> infos = new ArrayList<Info>();
        for (int i = 0, length = fileNames.length; i < length ; i++){
            if (!fileNames[i].isEmpty()) {
                String fileContent = EasyFiles.loadText(fileNames[i]);
                infos.add(infoFromContent(fileNames[i], fileContent));
            }
        }
        return infos;
    }
    
    public static void printInfo(Info info) {
        Dialogs.print(info.toString());
    }
    
    
    public static ArrayList<Info> sortFilenames(ArrayList<Info> infos) {
        int length = infos.size();
        String filename;
        Info temp;
        for (int j = 1; j < length ; j++){
            for (int i = 1; i < length - j + 1 ; i++){
                if ((infos.get(i-1).getFilename().compareToIgnoreCase(infos.get(i).getFilename())) > 0) {
                    //swap
                    temp = infos.get(i-1);
                    infos.set(i-1,infos.get(i));
                    infos.set(i,temp);
                }
            }
        }
        return infos;
    }
    
    public static ArrayList<Info> sortLinesOfCode(ArrayList<Info> infos) {
        int length = infos.size();
        String filename;
        Info temp;
        for (int j = 1; j < length ; j++){
            for (int i = 1; i < length - j + 1 ; i++){
                if (infos.get(i-1).get(0) > infos.get(i).get(0)) {
                    //swap
                    temp = infos.get(i-1);
                    infos.set(i-1,infos.get(i));
                    infos.set(i,temp);
                }
            }
        }
        return infos;
    }
    
    public static ArrayList<Info> sortRatio(ArrayList<Info> infos) {
        int length = infos.size();
        String filename;
        Info temp;
        for (int j = 1; j < length ; j++){
            for (int i = 1; i < length - j + 1 ; i++){
                if (infos.get(i-1).getRatio() > infos.get(i).getRatio()) {
                    //swap
                    temp = infos.get(i-1);
                    infos.set(i-1,infos.get(i));
                    infos.set(i,temp);
                }
            }
        }
        return infos;
    }
    
    /**  -n sort with filenames
     *   -c sort with lines of code
     *   -r sort with result comment / code
    */
    public static void printInfos(ArrayList<Info> infos, String sort) {
        int length = infos.size();
        int totalLinesOfCode = 0;
        Dialogs.print(sort);
        if (sort.equals("-n")) {
            infos = sortFilenames(infos);
        } else if (sort.equals("-c")) {
            infos = sortLinesOfCode(infos);
        } else if (sort.equals("-r")) {
            infos = sortRatio(infos);
        }
        //else does not sort if not recognized
            
        for(int i = 0; i < length ; i++){
            printInfo(infos.get(i));
            totalLinesOfCode += infos.get(i).get(0);
        }
        Dialogs.print(TOTAL + length + FILES + TOTAL_LINES_OF_CODE + totalLinesOfCode);
    }
    
    /**  -n sort with filenames
     *   -c sort with lines of code
     *   -r sort with result comment / code
    */
    public static void main(String[] args){
        int length = args.length;
        String[] fileNames;
        String sort = "";
        for (int i = 0; i < length; i++) {
            if (args[i].equals("-n")) {
                sort = "-n";
                args[i] = "";
                break;
            } else if (args[i].equals("-c")) {
                sort = "-c";
                args[i] = "";
                break;
            } else if (args[i].equals("-r")) {
                sort = "-r";
                args[i] = "";
                break;
            }
        }
        printInfos(infosFromFileNames(args), sort);       
    }
}
