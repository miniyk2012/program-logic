package shuo.laoma.collection.c46;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class MyPriorityQueueDemo {
    public static void reverse() {
        Queue<Integer> priorityQueue = new PriorityQueue<>(Comparator.reverseOrder());
        priorityQueue.offer(13);
        priorityQueue.offer(20);
        priorityQueue.offer(-5);
        while (!priorityQueue.isEmpty()) {
            System.out.println(priorityQueue.poll());
        }
    }

    public static void basic() {
        Queue<Integer> pq = new PriorityQueue<>();
        pq.offer(10);
        pq.add(22);
        pq.addAll(Arrays.asList(new Integer[]{
                11, 12, 34, 2, 7, 4, 15, 12, 8, 6, 19, 13 }));
        while(pq.peek()!=null){
            System.out.print(pq.poll() + " ");
        }
    }

    public static void main(String[] args) {
        reverse();
        basic();
    }
}
