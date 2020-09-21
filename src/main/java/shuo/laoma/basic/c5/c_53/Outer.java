package shuo.laoma.basic.c5.c_53;

public class Outer {
    private static int shared = 10;
    public static int shared2 = -10;
    public static class StaticInner {
        public void innerMethod() {
            System.out.println("inner shared" + shared);
            System.out.println("inner shared2 " + shared2);
        }
    }

    public static void main(String[] args) {
        StaticInner inner = new StaticInner();
        inner.innerMethod();
    }
}
