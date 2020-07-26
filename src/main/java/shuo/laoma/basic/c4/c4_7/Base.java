package shuo.laoma.basic.c4.c4_7;

public class Base {
    public static int s = 5;
    private int a = 100;

    static {
        System.out.println("基类静态代码, s:" + s);
        s = 1;
    }

    {
        System.out.println("基类实例代码, a:" + a);
        a = 1;
    }

    public Base() {
        System.out.println("基类构造方法, a:" + a);
        a = 2;
    }

    protected void step() {
        System.out.println("base s:" + s + ", a:" + a);
    }

    public void action() {
        System.out.println("start");
        step();
        System.out.println("end");
    }
}
