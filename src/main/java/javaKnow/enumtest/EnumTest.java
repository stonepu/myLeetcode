package javaKnow.enumtest;

public class EnumTest {
    final private int id;
    final private String name;

    private EnumTest(int id, String name) {
        this.id = id;
        this.name = name;
    }

    final static EnumTest o1 = new EnumTest(1, "1");
    final static EnumTest o2 = new EnumTest(1, "1");
    final static EnumTest o3 = new EnumTest(1, "1");
    final static EnumTest o4 = new EnumTest(1, "1");

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "EnumTest{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
