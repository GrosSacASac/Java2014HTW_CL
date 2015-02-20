/*
To do:
Define exception class for errors
sort output FileName
            comments
            comment ratio
javadocs
handle unreadable files correctly*/

/*usage
java CountLineOfCodes CountLineOfCodes.java Info.java
*/
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
    
public class CountLineOfCodes {
    
    public static boolean isLineOfCode(String line) {
        if (line.length() > 0) {
            if (line.charAt(0) == '/' && line.length() > 1 && line.charAt(1) == '/') {
                return false;//comment
            } else {
                return true;//not comment
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
    
    public static boolean isNormalFile(String FileName) {
        return true;
    }
    
    public static boolean isReadableFile(String FileName) {
        return true;
    }
    
    public static String textFromFileName(String FileName) {
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
    }
    
    public static  ArrayList<Info> infosFromFileNames(String[] fileNames) {
        ArrayList<Info> infos = new ArrayList<Info>();
        for(int i = 0, length = fileNames.length; i < length ; i++){
            String fileContent = textFromFileName(fileNames[i]);
            infos.add(infoFromContent(fileNames[i], fileContent));
        }
        return infos;
    }
    
    public static void printInfo(Info info) {
    
        System.out.println(info.toString());
    }
    
    public static void printInfos(ArrayList<Info> infos) {
        int length = infos.size();
        int codeLines = 0;
        int commentLines = 0;
        for(int i = 0; i < length ; i++){
            printInfo(infos.get(i));
        }
    }
    
    public static void main(String[] args){
       printInfos(infosFromFileNames(args));       
    }
}
