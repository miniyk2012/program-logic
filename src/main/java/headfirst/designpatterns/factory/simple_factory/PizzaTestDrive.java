package headfirst.designpatterns.factory.simple_factory;

public class PizzaTestDrive {
    public static void main(String[] args) {
        SimplePizzaFactory simplePizzaFactory = new SimplePizzaFactory();
        PizzaStore pizzaStore = new PizzaStore(simplePizzaFactory);

        Pizza cheesePizza = pizzaStore.orderPizza("cheese");
        System.out.println(cheesePizza);

        System.out.println();
        Pizza veggiePizza = pizzaStore.orderPizza("veggie");
        System.out.println(veggiePizza);

    }
}
