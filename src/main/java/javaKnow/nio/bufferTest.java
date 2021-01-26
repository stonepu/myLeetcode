package javaKnow.nio;

import java.nio.ByteBuffer;
import java.nio.channels.Channel;
import java.nio.file.Files;

public class bufferTest {

    public static void test(){
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        System.out.println("limit: " + buffer.limit());
        System.out.println("capacity: " + buffer.capacity());
        System.out.println("position: " + buffer.position());

        String str = "12345";
        buffer.put(str.getBytes());
        System.out.println("===============================");
        System.out.println("write data to buffer");
        System.out.println("limit: " + buffer.limit());
        System.out.println("capacity: " + buffer.capacity());
        System.out.println("position: " + buffer.position());


        buffer.flip();
        System.out.println("===========================");
        System.out.println("flip");
        System.out.println("limit: " + buffer.limit());
        System.out.println("capacity: " + buffer.capacity());
        System.out.println("position: " + buffer.position());
        buffer.get();
//        Files.newByteChannel();
    }

    public static void main(String[] args) {
        test();
    }
}
