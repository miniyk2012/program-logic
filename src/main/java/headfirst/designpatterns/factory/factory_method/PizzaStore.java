package headfirst.designpatterns.factory.factory_method;

public abstract class PizzaStore {
    /**
     * 这是工厂方法
     * @param type
     * @return
     */
    protected abstract Pizza createPizza(String type);
    public Pizza orderPizza(String type) {
        Pizza pizza = createPizza(type);

        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();

        return pizza;
    }
}
