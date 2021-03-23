package designpattern.abstarctFactory;

public class FactoryProducer{
    public static AbstractFactory getFactory(String choice) {
        switch (choice) {
            case "SHAPE":
                return new ShapeFactory();
            case "COLOR":
                return new ColorFactory();
        }
        return null;
    }
}
