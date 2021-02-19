package javaKnow.enumtest;

import java.util.concurrent.locks.ReentrantLock;

interface Info{
    void show();
}

enum E{
    o1;
    private E(){

    }

}

public enum Enums implements Info{

    o1(1, "1"){
        @Override
        public void show() {

        }
    },
    o2(1, "1"),
    o3(1, "1"),
    o4(1, "1");

    final private int id;
    final private String name;

    private Enums(int id, String name) {
        this.id = id;
        this.name = name;
    }



    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public static void main(String[] args) {
        Enums[] values = Enums.values();
        for(Enums i : values) {
            System.out.println(i);
        }
        System.out.println(o1);

        Enums o2 = Enums.valueOf("o4");
        System.out.println(o2);
    }

    @Override
    public void show() {

    }

//    @Override
//    public String toString() {
//        return "EnumTest{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                '}';
//    }
}
