package javalearn.multithreadandio;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.LockSupport;

public class ParkTest {
    public static void main(String[] args) throws InterruptedException {
        // 存储线程
        List<Thread> threadList = new ArrayList<>();
        Object obj = new Object();
        // 创建5个线程
        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(() -> {
                System.out.println("我是" + Thread.currentThread().getName() + ", 我开始工作了~");
                LockSupport.park(obj);
                System.out.println("我是" + Thread.currentThread().getName() + ", 我又活过来了~");
            });
            thread.start();
            threadList.add(thread);
        }

        Thread.sleep(3 * 1000L);
        System.out.println("====== 所有线程都阻塞了，3秒后全部恢复了 ======");

        // unPark()所有线程
        for (Thread thread : threadList) {
            LockSupport.unpark(thread);
        }

        // 等所有线程执行完毕
        Thread.sleep(3 * 1000L);
    }
}
