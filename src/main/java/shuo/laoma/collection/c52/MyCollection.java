package shuo.laoma.collection.c52;

import java.util.AbstractCollection;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

public class MyCollection<E> extends AbstractCollection<E> {
    DynamicArray<E> darr;
    
    public MyCollection(){
        darr = new DynamicArray<>();
    }
    
    public MyCollection(Collection<? extends E> c){
        this();
        addAll(c);
    }

    @Override
    public Iterator<E> iterator() {
        return new DynamicArrayIterator<>(darr);
    }

    @Override
    public int size() {
        return darr.size();
    }

    @Override
    public boolean add(E e) {
        darr.add(e);
        return true;
    }

    public static void main(String[] args) {
        MyCollection<Integer> myCollection = new MyCollection<>();
        myCollection.addAll(Arrays.asList(1,2,3,4,5,56));
        System.out.println(myCollection.contains(2));
        System.out.println(myCollection.contains(21));

        myCollection.retainAll(Arrays.asList(-2,34,56,4));
        System.out.println(myCollection);
    }
}      
