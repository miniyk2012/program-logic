package eg.CAS;

import java.util.concurrent.atomic.AtomicInteger;

public class CasExamples {
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger();
        new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (!atomicInteger.compareAndSet(0, 100)) {
                System.out.println("0-100:失败");
            }
        }).start();

        new Thread(() -> {
            try {
                Thread.sleep(500);////注意这里睡了一会儿，目的是让第三个线程先执行判断的操作，从而让第三个线程修改失败
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (!atomicInteger.compareAndSet(100, 50)) {
                System.out.println("100-50:失败");
            }
        }).start();

        new Thread(() -> {
            if (!atomicInteger.compareAndSet(50, 60)) {
                System.out.println("50-60:失败");
            }
        }).start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(atomicInteger);
    }

    public static void incrementAndGetTest(String[] args) {
        Thread[] threads = new Thread[20];
        AtomicInteger atomicInteger = new AtomicInteger();
        for (int i = 0; i < 20; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    atomicInteger.incrementAndGet();
                }
            });
            threads[i].start();
        }
        join(threads);
        System.out.println("x=" + atomicInteger.get());
    }

    private static void join(Thread[] threads) {
        for (int i = 0; i < 20; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
