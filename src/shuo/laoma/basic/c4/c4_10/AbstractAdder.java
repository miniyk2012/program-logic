package shuo.laoma.basic.c4.c4_10;

public abstract class AbstractAdder implements IAdd {
    @Override
    public void addAll(int[] numbers) {
        for (int num: numbers)
            add(num);
    }
}
