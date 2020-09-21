package headfirst.designpatterns.factory.factory_method;


public class PizzaTestDrive {
    public static void main(String[] args) {
        PizzaStore nyPizzaStore = new NYPizzaStore();

        Pizza cheesePizza = nyPizzaStore.orderPizza("cheese");
        System.out.println(cheesePizza);

        System.out.println();
        Pizza veggiePizza = nyPizzaStore.orderPizza("veggie");
        System.out.println(veggiePizza);

        System.out.println();
        PizzaStore chicagoPizzaStore = new ChicagoPizzaStore();
        Pizza pizza1 = chicagoPizzaStore.orderPizza("cheese");
        System.out.println(pizza1);

        System.out.println();
        Pizza pizza2 = chicagoPizzaStore.orderPizza("veggie");
        System.out.println(pizza2);

    }
}
