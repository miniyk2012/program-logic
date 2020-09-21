package headfirst.designpatterns.strategy;

public class MiniDuckSimulator1 {
    public static void main(String[] args) {
        Duck mallard = new MallardDuck();
        mallard.performQuack();
        mallard.performFly();
        mallard.swim();
        mallard.display();

        System.out.println("------");
        Duck model = new ModelDuck();
        model.performFly();
        model.setFlyBehavior(()-> System.out.println("乘中国卫星上天"));
        model.performFly();
        model.swim();
        model.display();
    }
}
