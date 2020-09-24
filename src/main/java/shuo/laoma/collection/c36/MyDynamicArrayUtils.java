package shuo.laoma.collection.c36;


public class MyDynamicArrayUtils {
    private static <T> void swapInternal(MyDynamicArray<T> arr, int i, int j) {
        T tmp = arr.get(i);
        arr.set(i, arr.get(j));
        arr.set(j, tmp);
    }

    public static void swap(MyDynamicArray<?> arr, int i, int j) {
        swapInternal(arr, i, j);
    }


    public static int indexOf(MyDynamicArray<?> arr, Object elm) {
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i).equals(elm)) {
                return i;
            }
        }
        return -1;
    }

    public static <D, S extends D> void copy(MyDynamicArray<D> dest, MyDynamicArray<S> src) {
        for (int i = 0; i < src.size(); i++) {
            dest.add(src.get(i));
        }
    }

    public static <T extends Comparable<? super T>> T max(MyDynamicArray<T> array) {
        T max = array.get(0);
        for (int i = 1; i < array.size(); i++) {
            if (max.compareTo(array.get(i)) < 0) {
                max = array.get(i);
            }
        }
        return max;
    }


    public static void main(String[] args) {
        MyDynamicArray<Number> numbers = new MyDynamicArray<>();
        MyDynamicArray<Integer> ints = new MyDynamicArray<>();
        ints.add(100);
        ints.add(34);
        numbers.addAll(ints);
        MyDynamicArray<Float> floats = new MyDynamicArray<>();
        floats.add(1.5F);
        floats.add(4.56F);
        numbers.addAll(floats);
        for (int i = 0; i < numbers.size(); i++) {
            System.out.println(numbers.get(i));
        }
        System.out.println(indexOf(numbers, 34));
        System.out.println(indexOf(numbers, 35));
        System.out.println(indexOf(numbers, 1.5F));
        System.out.println();
        swap(numbers, 0, 3);
        for (int i = 0; i < numbers.size(); i++) {
            System.out.println(numbers.get(i));
        }

        System.out.println();
        MyDynamicArray<Number> dest = new MyDynamicArray<>();
        copy(dest, floats);
        for (int i = 0; i < floats.size(); i++) {
            System.out.println(dest.get(i));
        }

        System.out.println();
        System.out.println(max(ints));

        MyDynamicArray<Child> childs = new MyDynamicArray<>();
        childs.add(new Child(100));
        childs.add(new Child(110));
        System.out.println(max(childs));
    }
}
