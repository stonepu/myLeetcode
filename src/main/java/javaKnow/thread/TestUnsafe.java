package javaKnow.thread;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

public class TestUnsafe {

    public static Unsafe getUnsafe() {
        Field theUnsafe = null;
        try {
            theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        theUnsafe.setAccessible(true);
        Unsafe unsafe = null;
        try {
            unsafe = (Unsafe) theUnsafe.get(null);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return unsafe;
    }

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Unsafe unsafe = getUnsafe();

        System.out.println(unsafe);
        //1. 获取域偏移地址
        long idOffset = unsafe.objectFieldOffset(Teacher.class.getDeclaredField("id"));
        long nameOffset = unsafe.objectFieldOffset(Teacher.class.getDeclaredField("name"));

        Teacher teacher = new Teacher();
        unsafe.compareAndSwapInt(teacher, idOffset, 0, 1    );
        unsafe.compareAndSwapObject(teacher, nameOffset, null, "张三");


        System.out.println(teacher);
    }
}

class Teacher{
    volatile int id;
    volatile String name;

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

class MyAtomicInteger{
    private volatile int value;

    private static final Unsafe UNSAFE;
    private static final long valueOffset;

    static {
        UNSAFE = TestUnsafe.getUnsafe();
        try {
            valueOffset = UNSAFE.objectFieldOffset(MyAtomicInteger.class.getDeclaredField("value"));
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public int getValue(){
        return value;
    }

    public void decrement(int amount) {
        while (true) {
            int pre = this.value;
            int next = pre - amount;
            if(UNSAFE.compareAndSwapInt(this, valueOffset, pre, next)) break;
        }
    }
}
