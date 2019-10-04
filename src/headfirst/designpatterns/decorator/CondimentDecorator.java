package headfirst.designpatterns.decorator;

public abstract class CondimentDecorator extends Beverage {
    protected Beverage beverage;

    @Override
    public abstract String getDescription();
    @Override
    public Size getSize() {
        return beverage.getSize();
    }
}
