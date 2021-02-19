package javaKnow.thread.changefbd;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;

public class SimpleDateFormatTest {

    public static void test1() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                synchronized (simpleDateFormat) {
                    try {
                        System.out.println(simpleDateFormat.parse("1952-01-01"));
                    }catch (Exception e) {
                        e.printStackTrace();
                    }
                }

            }).start();
        }


//        try {
//            System.out.println(simpleDateFormat.parse("1952-1-1"));
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
    }

    public static void test2() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
//                synchronized (dateTimeFormatter) {
                    try {
                        System.out.println(dateTimeFormatter.parse("1952-01-01"));
                    }catch (Exception e) {
                        e.printStackTrace();
                    }
//                }

            }).start();
        }
    }

    public static void main(String[] args) {
//        test1();
        test2();
    }
}
