package headfirst.designpatterns.templatemethod.beverage;

public class Tea extends CaffeineBeverage {

    @Override
    void brew() {
        System.out.println("brew Tea");
    }

    @Override
    void addCondiments() {
        System.out.println("Adding Lemon");
    }
}
