package eg;

public class Car extends Vehicle {
    public int funnelLevel;
    public Car(int id, int year, int funnelLevel) {
        super(id, year);
        this.funnelLevel = funnelLevel;
    }

    public static void main(String[] args) {
        Car car = new Car(1, 2009, 50);
        System.out.println(car.year);
        car.year = 2010;
        System.out.println(car.year);
    }
}
