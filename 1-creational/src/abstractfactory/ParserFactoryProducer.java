package abstractfactory;

public final class ParserFactoryProducer {

    private ParserFactoryProducer() { }

    public static AbstractParserFactory getFactory(String factoryType) {

        return switch (factoryType)
        {
            case "NYFactory" -> new NYParserFactory();
            case "CLFactory" -> new CLParserFactory();
            default -> null;
        };

    }
}