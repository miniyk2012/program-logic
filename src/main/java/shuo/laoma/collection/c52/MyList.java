package shuo.laoma.collection.c52;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class MyList<E> extends AbstractList<E> {
    private DynamicArray<E> darr;
    
    public MyList(){
        darr = new DynamicArray<>();
    }
    
    public MyList(Collection<? extends E> c){
        this();
        addAll(c);
    }
    
    @Override
    public E get(int index) {
        return darr.get(index);
    }

    @Override
    public int size() {
        return darr.size();
    }

    @Override
    public E set(int index, E element) {
        return darr.set(index, element);
    }

    @Override
    public void add(int index, E element) {
        darr.add(index, element);
    }

    @Override
    public E remove(int index) {
        return darr.remove(index);
    }

    public static void main(String[] args) {
        MyList<Integer> myList = new MyList<>(Arrays.asList(new Integer[] {1,2,3,4,5}));

        System.out.println(myList.get(1));
        System.out.println(myList.indexOf(4));
        List<Integer> subList= myList.subList(1,4);
        System.out.println(myList);
        subList.add(100);
        subList.add(200);
        System.out.println(subList);
        System.out.println(myList);
        myList.clear();
        System.out.println(myList);
    }
}    
