package abstractfactory;

public class CLParserFactory implements AbstractParserFactory {
    @Override
    public XMLParser getParser(String parserType) {

        return switch (parserType){
            case "ORDER" -> new CLOrderXMLParser();
            case "FEEDBACK" -> new CLFeedbackXMLParser();
            case "ERROR" -> new CLErrorXMLParser();
            default -> null;
        };

    }
}
