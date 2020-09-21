package eg.interview;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class ThreadSum {
    public static class Count {
        public int count = 0;

        synchronized public void increment(int i) {
            count += i;
        }
    }

    public static class Work implements Runnable {
        private CountDownLatch downLatch;
        private int[] array;
        private int start;
        private int end;
        private Count count;

        public Work(Count count, CountDownLatch downLatch, int[] array, int start, int end) {
            this.downLatch = downLatch;
            this.start = start;
            this.end = end;
            this.array = array;
            this.count = count;
        }

        public void run() {
            int sum = 0;
            for (int i = start; i < end; i++) {
                sum += array[i];
            }
            count.increment(sum);
            System.out.println("活干完了！");
            this.downLatch.countDown();
        }
    }


    public static void main(String[] args) {
        int Num = 10000;
        int array[] = new int[Num];
        for (int i = 0; i < Num; i++) {
            array[i] = i + 1;
        }
        Count count = new Count();
        CountDownLatch latch = new CountDownLatch(5);
        ExecutorService executor = Executors.newCachedThreadPool();
        Work w1 = new Work(count, latch, array, 0, 2000);
        Work w2 = new Work(count, latch, array, 2000, 4000);
        Work w3 = new Work(count, latch, array, 4000, 6000);
        Work w4 = new Work(count, latch, array, 6000, 8000);
        Work w5 = new Work(count, latch, array, 8000, Num);
        executor.execute(w5);
        executor.execute(w4);
        executor.execute(w3);
        executor.execute(w2);
        executor.execute(w1);

        try {
            latch.await();
        } catch (InterruptedException e) {
        }
        executor.shutdown();
        System.out.println(count.count);
    }

}



