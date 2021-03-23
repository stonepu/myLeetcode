package designpattern.abstarctFactory;

public class ColorFactory extends AbstractFactory {

    @Override
    public Color getColor(String name) {
        Color color = null;
        switch (name) {
            case "RED":
                color = new Red();
                break;
            case "BLUE":
                color = new Blue();
                break;
            case "GREEN":
                color = new Green();
                break;
            default:
                break;
        }
        return color;
    }

    @Override
    public Shape getShape(String name) {
        return null;
    }
}
