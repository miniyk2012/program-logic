package headfirst.designpatterns.decorator.pizza;

public class Cheese extends PizzaDecorator {
    public Cheese(Pizza pizza) {
        this.pizza = pizza;
    }

    @Override
    public double cost() {
        // cheese is free
        return pizza.cost();
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + ", Cheese";
    }
}
