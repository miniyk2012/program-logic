package shuo.laoma.collection.c52;

import java.util.AbstractSequentialList;
import java.util.Arrays;
import java.util.Collection;
import java.util.ListIterator;

public class MySeqList<E> extends AbstractSequentialList<E> {
    private DynamicArray<E> darr;
    
    public MySeqList(){
        darr = new DynamicArray<>();
    }
    
    public MySeqList(Collection<? extends E> c){
        this();
        addAll(c);
    }
    
    @Override
    public ListIterator<E> listIterator(int index) {
        return new DynamicArrayListIterator<>(index, darr);
    }

    @Override
    public int size() {
        return darr.size();
    }

    public static void main(String[] args) {
        MySeqList<Integer> mySeqList = new MySeqList<>(Arrays.asList(new Integer[] {1,2,3,4,5}));
        mySeqList.add(1,100);
        mySeqList.add(mySeqList.size(),1000);
        System.out.println(mySeqList);
        mySeqList.remove(0);
        System.out.println(mySeqList);
        System.out.println(mySeqList.size());
    }
}    
