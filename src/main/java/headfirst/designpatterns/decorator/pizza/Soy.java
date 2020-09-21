package headfirst.designpatterns.decorator.pizza;

public class Soy extends PizzaDecorator {
    public Soy(Pizza pizza) {
        this.pizza = pizza;
    }
    @Override
    public double cost() {
        return 0.1 + pizza.cost();
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + ", Soy";
    }
}
