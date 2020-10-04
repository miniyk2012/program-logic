package shuo.laoma.collection.c40;

import java.util.ArrayDeque;
import java.util.Deque;

public class MyArrayDequeDemo {
    public static void main(String[] args) {
        Deque<String> deque = new ArrayDeque<>();
        deque.offer("a");
        deque.offer("b");
        deque.offer("c");
        while (!deque.isEmpty()) {
            System.out.println(deque.poll());
        }
    }
}
