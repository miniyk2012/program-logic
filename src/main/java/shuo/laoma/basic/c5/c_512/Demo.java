package shuo.laoma.basic.c5.c_512;

public class Demo {
    public static void main(String[] args) {
        Size size = Size.LARGE;
        System.out.println(size.toString());
        System.out.println(size.name());
        System.out.println(size.ordinal());
        System.out.println(size.compareTo(Size.MEDIUM));
        System.out.println(Size.values());
        System.out.println(Size.values()[1]);
        for(Size s: Size.values())
            System.out.println(s);

        Size s2 = Size.valueOf("LARGE");
    }

    static void onChonsen(Size size) {
        switch (size) {
            case SMALL:
                System.out.println("chose small");
                break;
        }
    }
}
