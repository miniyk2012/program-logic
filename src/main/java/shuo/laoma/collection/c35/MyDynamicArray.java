package shuo.laoma.collection.c35;


import java.util.Arrays;
import java.util.Random;

public class MyDynamicArray<E> {
    private static final int DEFAULT_CAPACITY = 0;
    private int size;
    private Object[] elements;

    public MyDynamicArray() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    private void ensureCapacity(int minCapacity) {
        int oldCapacity = elements.length;
        if (oldCapacity >= minCapacity) {
            return;
        }
        int newCapacity = 2 * minCapacity;
        if (oldCapacity < minCapacity) {
            newCapacity = minCapacity;
        }
        elements = Arrays.copyOf(elements, newCapacity);
    }

    public int size() {
        return size;
    }

    public E get(int index) {
        return (E) elements[index];
    }

    public void add(E e) {
        ensureCapacity(size + 1);
        elements[size++] = e;
    }


    public E set(int index, E element) {
        E old = get(index);
        elements[index] = element;
        return old;
    }

    public <T extends E> void addAll(MyDynamicArray<T> c) {
        for (int i = 0; i < c.size(); i++) {
            add(c.get(i));
        }
    }

    public static void main(String[] args) {
        MyDynamicArray<Integer> array = new MyDynamicArray<>();
        array.add(10);
        array.add(15);
        for (int i = 0; i < array.size(); i++) {
            System.out.println(array.get(i));
        }

        DynamicArray<Double> arr = new DynamicArray<>();
        Random rnd = new Random();
        int size = 1 + rnd.nextInt(100);
        for (int i = 0; i < size; i++) {
            arr.add(Math.random());
        }
        System.out.println(arr.get(rnd.nextInt(size)));

        DynamicArray<MyPair<Integer, String>> arr2 = new DynamicArray<>();
        arr2.add(new MyPair<>(12, "yangkai"));
        System.out.println(arr2.get(0).getFirst());
        System.out.println(arr2.get(0).getSecond());


        MyDynamicArray<Number> numbers = new MyDynamicArray<>();
        MyDynamicArray<Integer> ints = new MyDynamicArray<>();
        ints.add(105);
        ints.add(155);
        numbers.addAll(ints);
        for (int i = 0; i < numbers.size(); i++) {
            System.out.println(numbers.get(i));
        }
    }
}
