package javalearn.multithreadandio;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class FutureTaskTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<String> futureTask = new FutureTask<>(() -> {
            System.out.println(Thread.currentThread().getName() + "执行Callable开始");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "执行Callable结束");
            return "success";
        });
        // 传入futureTask，启动线程执行任务
        System.out.println(Thread.currentThread().getName() + "========>启动任务");
        new Thread(futureTask).start();

        // 但它同时又实现了Future，可以获取异步结果（会阻塞3秒）
        System.out.println(futureTask.get());

    }
}
