package javaKnow.classtest;

import jdk.internal.org.objectweb.asm.ClassWriter;
import jdk.internal.org.objectweb.asm.Opcodes;

public class ClassWriterTest {

}

/**
 * 元空间内存溢出
 * -XX:MaxMetaSpaceSize=8m
 */
class TestClassLoader extends ClassLoader{
    public static void main(String[] args) {
        int j = 0;
        try{
            TestClassLoader cl = new TestClassLoader();
            for(int i = 0; i < 100000; i++) {
                ClassWriter classWriter = new ClassWriter(0);
                classWriter.visit(Opcodes.V1_8, Opcodes.ACC_PUBLIC, "Class" + i,
                        null, "java/lang/Object", null);

                byte[] code = classWriter.toByteArray();
                cl.defineClass("Class" + i, code, 0, code.length);
                ++j;
            }
        }finally {
            System.out.println(j);
        }
    }
}
