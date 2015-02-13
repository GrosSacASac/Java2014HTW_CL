/**
 * @author LUCIE BECHTOLD / CYRIL WALLE 
 * @version 1.0
 */
 import java.util.Scanner;
 import java.io.*;
 import java.nio.charset.StandardCharsets;
 import java.nio.file.*;
import java.util.List;
import java.util.ArrayList;
public class LinkExtractor
{    
    public LinkExtractor (){}
   
    public static void main(String[] args) {
        //Scanner s = new Scanner(System.in);
        //s.nextLine()

        final Path filePath = Paths.get(args[0]);
        final StringBuilder sb = new StringBuilder();
        
        String htmlText = "";
        
        try (final BufferedReader reader = Files.newBufferedReader(filePath, StandardCharsets.UTF_8)) {
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line).append('\n');
            }
            htmlText = sb.toString();
        }catch (IOException e) {
            System.out.println("error reading file");
        }
        
        HtmlParser parser = new HtmlParser();
        HtmlElement htmlDocument = parser.parse(htmlText);
        
        List<HtmlElement> content = htmlDocument.getContent();
        HtmlElement e;
        
        for (int i = 0, length = htmlDocument.getContent().size();
            i < length; i++) {
            if ( (content.get(i)) instanceof HtmlElement ) {
                e = content.get(i);
                if (e.getTag().equals("a")) {
                    //assuming a has an href
                    System.out.println(
                        e.getContent() + "\t" + 
                        e.getAttributeValueFromAttribute("href"));
                }
            }
        }
    }
}