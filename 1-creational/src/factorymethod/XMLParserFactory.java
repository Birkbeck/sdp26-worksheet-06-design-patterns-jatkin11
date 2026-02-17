package factorymethod;

import abstractfactory.NYErrorXMLParser;
import abstractfactory.NYFeedbackXMLParser;
import abstractfactory.NYOrderXMLParser;

public class XMLParserFactory {

    public XMLParser getParser(String xmlType) {
        return switch (xmlType){
            case "ORDER" -> new OrderXMLParser();
            case "FEEDBACK" -> new FeedbackXMLParser();
            case "ERROR" -> new ErrorXMLParser();
            default -> null;
        };

    }
}