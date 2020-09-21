package shuo.laoma.collection.c35;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MyGenericDemo {
    public static <T> T get(T[] arr, int index) {
        return arr[index];
    }


    public static <U, V> MyPair<U, V> makePair(U first, V second) {
        MyPair<U, V> pair = new MyPair<>(first, second);
        return pair;
    }

    public static <T extends Comparable<T>> T max(T[] arr) {
        T maximun = arr[0];
        for (int i=1; i<arr.length; i++) {
            if (arr[i].compareTo(maximun) > 0) {
                maximun = arr[i];
            }
        }
        return maximun;
    }

    static List<Integer> intList = Arrays.asList(2, 3, 1);

    public static void main(String[] args) {
        System.out.println(get(new String[]{"a", "b", "C"}, 2));
        MyPair<String, Integer> pair = makePair("杨恺", 12);
        System.out.println(pair.getFirst());
        System.out.println(pair.getSecond());

        Collections.sort(intList, (o1, o2) -> o2 - o1);
        System.out.println(Arrays.toString(intList.toArray()));

        System.out.println(max(new Integer[]{-1, 40, 920, -12}));
    }

}
