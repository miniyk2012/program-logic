package headfirst.designpatterns.templatemethod.beverage;

public class BeverageTestDrive {
    public static void main(String[] args) {
        CaffeineBeverage coffee = new Coffee();
        CaffeineBeverage tea = new Tea();

        System.out.println("\nMaking tea...");
        coffee.prepareRecipe();

        System.out.println("\nMaking coffee...");
        tea.prepareRecipe();

        CaffeineBeverageWithHook coffeeWithHook = new CoffeeWithHook();
        System.out.println("\nMaking coffee with hook...");
        coffeeWithHook.prepareRecipe();

        CaffeineBeverageWithHook teaWithHook = new TeaWithHook();
        System.out.println("\nMaking tea with hook...");
        teaWithHook.prepareRecipe();


    }
}
