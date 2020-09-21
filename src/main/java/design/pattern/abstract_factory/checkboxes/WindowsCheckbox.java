package design.pattern.abstract_factory.checkboxes;

public class WindowsCheckbox implements Checkbox {
    @Override
    public void click() {
        System.out.println("You have click WindowsCheckbox.");
    }
}
