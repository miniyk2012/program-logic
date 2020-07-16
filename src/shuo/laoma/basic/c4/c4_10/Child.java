package shuo.laoma.basic.c4.c4_10;

public class Child implements IAdd {
    private long sum;
    private IAdd base;

    public Child() {
        base = new Base();
    }

    @Override
    public void add(int num) {
        base.add(num);
        sum += num;
    }

    @Override
    public void addAll(int[] nums) {
        base.addAll(nums);
        for (int num : nums)
            sum += num;
    }

    public long getSum() {
        return sum;
    }

    public static void main(String[] args) {
        IAdd c = new Child();
        c.addAll(new int[]{1, 2, 3});
        System.out.println(((Child)c).getSum());
    }
}
