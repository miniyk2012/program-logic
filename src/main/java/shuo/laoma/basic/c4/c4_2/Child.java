package shuo.laoma.basic.c4.c4_2;

public class Child extends Base {
    public static String s = "static_child";
    public String m = "child";

    public static void staticTest(){
        System.out.println("child static: " + s);
    }

    public void test() {
            System.out.println("child test");
    }

    public static void main(String[] args) {
        Child c = new Child();
        Base b = c;
        System.out.println(b.s);
        System.out.println(b.m);
        b.staticTest();
        System.out.println(c.s);
        System.out.println(c.m);
        c.staticTest();
        b.test();
        c.test();
        Child d = (Child) b;
        d.test();
    }
}
