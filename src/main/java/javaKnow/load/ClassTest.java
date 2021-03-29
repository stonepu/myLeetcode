package javaKnow.load;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class ClassTest {

    public static void test1() throws ClassNotFoundException, NoSuchFieldException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class c1 = Class.forName("javaKnow.load.ObjectTest");

        System.out.println(c1);
        System.out.println(c1.getClassLoader());

        System.out.println(c1.getClass());

        System.out.println(Arrays.toString(c1.getAnnotations()));

        System.out.println(c1.getDeclaredField("k"));

        System.out.println(c1.getField("i"));
//        System.out.println(c1.getField("k"));

//        System.out.println(c1.getField("j"));

        Method print = c1.getMethod("print", String.class);
        ObjectTest objectTest = new ObjectTest();
        print.invoke(objectTest, "hello");

        c1.getInterfaces();

        System.out.println(c1.getSuperclass());
    }

    /**
     * 通过反射获取泛型
     */
    public static void test2() throws NoSuchMethodException {
        Method test1 = ObjectTest2.class.getMethod("test1", Map.class, List.class);
        Type[] genericParameterTypes = test1.getGenericParameterTypes();
        for (Type genericParameterType : genericParameterTypes) {
            System.out.println(genericParameterType);
            if(genericParameterType instanceof ParameterizedType) {
                Type[] actualTypeArguments = ((ParameterizedType) genericParameterType).getActualTypeArguments();
                for (Type actualTypeArgument : actualTypeArguments) {
                    System.out.println("actual " + actualTypeArgument );
                }
            }
        }
    }

    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
//        test1();
        test2();
    }
}

class ObjectTest{
    public int i;

    private int j;

    static int k;

    public void print(String str) {
        System.out.println(str);
    }
}


class ObjectTest2{
    public void test1(Map<String, Integer> map, List<String> list) {

    }

    public Map<String, Integer> test2() {
        return null;
    }
}
