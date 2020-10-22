package shuo.laoma.collection.c47;

import java.util.*;


public class MyMedian<E> {
    private E m;
    private PriorityQueue<E> minP;
    private PriorityQueue<E> maxP;

    public MyMedian() {
        minP = new PriorityQueue<>();
        maxP = new PriorityQueue<>(Collections.reverseOrder());
    }

    private int compare(E m, E e) {
        Comparable<? super E> x = (Comparable<? super E>) m;
        return x.compareTo(e);
    }

    public void add(E e) {
        if (m == null) {
            m = e;
        } else {
            if (compare(m, e) >= 0) {
                maxP.add(e);
            } else {
                minP.add(e);
            }
            if (maxP.size() - minP.size() >= 2) {
                minP.add(m);
                m = maxP.poll();
                return;
            }
            if (minP.size() - maxP.size() >= 2) {
                maxP.add(m);
                m = minP.poll();
                return;
            }
        }
    }

    private E getM() {
        return m;
    }

    private void addAll(Collection<? extends E> c) {
        for (E e : c) {
            add(e);
        }
    }

    public static void main(String[] args) {
        MyMedian<Integer> median = new MyMedian<>();
        Integer[] array = new Integer[]{
                34, 90, 67, 45, 1, 4, 5, 6, 7, 9, 10, 12, 13
        };
        List<Integer> list = Arrays.asList(array);
        median.addAll(list);
        System.out.println(median.getM());
        System.out.println();
        Collections.sort(list);
        System.out.println(list);
    }
}
