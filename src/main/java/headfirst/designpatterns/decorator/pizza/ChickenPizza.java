package headfirst.designpatterns.decorator.pizza;

public class ChickenPizza extends Pizza {
    public ChickenPizza() {
        description = "Chicken Pizza";
    }
    @Override
    public double cost() {
        return 10;
    }
}
