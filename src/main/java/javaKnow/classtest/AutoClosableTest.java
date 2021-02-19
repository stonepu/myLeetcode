package javaKnow.classtest;

public class AutoClosableTest implements AutoCloseable {
    @Override
    public void close() throws Exception {
        throw new Exception("close error");
    }

    public static void main(String[] args) {
        try(AutoClosableTest source = new AutoClosableTest()) {
            int i = 1 / 0;
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
