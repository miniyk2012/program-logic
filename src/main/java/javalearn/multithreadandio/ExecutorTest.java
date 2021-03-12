package javalearn.multithreadandio;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorTest {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<?> result = executorService.submit(() -> {
            System.out.println(Thread.currentThread().getName() + "开始执行");
            Thread.sleep(3000);
            System.out.println(Thread.currentThread().getName() + "执行结束");
            return "success";
        });
        System.out.println("result=" + result.get());
        executorService.shutdown();
    }
}
