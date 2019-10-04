package headfirst.designpatterns.decorator.starbuzz;

import headfirst.designpatterns.decorator.starbuzz.Beverage;
import headfirst.designpatterns.decorator.starbuzz.CondimentDecorator;

public class Soy extends CondimentDecorator {

    public Soy(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Soy";
    }

    @Override
    public double cost() {
        Size size = getSize();
        double cost = beverage.cost();
        switch (size) {
            case TALL:
                return cost + 0.1;
            case GRANDE:
                return cost + 0.15;
            case VENTI:
                return cost + 0.2;

        }
        throw new RuntimeException("Not supported Size");
    }
}
