package shuo.laoma.basic.c5.c_51;


public class Point implements MyComparable {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public double distance() {
        return Math.sqrt(x * x + y * y);
    }

    @Override
    public int compareTo(Object other) {
        if (!(other instanceof Point))
            throw new IllegalArgumentException();
        Point otherPoint = (Point) other;
        if (this.distance() > otherPoint.distance()) {
            return 1;
        } else if (this.distance() < otherPoint.distance()) {
            return -1;
        } else {
            return 0;
        }
    }

    @Override
    public String toString() {
        return "(" + x + "," + y + "," + z + ")";
    }
}
