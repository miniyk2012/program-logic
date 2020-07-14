package shuo.laoma.basic.c4.c4_10;

public class Child {
    private long sum;
    private Base base;

    public Child() {
        base = new Base();
    }

    public void add(int num) {
        base.add(num);
        sum += num;
    }

    public void addAll(int[] nums) {
        base.addAll(nums);
        for (int num : nums)
            sum += num;
    }

    public long getSum() {
        return sum;
    }

    public static void main(String[] args) {
        Child c = new Child();
        c.addAll(new int[]{1, 2, 3});
        System.out.println(c.getSum());
    }
}
