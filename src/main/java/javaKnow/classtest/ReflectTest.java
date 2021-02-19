package javaKnow.classtest;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ReflectTest {
    public Set<Integer> test(List<String> list, Map<Integer, Object> map) {
        return null;
    }

    public void test1(int i, int b){}

    public void test2(String ... i1) {

    }

    public static void main(String[] args) throws NoSuchMethodException {
        Method test = ReflectTest.class.getMethod("test", List.class, Map.class);
        Type[] types = test.getGenericParameterTypes();
        for (Type type : types) {
            if(type instanceof ParameterizedType) {
                ParameterizedType parameterizedType = (ParameterizedType)type;
                System.out.println("原始类型 - " + parameterizedType.getRawType());
                System.out.println("原始类型 - " + parameterizedType.getTypeName());

                Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
                for (int i = 0; i < actualTypeArguments.length; i++) {
                    System.out.printf("泛型参数[%d] - %s\n", i, actualTypeArguments[i]);
                }
            }
        }

    }
}
