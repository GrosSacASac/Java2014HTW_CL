/**
 * @author LUCIE BECHTOLD / CYRIL WALLE 
 * @version 1.0
 */
 
import java.util.List;
import java.util.ArrayList;
public class HtmlParser
{
    
    final static byte NORMAL = 0;
    final static byte IN_TAG_NAME = 1;
    final static byte IN_TAG = 2;
    final static byte IN_TAG_ATTRIBUTE = 3;
    final static byte IN_TAG_ATTRIBUTE_VALUE_QUOTATION_MARK = 4; // "
    final static byte IN_TAG_ATTRIBUTE_VALUE_SINGLE_QUOTATION_MARK = 5; // '
    final static byte IN_TAG_ATTRIBUTE_VALUE_WITHOUT_QUOTATION_MARK = 6;
    final static byte IN_CLOSING_TAG = 7;
    
    final static String LESS_THAN_SIGN_ILLEGAL_PLACE = "\"<\" can t be in a tag declaration. If you want to use it inside an attribute value, use quotation marks. Use &lt; to escape it.";
    final static String GREATER_THAN_SIGN_ILLEGAL_PLACE = "\">\" can't stand alone in a normal context.If you want to use it inside an attribute value, use quotation marks. Use &gt; to escape it.";
    final static String ILLEGAL_TAG_NAME = "ILLEGAL_TAG_NAME";
    final static String SPLIT_TOKEN_IN_TAG = "Tokens in a tag must be separated by a whitespace.";
    final static String ILLEGAL_CHARACTER_IN_ATTRIBUTE = "An HTML attribute should be made with only a-Z and -";
    final static String MIXED_QUOTATION_MARKS_SYMBOLS = "Use \" or ', but don t mix both";
    final static String EQUAL_SIGN_WITHOUT_ATTRIBUTE = "Found = without attribute";
    final static String MISSING_CHARACTER = "This character is missing: ";
    final static int MAX_SIZE_ATTRIBUTE_LIST = 25; 
    
    private List<HtmlElement> ancestorNodes = new ArrayList<HtmlElement>();
    private byte state;
    private HtmlElement currentElement;
    private String htmlText;
    private String currentWord;
    private String currentTag;
    private String[] currentAttributes;
    private int currentAttributesIndex;
    private String[] currentAttributeValues;
    private int currentAttributeValuesIndex;
    private int i;
     /**
    */
    
    public void HtmlParser () {
    }
    public HtmlElement parse (String htmlText) {
        int i = 0;
        int length = htmlText.length();
        this.state = NORMAL;
        this.htmlText = htmlText;
        resetTag();
        this.currentElement = new HtmlElement(
                        "#document", this.currentAttributes, this.currentAttributeValues);
        for(this.i = 0; this.i < length; this.i++ ) {
            handleLetter(this.htmlText.charAt(this.i));
        }
        //
        return currentElement;
    }
    
    private void resetWord () {
        this.currentWord = "";
    }
    private void resetTag () {
        resetWord();
        this.currentTag = "";
        this.currentAttributes = new String[MAX_SIZE_ATTRIBUTE_LIST];
        this.currentAttributesIndex = 0;
        this.currentAttributeValues = new String[MAX_SIZE_ATTRIBUTE_LIST];
        this.currentAttributeValuesIndex = 0;
    }
    private void enterElement () {
        HtmlElement currentElement = new HtmlElement(
            this.currentTag, this.currentAttributes, this.currentAttributeValues);
        this.currentElement = currentElement;
        this.ancestorNodes.add(this.currentElement);
        resetTag();
    }
    
    private void closeElement () {
        HtmlElement closingElement = this.currentElement;
        this.ancestorNodes.remove(closingElement);
        this.currentElement = this.ancestorNodes.get(this.ancestorNodes.size() - 1);
        this.currentElement.addContent(currentElement);
        resetTag();
    }
    
    private void addAttribute () {
        this.currentAttributes[this.currentAttributesIndex] = this.currentWord;
        this.currentAttributesIndex++;
        resetWord();
    }
    
    private void addAttributeValue() {
        this.currentAttributeValues[this.currentAttributeValuesIndex] = this.currentWord;
        this.currentAttributeValuesIndex++;
        resetWord();
    }
    
    private void handleLetter (char letter) {
        switch (letter) {
            case '<':
                handleLessThan();
                break;
            case '>':
                handleGreaterThan();
                break;
            case '=':
                handleEqual();
                break;
            case '"':
                handleQuotationMark();
                break;
            case '\'':
                handleSingleQuotationMark();
                break;
            case '/':
                handleSlash();
                break;
            case ' ':
            case '\n':
            case '\r':
            case '\t':
                handleWhiteSpace(letter);
                break;
            default:
                addLetter(letter);
        }
    }
    
    private void addLetter (char letter) {
        this.currentWord += Character.toString(letter);
    }
    
