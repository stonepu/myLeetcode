package designpattern.abstarctFactory;

/**
 * 主要解决接口选择的问题。
 * 产品族难扩展，产品等级易扩展。
 * 系统的产品有多于一个的产品族，而系统只消费其中某一族的产品时使用。
 */
public abstract class AbstractFactory {
    public abstract Shape getShape(String name);
    public abstract Color getColor(String name);
}
