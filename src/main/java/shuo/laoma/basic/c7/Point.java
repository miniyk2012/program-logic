package shuo.laoma.basic.c7;


/**
 * Created by thomas_young on 7/6/2018.
 */
class Point {
    public int x;
    public int y;
    public char c;  // 初始化为'/u0000'
    public Point p;
    public boolean b;
    public Boolean pb;

    static int STATIC_ONE = 1;
    static int STATIC_TWO = 10;

    // 静态初始化代码块在类加载的时候执行，这是在任何对象创建之前，且只执行一次。
    static
    {
        System.out.println("x" + STATIC_TWO);
        STATIC_TWO = 2;
    }

    public double distance(){
        return Math.sqrt(x*x+y*y);
    }

    public static void main(String[] args) {
        // 即使没有代码，类加载也会运行static代码块
//        Point p = new Point();
//        p.x = 2;
//        p.y = 3;
//        System.out.println(p.distance());
//        System.out.println(p.c);
//        System.out.println(Integer.toHexString(p.c));
//        System.out.println(p.p);
//        System.out.println(p.b);
//        System.out.println(p.pb);
//        Point p2 = new Point();
//
//
//
//        System.out.println(Point.STATIC_TWO);
    }
}
