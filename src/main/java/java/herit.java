package java;

abstract class herit extends fathre implements interfaceTest {

    @Override
    public int getId(String firstName1, String lastName) {
        return super.getId(firstName1, lastName);
    }

    public abstract void test();

    abstract public void test2();

    static int a = 0;

    private void test5(){}
//    final void test3(){}

//    abstract static void test6();

    final int ab = 0;
}
