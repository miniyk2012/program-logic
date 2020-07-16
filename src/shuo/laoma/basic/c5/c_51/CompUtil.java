package shuo.laoma.basic.c5.c_51;

public class CompUtil {
    public static MyComparable max(MyComparable[] objs) {
        if (objs == null || objs.length == 0)
            return null;
        MyComparable max = objs[0];
        for (int i = 1; i < objs.length; i++) {
            if (max.compareTo(objs[i]) < 0) {
                max = objs[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Point p1 = new Point(5,5);
        Point[] points = new Point[]{
                p1, new Point(1, 2), new Point(3, 4),
                new Point(6, 4),
        };
        MyComparable maxPoint = max(points);
        System.out.println(maxPoint);
    }
}
