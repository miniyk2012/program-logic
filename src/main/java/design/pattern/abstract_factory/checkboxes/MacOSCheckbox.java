package design.pattern.abstract_factory.checkboxes;

public class MacOSCheckbox implements Checkbox {
    @Override
    public void click() {
        System.out.println("You have click MacOSCheckbox.");
    }
}
