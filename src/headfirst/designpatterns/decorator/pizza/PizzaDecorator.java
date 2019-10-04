package headfirst.designpatterns.decorator.pizza;

public abstract class PizzaDecorator extends Pizza {
    protected Pizza pizza;
    @Override
    public abstract String getDescription();
}
