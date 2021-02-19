package javaKnow.load;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class MyClassLoader extends ClassLoader {
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {

        String path = "D:\\workspace\\idea\\myLeetcode\\target\\classes\\" + name + ".class";

        ByteArrayOutputStream os = new ByteArrayOutputStream();
        try {
            Files.copy(Paths.get(path), os);
            byte[] bytes = os.toByteArray();

            return defineClass(name, bytes, 0, bytes.length);
        } catch (IOException e) {
            e.printStackTrace();
            throw new ClassNotFoundException("类文件不存在", e);
        }



    }

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        MyClassLoader myClassLoader = new MyClassLoader();
        Class<?> m = myClassLoader.loadClass("javaKnow.load.M");
        Class<?> m2 = myClassLoader.loadClass("javaKnow.load.M");
        System.out.println(m == m2);
        m.newInstance();
        System.out.println(m);
    }
}
