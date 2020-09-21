package main.java.shuo.laoma.collection.c35;

public class MyPair<U,V> {
    U first;
    V second;

    public MyPair(U first, V second){
        this.first = first;
        this.second = second;
    }

    public U getFirst() {
        return first;
    }

    public V getSecond() {
        return second;
    }

    public static void main(String[] args) {
        MyPair<String,Integer> mypair = new MyPair<>("杨恺", 12);
        String first = mypair.getFirst();
        Integer second = mypair.getSecond();
    }
}
