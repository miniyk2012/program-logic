package shuo.laoma.collection.c36;

import com.sun.istack.internal.NotNull;

import java.util.Arrays;

public class MyDynamicArray<E> {
    private static final int DEFAULT_CAPACITY = 10;

    private int size;
    private Object[] elementData;

    public MyDynamicArray() {
        this.elementData = new Object[DEFAULT_CAPACITY];
    }

    private void ensureCapacity(int minCapacity) {
        int oldCapacity = elementData.length;
        if (oldCapacity >= minCapacity) {
            return;
        }
        int newCapacity = oldCapacity * 2;
        if (newCapacity < minCapacity) {
            newCapacity = minCapacity;
        }
        elementData = Arrays.copyOf(elementData, newCapacity);
    }

    public void add(E e) {
        ensureCapacity(size + 1);
        elementData[size++] = e;
    }

    @SuppressWarnings("unchecked")
    public E get(int index) {
        return (E) elementData[index];
    }

    public int size() {
        return size;
    }

    public E set(int index, E element) {
        E oldValue = get(index);
        elementData[index] = element;
        return oldValue;
    }

    public void addAll(MyDynamicArray<? extends E> c) {
        for (int i = 0; i < c.size; i++) {
            add(c.get(i));
        }
    }



    /**
     * @param args: 命令行参数
     */
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


    }
}
