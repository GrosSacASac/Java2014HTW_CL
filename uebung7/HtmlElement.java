/**
 * @author LUCIE BECHTOLD / CYRIL WALLE 
 * @version 1.0
 */
 
import java.util.List;
public class HtmlElement {
    
     /**
    */
    private final static String MISSING_ATTRIBUTE_VALUE = "";
    private String tag;
    private List<String> attributes = new ArrayList<String>();
    private List<String> attributeValues = new ArrayList<String>();
    private List content = new ArrayList();
    
    public static void HtmlElement (String tag, String[] attributes, String[] attributeValues) {
        int i = 0;
        int length = attributes.length;
        String attribute;
        String attributeValue;
        this.tag = tag.toLowerCase();
        do {
            attribute = attributes[i];
            attributeValue = attributeValues[i]
            if (!attribute.isEmpty()) {
                if (!attributeValue.isEmpty()) {
                    addAttributeandValue(attribute, attributeValue);
                } else {
                    addAttributeandValue(attribute);
                }
            }
            i++;
        } while(!attribute.isEmpty() && i < length);
        
            
    }
    
    private static void addAttribute (String attribute) {
        this.attributes.add(attribute.toLowerCase());
    }
    
    private static void addContent (String textOrHtmlElement) {
        this.content.add(textOrHtmlElement);
    }
    
    private static void addAttributeValue (String attributeValue) {
        this.attributeValues.add(attributeValue);
    }
    
    public static void addAttributeandValue (String attribute, String attributeValue) {
        addAttribute(attribute);
        addAttributeValue(attributeValue);
    }
    
    public static void addAttributeandValue (String attribute) {
        addAttributeandValue(attribute, MISSING_ATTRIBUTE_VALUE);
    }
    
    private static boolean hasAttribute (String attribute) {
        return this.attributes.contains(attribute);
    }
    
     /**
     * Returns the value for the given attribute or an empty string if not found
    */
    public static String getAttributeValueFromAttribute (String attribute) {
        if hasAttribute(attribute) {
            return this.attributeValues.get(this.attributes.indexOf(attribute)) ;
        }
        //else
            return "";
    }
    
    public static String getTag () {
        return this.tag;
    }
    
    public static List getContent () {
        return this.content;
    }
    
    public static String toString () {
        //not implemented yet
        return "";
    }
    
}