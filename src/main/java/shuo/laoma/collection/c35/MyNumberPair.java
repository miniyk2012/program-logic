package main.java.shuo.laoma.collection.c35;

public class MyNumberPair<U extends Number, V extends Number> extends MyPair<U, V> {
    public MyNumberPair(U first, V second) {
        super(first, second);
    }

    public double sum(){
        return getFirst().doubleValue() + getSecond().doubleValue();
    }

    public static void main(String[] args) {
        MyNumberPair<Integer, Float> myNumberPair = new MyNumberPair<>(10, 11F);
        System.out.println(myNumberPair.sum());
    }
}
