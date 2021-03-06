package shuo.laoma.collection.c35;

public class GenericDemo {

    public static <T> int indexOf(T[] arr, T elm) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals(elm)) {
                return i;
            }
        }
        return -1;
    }

    public static <U, V> Pair<U, V> makePair(U first, V second) {
        Pair<U, V> pair = new Pair<>(first, second);
        return pair;
    }

    public static <T extends Comparable<T>> T max(T[] arr) {
        T max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i].compareTo(max) > 0) {
                max = arr[i];
            }
        }
        return max;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Pair<Float, String> pair = makePair(200.99F, "20");
        System.out.println(pair.getFirst() + pair.getSecond());
        Integer[] a = new Integer[]{34, 3, 4, 233};
        System.out.println(max(a));
        System.out.println(indexOf(a, 3));
        System.out.println(indexOf(new String[]{"hello", "老马", "编程"}, "老马"));
    }
}
