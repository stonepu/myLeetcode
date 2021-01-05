package java;

public class fathre {

    public fathre(){}

    public int getId(String firstName, String lastName){
        return 1;
    }
}

class testFather{

    private int count = 0;

    private static int countS = 0;

    class testClass {

        public void test11(){
            ++count;
        }

    }

    static class testClass1{
        public void test12(){
//            ++count;
            ++countS;
        }
    }



    void test() {
        interface2 in = new interface2() {
            @Override
            public void test1() {

            }

            @Override
            public void test3() {

            }
        };

        reflect i = new reflect(){
            @Override
            void test3() {
                super.test3();
            }
        };

    }



}
