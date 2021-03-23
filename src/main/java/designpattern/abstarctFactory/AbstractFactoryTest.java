package designpattern.abstarctFactory;

public class AbstractFactoryTest {
    public static void main(String[] args) {
        AbstractFactory colorFactory = FactoryProducer.getFactory("COLOR");
        Color red = colorFactory.getColor("RED");
        red.fill();
    }
}
