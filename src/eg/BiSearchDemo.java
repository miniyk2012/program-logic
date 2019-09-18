package eg;

import java.util.*;
import java.util.Set;
import java.util.HashSet;

public class BiSearchDemo {

    public static int biSearch(List<Integer> array, int a) {
        int right = array.size() - 1;
        int left = 0;
        while (right >= left) {
            int mid = (right + left) / 2;
            System.out.println("left is " + left);
            System.out.println("right is " + right);
            System.out.println("mid is " + mid);
            if (array.get(mid) == a) {
                return mid;
            } else if (array.get(mid) < a) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
    public static List<Integer> listSort(List<Integer> l) {
        Collections.sort(l, (o1, o2) -> o1 - o2);
        return l;
    }

    public static int revser(int a) {
        int b = 0;
        while (a >= 10) {
            b = 10 * b + a%10;
            a /= 10;
        }
        return b*10 + a;
    }

    public static void main(String[] args) throws InterruptedException {
        Integer[] array = {1, 6, 3, 5, -3};
        List<Integer> l = Arrays.asList(array);
        listSort(l);
        for (Integer i: l) {
            System.out.print(i + " ");
        }
        int index = biSearch(l, -30);
        System.out.println("" + index);
        int a = 2948;
        int b = revser(a);
        System.out.println(b);
        runThreads();
        runRunnable();
    }

    public static class MyThread extends Thread {
        int i = 0;
        @Override
        public void run() {
            for(; i<100; i++) {

            }
            System.out.println(i);
        }
    }

    public static class RunnableThread implements Runnable {
        private int i;
        @Override
        public void run() {
            for(; i<95; i++) {

            }
            System.out.println("runnable" + i);
        }
    }

    public static void runThreads() throws InterruptedException {
        List<MyThread> threads = new LinkedList<>();
        for (int i=0; i<10; i++) {
            threads.add(new MyThread());
        }
        for (MyThread t: threads) {
            t.start();
        }
        for (MyThread t: threads) {
            t.join();
        }
    }

    public static void runRunnable() throws InterruptedException {
        List<Thread> threads = new LinkedList<>();
        for (int i=0; i<10; i++) {
            threads.add(new Thread(new RunnableThread()));
        }
        for (Thread t: threads) {
            t.start();
        }
        for (Thread t: threads) {
            t.join();
        }
    }

}


