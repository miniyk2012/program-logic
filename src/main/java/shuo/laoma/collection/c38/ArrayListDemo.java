package shuo.laoma.collection.c38;

import java.util.*;

public class ArrayListDemo {
    public void reverseTraverse(List<Integer> list){
        ListIterator<Integer> it = list.listIterator(list.size());
        while(it.hasPrevious()){
            System.out.println(it.previous());
        }
    }
    public void remove(ArrayList<Integer> list){
        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            if (it.next() < 100) {
                it.remove();
            }
        }

    }
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(10);
        arr.add(110);
        arr.add(12);
        arr.add(130);
        ArrayListDemo demo = new ArrayListDemo();
        demo.reverseTraverse(arr);
        demo.remove(arr);
        for (Integer v: arr) {
            System.out.println(v);
        }

        ArrayList<Integer> intList = new ArrayList<>();
        intList.add(123);
        intList.add(456);
        intList.add(789);
        Integer[] arrA = new Integer[4];
        Integer[] c = intList.toArray(arrA);

        Integer[] arrB = intList.toArray(new Integer[0]);

        System.out.println(Arrays.equals(arrA, arrB));
        System.out.println(Arrays.equals(c, arrB));
        System.out.println(c == arrA);
        System.out.println(Arrays.toString(arrA));
        System.out.println(Arrays.toString(arrB));
        System.out.println(Arrays.toString(c));

        Integer[] a = {1,2,3};
        List<Integer> list = Arrays.asList(a);
        list.set(1, 10);
        System.out.println(Arrays.toString(a));
    }
}
