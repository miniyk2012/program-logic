package design.pattern.abstract_factory.factories;

import design.pattern.abstract_factory.buttons.Button;
import design.pattern.abstract_factory.buttons.WindowsButton;
import design.pattern.abstract_factory.checkboxes.Checkbox;
import design.pattern.abstract_factory.checkboxes.WindowsCheckbox;

public class WindowsFactory implements GUIFactory {
    @Override
    public Button createButton() {
        return new WindowsButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new WindowsCheckbox();
    }
}
