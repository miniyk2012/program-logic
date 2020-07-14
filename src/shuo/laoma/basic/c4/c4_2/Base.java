package shuo.laoma.basic.c4.c4_2;

public class Base {
    public static String s = "static_base";
    public String m = "base";

    public static void staticTest(){
        System.out.println("base static: " + s);
    }

    public void test() {
        System.out.println("base test");
    }
}
