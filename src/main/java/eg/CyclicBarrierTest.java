package eg;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierTest {
    public static void main(String[] args) {
        // 叫做Cyclic是因为当所有等待线程都被释放以后，CyclicBarrier可以被重用
        CyclicBarrier barrier = new CyclicBarrier(3, () -> {
            System.out.println("\n屏障放开，[屏障线程]先运行！");});
        for (int i = 0; i < barrier.getParties(); i++) {
            new Thread(new MyRunnable(barrier), "队友" + i).start();
        }
        System.out.println("main function is finished.");
    }

    private static class MyRunnable implements Runnable {
        private CyclicBarrier barrier;

        public MyRunnable(CyclicBarrier barrier) {
            this.barrier = barrier;
        }

        @Override
        public void run() {
            for (int i = 0; i < 3; i++) {
                try {
                    Random rand = new Random();
                    int randomNum = rand.nextInt(5000);//产生1000到3000之间的随机整数
                    Thread.sleep(randomNum);
                    this.barrier.await();
                    System.out.println(Thread.currentThread().getName() +
                            ", 通过了第" + i + "个障碍物, 使用了 " + ((double) randomNum / 1000) + "s");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}