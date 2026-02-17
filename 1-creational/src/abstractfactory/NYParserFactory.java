package abstractfactory;

public class NYParserFactory implements AbstractParserFactory {
    @Override
    public XMLParser getParser(String parserType) {
        return switch (parserType){
            case "ORDER" -> new NYOrderXMLParser();
            case "FEEDBACK" -> new NYFeedbackXMLParser();
            case "ERROR" -> new NYErrorXMLParser();
            default -> null;
        };
    }
}
