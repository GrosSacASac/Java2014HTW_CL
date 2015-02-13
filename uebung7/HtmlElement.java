/**
 * @author LUCIE BECHTOLD / CYRIL WALLE 
 * @version 1.0
 */
 
import java.util.List;
import java.util.ArrayList;
public class HtmlElement {
    
     /**
    */
    private final static String MISSING_ATTRIBUTE_VALUE = "";
    private String tag;
    private List<String> attributes = new ArrayList<String>();
    private List<String> attributeValues = new ArrayList<String>();
    private List content = new ArrayList();
    
    public HtmlElement(String tag, String[] attributes, String[] attributeValues) {
        int i = 0;
        int length = attributes.length;
        String attribute;
        String attributeValue;
        this.tag = tag.toLowerCase();
        do {
            attribute = attributes[i];
            attributeValue = attributeValues[i];
            if (!(attribute == null) && (!attribute.isEmpty())) {
                if (!(attributeValue == null) && (!attributeValue.isEmpty())) {
                    addAttributeandValue(attribute, attributeValue);
                } else {
                    addAttributeandValue(attribute);
                }
            }
            i++;
        } while(!(attribute == null) && (!attribute.isEmpty()) && i < length);
        
            
    }
    
    private void addAttribute (String attribute) {
        this.attributes.add(attribute.toLowerCase());
    }
    
    public void addContent (Object textOrHtmlElement) {
        this.content.add(textOrHtmlElement);
    }
    
    private void addAttributeValue (String attributeValue) {
        this.attributeValues.add(attributeValue);
    }
    
    public void addAttributeandValue (String attribute, String attributeValue) {
        addAttribute(attribute);
        addAttributeValue(attributeValue);
    }
    
    public void addAttributeandValue (String attribute) {
        addAttributeandValue(attribute, MISSING_ATTRIBUTE_VALUE);
    }
    
    public boolean hasAttribute (String attribute) {
        return this.attributes.contains(attribute);
    }
    
     /**
     * Returns the value for the given attribute or an empty string if not found
    */
    public String getAttributeValueFromAttribute (String attribute) {
        if (this.hasAttribute(attribute)) {
            return this.attributeValues.get(this.attributes.indexOf(attribute)) ;
        }
        //else
            return "";
    }
    
    public String getTag () {
        return this.tag;
    }
    
    public List getContent () {
        return this.content;
    }
    
    public String toString () {
        //not implemented yet
        return "<" + this.getTag() + "...";
    }
    
}