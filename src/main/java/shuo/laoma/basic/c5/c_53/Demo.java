package shuo.laoma.basic.c5.c_53;

public class Demo {
    public static void main(String[] args) {
        Outer.StaticInner si = new Outer.StaticInner();
        si.innerMethod();
        Outer.shared2 = 100;
        si.innerMethod();
    }
}
