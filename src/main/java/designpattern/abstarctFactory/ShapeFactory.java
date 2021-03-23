package designpattern.abstarctFactory;



public class ShapeFactory extends AbstractFactory {

    @Override
    public Shape getShape(String name) {
        Shape shape = null;
        switch (name) {
            case "CIRCLE":
                shape = new Circle();
                break;
            case "SQUARE":
                shape = new Square();
                break;
            case "RECTANGLE":
                shape = new Rectangle();
                break;
            default:
                break;
        }
        return shape;
    }

    @Override
    public Color getColor(String name) {
        return null;
    }
}
