package headfirst.designpatterns.iterator.dinermerger;

public class MenuTestDrive {
    public static void main(String[] args) {
        DinerMenu dinerMenu = new DinerMenu();
        PancakeHouseMenu pancakeHouseMenu = new PancakeHouseMenu();

        Waitress waitress = new Waitress(dinerMenu, pancakeHouseMenu);

        System.out.println("All Menu:");
        waitress.printMenu();

        System.out.println();
        System.out.println("Vegetarian Menu:");
        waitress.printVegetarianMenu();
    }
}
