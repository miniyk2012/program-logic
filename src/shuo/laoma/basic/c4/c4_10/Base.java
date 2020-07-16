package shuo.laoma.basic.c4.c4_10;


public class Base extends AbstractAdder {
    private static final int MAX_NUM = 100;
    private int[] arr = new int[MAX_NUM];
    private int count;

    @Override
    public final void add(int num) {
        if (count < MAX_NUM)
            arr[count++] = num;
    }

}
