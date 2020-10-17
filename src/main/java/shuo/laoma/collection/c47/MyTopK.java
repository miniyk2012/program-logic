package shuo.laoma.collection.c47;

import java.util.Arrays;
import java.util.Collection;
import java.util.PriorityQueue;

public class MyTopK<E> {
    private int k;
    private PriorityQueue<E> p;
    public MyTopK(int k){
        this.k = k;
        p = new PriorityQueue<>();
    }

    public void addAll(Collection<? extends E> c){
        for (E e: c) {
            add(e);
        }
    }

    public void add(E e) {
        if (p.size() < k) {
            p.add(e);
        } else {
            Comparable<E> min = (Comparable<E>)p.peek();
            if (min.compareTo(e) < 0) {
                p.poll();
                p.offer(e);
            }
        }
    }

    public <T> T[] toArray(T[] a){
        return p.toArray(a);
    }

    public E getKth(){
        return p.peek();
    }

    public static void main(String[] args) {
        MyTopK<Integer> top5 = new MyTopK<>(5);
        top5.addAll(Arrays.asList(new Integer[]{
                100, 1, 2, 5, 6, 7, 34, 9, 3, 4, 5, 8, 23, 21, 90, 1, 0
        }));
        System.out.println(Arrays.toString(top5.toArray(new Integer[0])));
        System.out.println(top5.getKth());
        System.out.println();
        MyTopK<Child> ctop5= new MyTopK<>(5);
        for (Integer i: new Integer[]{
                100, 1, 2, 5, 6, 7, 34, 9, 3, 4, 5, 8, 23, 21, 90, 1, 0
        }) {
            ctop5.add(new Child(i));
        }
        System.out.println(Arrays.toString(ctop5.toArray(new Child[0])));
        System.out.println(ctop5.getKth());
    }
}
