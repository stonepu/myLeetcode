package javaKnow.classtest;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.nio.ByteBuffer;

public class ReferenceTest {
    public static void main(String[] args) {
        ByteBuffer bf = ByteBuffer.allocateDirect(1024);
    }

    public static void test1(){
        ReferenceQueue<byte[]> referenceQueue = new ReferenceQueue<>();
        SoftReference<byte[]> softReference = new SoftReference<>(new byte[1], referenceQueue);

    }
}
