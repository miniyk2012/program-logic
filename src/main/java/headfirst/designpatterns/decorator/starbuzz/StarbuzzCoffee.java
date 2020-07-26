package headfirst.designpatterns.decorator.starbuzz;

import headfirst.designpatterns.decorator.starbuzz.Beverage.Size;

public class StarbuzzCoffee {
    public static void main(String[] args) {
        Beverage originBeverage = new Espresso();
        Beverage beverage = new Mocha(originBeverage);
        beverage = new Mocha(beverage);
        beverage = new Whip(beverage);
        beverage = new Milk(beverage);
        beverage = new Soy(beverage);

        originBeverage.setSize(Size.TALL);
        System.out.println(beverage.getDescription() + " $ " + beverage.cost());

        originBeverage.setSize(Size.GRANDE);
        System.out.println(beverage.getDescription() + " $ " + beverage.cost());

    }
}
