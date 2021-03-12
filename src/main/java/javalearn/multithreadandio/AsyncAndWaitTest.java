package javalearn.multithreadandio;

public class AsyncAndWaitTest {
    public static void main(String[] args) throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + "主线程开始");
        Worker worker = new Worker();
        worker.begin();
        System.out.println(Thread.currentThread().getName() + "主线程结束");
        Thread.sleep(4000);
    }
    private static class Worker implements Runnable {

        public void begin() {
            new Thread(this).start();
        }

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + "执行Worker开始");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "执行Worker结束");
        }
    }
}
