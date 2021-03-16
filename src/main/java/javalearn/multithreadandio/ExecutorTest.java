package javalearn.multithreadandio;

import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
/*
    线程池继承体系: https://www.yuque.com/books/share/2b434c74-ed3a-470e-b148-b4c94ba14535/ryn3lf
 */
public class ExecutorTest {
    @Test
    public void basicUsage() throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        // Executors$FinalizableDelegatedExecutorService, 是个代理, 内部包裹了ThreadPoolExecutor
        System.out.println("executorService is: " + executorService.getClass());
        Future<String> result = executorService.submit(() -> {
            System.out.println(Thread.currentThread().getName() + "开始执行");
            Thread.sleep(3000);
            System.out.println(Thread.currentThread().getName() + "执行结束");
            return "success";
        });
        System.out.println("result is" + result.getClass());
        while (!result.isDone()) {
            System.out.println("异步线程还未结束, 等待一秒");
            Thread.sleep(1000);
        }
        System.out.println("result=" + result.get());
        executorService.shutdown();
    }

}
