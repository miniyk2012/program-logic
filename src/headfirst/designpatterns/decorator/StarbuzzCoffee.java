package headfirst.designpatterns.decorator;

public class StarbuzzCoffee {
    public static void main(String[] args) {
        Beverage beverage = new Espresso();
        beverage = new Mocha(beverage);
        beverage = new Mocha(beverage);
        beverage = new Whip(beverage);
        beverage = new Milk(beverage);

        System.out.println(beverage.getDescription() + " $ " + beverage.cost());
    }
}
