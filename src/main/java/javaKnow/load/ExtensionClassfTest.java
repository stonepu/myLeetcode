package javaKnow.load;

/**
 * 打包指令 jar -cvf my.jar javaKnow\load\G.class
 */
public class ExtensionClassfTest {
    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> aClass = Class.forName("javaKnow.load.G");
        System.out.println(aClass.getClassLoader());
    }
}