    private void handleLessThan () { //<
        switch (this.state) {
            case NORMAL:
                this.currentElement.addContent(this.currentWord);
                resetWord();
                this.state = IN_TAG_NAME;
                break;
            case IN_TAG_NAME:
            case IN_CLOSING_TAG:
            case IN_TAG:
            case IN_TAG_ATTRIBUTE:
            case IN_TAG_ATTRIBUTE_VALUE_WITHOUT_QUOTATION_MARK:
                invalidHtml(LESS_THAN_SIGN_ILLEGAL_PLACE);
                break;
            default:
                addLetter('<');
        }
    }
    private void handleGreaterThan () { //>
        switch (this.state) {
            case NORMAL:
                warnBadHtml(GREATER_THAN_SIGN_ILLEGAL_PLACE);
                addLetter('>');
                break;
            case IN_TAG_NAME:
                if (this.currentWord.isEmpty()) {
                    invalidHtml(ILLEGAL_TAG_NAME);
                } else {
                    this.currentTag = this.currentWord;
                    enterElement();
                }
                break;
            case IN_TAG:
                if (this.currentTag.isEmpty()) {
                    invalidHtml(ILLEGAL_TAG_NAME);
                } else {
                    enterElement();
                }
                break;
            case IN_TAG_ATTRIBUTE:
                invalidHtml(GREATER_THAN_SIGN_ILLEGAL_PLACE);
                break;
            case IN_TAG_ATTRIBUTE_VALUE_WITHOUT_QUOTATION_MARK:
                invalidHtml(GREATER_THAN_SIGN_ILLEGAL_PLACE);
                break;
            case IN_CLOSING_TAG:
                closeElement();
            default:
                addLetter('>');
        }
    }
    private void handleEqual () { 
        switch (this.state) {
            case IN_TAG_NAME:
                warnBadHtml(SPLIT_TOKEN_IN_TAG);
                break;
            case IN_TAG:
                warnBadHtml(EQUAL_SIGN_WITHOUT_ATTRIBUTE);
                break;
            case IN_TAG_ATTRIBUTE:
                addAttribute();
                this.state = IN_TAG_ATTRIBUTE_VALUE_WITHOUT_QUOTATION_MARK;
                break;
            case IN_TAG_ATTRIBUTE_VALUE_QUOTATION_MARK:
            case IN_TAG_ATTRIBUTE_VALUE_WITHOUT_QUOTATION_MARK:
            case IN_TAG_ATTRIBUTE_VALUE_SINGLE_QUOTATION_MARK:
            default:
                addLetter('=');
        }
    }
    
    private void handleQuotationMark () { 
        switch (this.state) {
            case IN_TAG_NAME:
                warnBadHtml(SPLIT_TOKEN_IN_TAG);
            case IN_TAG:
                this.currentTag = this.currentWord;
                resetWord();
                this.state = IN_TAG_ATTRIBUTE;
            case IN_TAG_ATTRIBUTE:
                warnBadHtml(ILLEGAL_CHARACTER_IN_ATTRIBUTE);
                addLetter('"');
                break;
            case IN_TAG_ATTRIBUTE_VALUE_SINGLE_QUOTATION_MARK:
                warnBadHtml(MIXED_QUOTATION_MARKS_SYMBOLS);
            case IN_TAG_ATTRIBUTE_VALUE_WITHOUT_QUOTATION_MARK:
                if (this.currentWord.isEmpty()) {
                    this.state = IN_TAG_ATTRIBUTE_VALUE_QUOTATION_MARK;
                } else {
                    warnBadHtml(MISSING_CHARACTER + "\" at " + this.i);
                    addAttributeValue();
                    this.state = IN_TAG;
                }
                break;
            case IN_TAG_ATTRIBUTE_VALUE_QUOTATION_MARK:
                addAttributeValue();
                this.state = IN_TAG;
                break;
            default:
                addLetter('"');
        }
    }
    private void handleSingleQuotationMark () { 
        switch (this.state) {
            case IN_TAG_NAME:
                warnBadHtml(SPLIT_TOKEN_IN_TAG);
            case IN_TAG:
                this.currentTag = this.currentWord;
                resetWord();
                this.state = IN_TAG_ATTRIBUTE;
            case IN_TAG_ATTRIBUTE:
                warnBadHtml(ILLEGAL_CHARACTER_IN_ATTRIBUTE);
                addLetter('\'');
                break;
            case IN_TAG_ATTRIBUTE_VALUE_QUOTATION_MARK:
                warnBadHtml(MIXED_QUOTATION_MARKS_SYMBOLS);
            case IN_TAG_ATTRIBUTE_VALUE_WITHOUT_QUOTATION_MARK:
                if (this.currentWord.isEmpty()) {
                    this.state = IN_TAG_ATTRIBUTE_VALUE_SINGLE_QUOTATION_MARK;
                } else {
                    warnBadHtml(MISSING_CHARACTER + "\" at " + this.i);
                    addAttributeValue();
                    this.state = IN_TAG;
                }
                break;
            case IN_TAG_ATTRIBUTE_VALUE_SINGLE_QUOTATION_MARK:
                addAttributeValue();
                this.state = IN_TAG;
                break;
            default:
                addLetter('\'');
        }
    }
    private void handleSlash () { 
        switch (this.state) {
            case IN_TAG_NAME:
                //closing element
                this.state = IN_CLOSING_TAG;
                enterElement();
                break;                
            case IN_TAG:
                //autoclosing element, perhaps add a warning this is not standard anymore
                this.state = IN_CLOSING_TAG;
                enterElement();
                break;
            case IN_TAG_ATTRIBUTE:
                warnBadHtml(ILLEGAL_CHARACTER_IN_ATTRIBUTE);
            default:
                addLetter('/');
        }
    }
    private void handleWhiteSpace (char whitespace) { 
        switch (this.state) {
            case IN_TAG_NAME:
                this.state = IN_TAG;
                break;
            case IN_TAG:
                //pass
                break;
            case IN_TAG_ATTRIBUTE:
                addAttribute();
                addAttributeValue();//empty string
                this.state = IN_TAG;
                break;
            case IN_TAG_ATTRIBUTE_VALUE_WITHOUT_QUOTATION_MARK:
                addAttributeValue();
                this.state = IN_TAG;
                break;
            default:
                addLetter(whitespace);
        }
    }
    
    private static void invalidHtml (String reason) {
        new InvalidHtmlException(reason);
        //exit(0);
    }
    
    private static void warnBadHtml (String reason) {
        //warning 
        System.out.println(reason);
    }
    
   
}