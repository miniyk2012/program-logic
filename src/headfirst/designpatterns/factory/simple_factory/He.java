package headfirst.designpatterns.factory.simple_factory;

public class He extends SimplePizzaFactory {
    public static void hi() {
        System.out.println("子类hi");
    }
    public static void main(String[] args) {
        SimplePizzaFactory.hi();
        He.hi();

        System.out.println();
        SimplePizzaFactory he = new He();
        he.hi();  // 静态方法不能实现多态

        He he2 = new He();
        he2.hi();
    }
}
