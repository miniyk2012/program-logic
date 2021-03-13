package javalearn.multithreadandio;

import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadTest {
    public Runnable runnable = () -> {
        System.out.println(Thread.currentThread().getName() + "执行开始");
        try {
            System.out.println("执行1s");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "执行结束");
    };

    @Test
    public void testThread1() throws InterruptedException {
        // 方式2：构造方法传入Runnable实例
        Thread t = new Thread(runnable);
        t.start();
        t.join();
    }

    @Test
    public void testThread2() throws InterruptedException {
        // 方式2：重写Thread#run()
        Thread t = new Thread() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "执行开始");
                try {
                    System.out.println("执行1s");
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "执行结束");
            }
        };
        t.start();
        t.join();
    }

    @Test
    public void testThread3() throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<?> submit = executorService.submit(runnable);
        Object result = submit.get();
        System.out.println("result=======>" + result);
        // 关闭线程池
        executorService.shutdown();
    }
}
