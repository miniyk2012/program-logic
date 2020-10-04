package shuo.laoma.collection.c39;

import java.util.ArrayDeque;
import java.util.Deque;

public class ArrayDequeDemo {
    public static void queueDemo() {
        Deque<String> deque = new ArrayDeque<>();
        deque.offer("a");
        deque.offer("b");
        deque.offer("c");
        while (!deque.isEmpty()) {
            System.out.println(deque.poll());
        }
    }

    public static void dequeDemo() {
        Deque<String> deque = new ArrayDeque<>();
        deque.offerFirst("a");
        deque.offerFirst("b");
        deque.offerFirst("c");
        while (!deque.isEmpty()) {
            System.out.println(deque.poll());
        }
    }

    public static void main(String[] args) {
        queueDemo();
        System.out.println();
        dequeDemo();
    }
}
