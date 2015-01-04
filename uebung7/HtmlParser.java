/**
 * @author LUCIE BECHTOLD / CYRIL WALLE 
 * @version 1.0
 */
 
public class HtmlParser
{
    
    final static byte NORMAL = 0;
    final static byte IN_TAG_NAME = 1;
    final static byte IN_TAG = 2;
    final static byte IN_TAG_ATTRIBUTE = 3;
    final static byte IN_TAG_ATTRIBUTE_VALUE_QUOTATION_MARK = 4; // "
    final static byte IN_TAG_ATTRIBUTE_VALUE_SINGLE_QUOTATION_MARK = 5; // '
    final static byte IN_TAG_ATTRIBUTE_VALUE_WITHOUT_QUOTATION_MARK = 6;
    
    final static String LESS_THAN_SIGN_ILLEGAL_PLACE = "\"<\" can t be in a tag declaration. If you want to use it inside an attribute value, use quotation marks. Use &lt; to escape it.";
    final static String GREATER_THAN_SIGN_ILLEGAL_PLACE = "\">\" can't stand alone in a normal context.If you want to use it inside an attribute value, use quotation marks. Use &gt; to escape it.";
    final static String ILLEGAL_TAG_NAME = "ILLEGAL_TAG_NAME";
    final static String SPLIT_TOKEN_IN_TAG = "Tokens in a tag must be separated by a whitespace.";
    final static String ILLEGAL_CHARACTER_IN_ATTRIBUTE = "An HTML attribute should be made with only a-Z and -";
    final static String MIXED_QUOTATION_MARKS_SYMBOLS = "Use \" or ', but don t mix both";
    final static int MAX_SIZE_ATTRIBUTE_LIST = 25; 
    
    private List<HtmlElement> ancestorNodes = new ArrayList<HtmlElement>();
    private byte state;
    private HtmlElement currentElement;
    private String currentWord;
    private String currentTag;
    private String[] currentAttributes;
    private int currentAttributesIndex;
    private String[] currentAttributeValues;
    private int currentAttributeValuesIndex;
    private int i;
     /**
    */
    
    public static HtmlElement htmlParser (String htmlText) {
        int i = 0;
        int length = htmlText.length;
        this.state = NORMAL;
        resetTag();
        this.currentElement = new HtmlElement(
                        "#document", this.currentAttributes, this.currentAttributeValues);
        for(this.i = 0; this.i < length; this.i++ ) {
            handleLetter((char)htmlText[this.i]);
        }
        return ;
    }
    
    private static void resetWord () {
        this.currentWord = "";
    }
    private static void resetTag () {
        resetWord();
        this.currentTag = "";
        this.currentAttributes = new String[MAX_SIZE_ATTRIBUTE_LIST];
        this.currentAttributesIndex = 0;
        this.currentAttributeValues = new String[MAX_SIZE_ATTRIBUTE_LIST];
        this.currentAttributeValuesIndex = 0;
    }
    private static void enterElement () {
        HtmlElement currentElement = new HtmlElement(
            this.currentTag, this.currentAttributes, this.currentAttributeValues);
        this.currentElement = currentElement;
        this.ancestorNodes.add(this.currentElement)
        resetTag();
    }
    
    private static void closeElement () {
        HtmlElement closingElement = this.currentElement;
        this.ancestorNodes.remove(closingElement);
        this.currentElement = this.ancestorNodes.get(this.ancestorNodes.lastIndexOf());
        this.currentElement.addContent(currentElement);
        resetTag();
    }
    
    private static void addLetter (char letter) {
        this.currentWord += (String)letter;
    }
    
    private static void handleLetter (char letter) {
        switch (letter) {
            case '<':
                handleLessThan();
                break;
            case '>':
                handleGreaterThan();
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
            case '=':
                handleEqual();
                break;
            case ' ':
            case '\n':
            case '\r':
            case '\t':
                handleWhiteSpace();
                break;
            case default:
                addLetter(letter);
        }
    }
    
    private static void handleLessThan () { //<
        switch (this.state) {
            case NORMAL:
                this.state = IN_TAG;
                break;
            case IN_TAG_NAME:
                invalidHtml(LESS_THAN_SIGN_ILLEGAL_PLACE);
                break;
            case IN_TAG:
                invalidHtml(LESS_THAN_SIGN_ILLEGAL_PLACE);
                break;
            case IN_TAG_ATTRIBUTE:
                invalidHtml(LESS_THAN_SIGN_ILLEGAL_PLACE);
                break;
            case IN_TAG_ATTRIBUTE_VALUE_WITHOUT_QUOTATION_MARK:
                invalidHtml(LESS_THAN_SIGN_ILLEGAL_PLACE);
                break;
            case default:
                addLetter('<');
        }
    }
    private static void handleGreaterThan () { //>
        switch (this.state) {
            case NORMAL:
                invalidHtml(GREATER_THAN_SIGN_ILLEGAL_PLACE);
                break;
            case IN_TAG_NAME:
                if (this.currentWord.isEmpty()) {
                    invalidHtml(ILLEGAL_TAG_NAME);
                }
                else {
                    this.currentTag = this.currentWord;
                    enterElement();
                break;
            case IN_TAG: // this
                if (this.currentTag.isEmpty()) { //  and this can happen ?
                    invalidHtml(ILLEGAL_TAG_NAME);
                }
                else {
                    enterElement();
                break;
            case IN_TAG_ATTRIBUTE:
                invalidHtml(GREATER_THAN_SIGN_ILLEGAL_PLACE);
                break;
            case IN_TAG_ATTRIBUTE_VALUE_WITHOUT_QUOTATION_MARK:
                invalidHtml(GREATER_THAN_SIGN_ILLEGAL_PLACE)
                break;
            case default:
                addLetter('>');
        }
    }
    private static void handleQuotationMark () { 
        switch (this.state) {
            case IN_TAG_NAME:
                warnBadHtml(SPLIT_TOKEN_IN_TAG);
            case IN_TAG:
                warnBadHtml(ILLEGAL_CHARACTER_IN_ATTRIBUTE);
                this.currentTag = this.currentWord;
                resetWord();
                this.state = IN_TAG_ATTRIBUTE;
                addLetter('"');
                break;
            case IN_TAG_ATTRIBUTE:
                warnBadHtml(ILLEGAL_CHARACTER_IN_ATTRIBUTE);
                addLetter('"');
                break;
            case IN_TAG_ATTRIBUTE_VALUE_SINGLE_QUOTATION_MARK:
                warnBadHtml(MIXED_QUOTATION_MARKS_SYMBOLS);
            case IN_TAG_ATTRIBUTE_VALUE_WITHOUT_QUOTATION_MARK:
                warnBadHtml(MISSING_CHARACTER + "\"");
            case IN_TAG_ATTRIBUTE_VALUE_QUOTATION_MARK:
                this.currentAttributes[this.currentAttributesIndex] = this.currentWord;
                this.currentAttributesIndex++;
                resetWord();
                this.state = IN_TAG;
                break;
            case IN_TAG_ATTRIBUTE_VALUE_WITHOUT_QUOTATION_MARK:
                (GREATER_THAN_SIGN_ILLEGAL_PLACE)
                break;
            case default:
                addLetter('"');
        }
    }
    
    private static void invalidHtml (String reason) {
        throw new invalidHtmlException(reason);
    }
    
    private static void warnBadHtml (String reason) {
        //warning 
    }
    
   
}