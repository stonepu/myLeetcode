package javaKnow.thread;

import java.math.BigDecimal;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

public class AtomicTest {

    public static void test1() {
        AtomicInteger i = new AtomicInteger(5);
        i.updateAndGet(x -> x * 10);
        i.getAndUpdate(x -> x + 1);
        i.addAndGet(10);
        i.compareAndSet(i.get(), 10);

    }

    //atomicReference 会有ABA问题
    public static void test2() {
        BigDecimal i = new BigDecimal(10);
        AtomicReference<BigDecimal> balance = new AtomicReference<>(i);
        balance.updateAndGet(x ->
            x.add(new BigDecimal(10))
        );
    }

    public static void test3() {
        BigDecimal i = new BigDecimal(10);
        AtomicStampedReference<BigDecimal> balance = new AtomicStampedReference<>(i, 0);
//        balance.compareAndSet()
    }
}
