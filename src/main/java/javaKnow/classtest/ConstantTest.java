package javaKnow.classtest;

public class ConstantTest {
    public static void main(String[] args) {
//        test1();
        test4();

    }

    public static void test1() {
        String str1 = "a";
        String str2 = "b";
        String str3 = "ab";     //存在串池中
        String str4 = str1 + str2;  //new StringBuilder().append("a").append("b")  new String("ab")

        System.out.println(str3 == str4); // false

        String s5 = "a" + "b";
        System.out.println(s5 == str3); //true javac在编译期的优化，结果已经在编译期间确定了
    }

    public static void test2() {
        String s = new String("a") + new String("b");
        String s1 = s.intern();

        System.out.println(s == s1);        //true
        System.out.println(s == "ab");       //true
        System.out.println(s1 == "ab");       //true

    }

    public static void test3() {
        String x = "ab";
        String s = new String("a") + new String("b");
        String s1 = s.intern(); //如果串池中已经有则不会放入串池

        System.out.println(s == s1);        //false
        System.out.println(s == "ab");       //false
        System.out.println(s1 == "ab");       //true

        System.out.println(s == x);        //false
        System.out.println(s1 == x);       //true
    }

    //StringTable 垃圾回收
    //-Xmx10m -XX:+PrintStringTableStatistics -XX:+PrintGCDetails -verbose:gc
    //-XX:StringTableSize=1009
    public static void test4(){
        int i = 0;
        try{
            for (; i < 10000; i++) {
                String.valueOf(i).intern();
            }
        }catch (Throwable e) {
            e.printStackTrace();
        }finally {
            System.out.println(i);
        }
    }

    public static int[] test5(){
        return new int[]{1, 2};
    }



    }
