package headfirst.designpatterns.decorator.pizza;

public class PizzaStore {
    public static void main(String[] args) {
        Pizza pizza = new ChickenPizza();
        Pizza soyPizza = new Soy(pizza);
        Pizza fullPizza = new Cheese(soyPizza);

        System.out.println(fullPizza.getDescription() + ": " + fullPizza.cost());
    }
}
