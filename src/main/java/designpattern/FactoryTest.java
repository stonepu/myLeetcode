package designpattern;

/**
 * 工厂模式主要解决接口选择的问题。
 * 我们明确地计划不同条件下创建不同实例时使用
 */

interface Shape{
    void draw();
    default void test(){
        System.out.println("this is test method");
    }

    int a = 0;

    int b = 1;

    int c = 2;

    static void test1(){
        System.out.println("test1");
    }
}

class Rectangle implements Shape{
    @Override
    public void draw() {
        System.out.println("this is a rectangle");
    }
}

class Circle implements Shape{
    @Override
    public void draw() {
        System.out.println("this is a circle");
    }

    @Override
    public void test() {
        System.out.println("this is circle test");
    }
}

class Square implements Shape{
    @Override
    public void draw() {
        System.out.println("this is a square");
    }
}

class ShapeFactory{
    static Shape getShape(String name) {
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
}



public class FactoryTest {
    public static void main(String[] args) {
        Shape circle = ShapeFactory.getShape("CIRCLE");
        circle.draw();
        circle.test();

        Shape rectangle = ShapeFactory.getShape("RECTANGLE");
        rectangle.draw();

        Shape square = ShapeFactory.getShape("SQUARE");
        square.draw();

        String str = "";
        str.replaceAll(" ", "");
    }
}
