package design.pattern.abstract_factory.buttons;

public class WindowsButton implements Button {
    @Override
    public void paint() {
        System.out.println("You have paint WindowsButton.");
    }
}
