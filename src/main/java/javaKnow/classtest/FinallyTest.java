package javaKnow.classtest;

public class FinallyTest{

    public static int test(){
        int i = 10;
        try{
            return i;
        }finally {
            i = 20;
        }
    }
    public static void main(String[] args) {
        System.out.println(test());
    }
}
