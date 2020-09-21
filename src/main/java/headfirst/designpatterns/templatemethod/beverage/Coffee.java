package headfirst.designpatterns.templatemethod.beverage;

public class Coffee extends CaffeineBeverage {
    @Override
    void brew() {
        System.out.println("brew coffee");
    }

    @Override
    void addCondiments() {
        System.out.println("Adding Sugar and Milk");
    }
}
