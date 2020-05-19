package design.pattern.abstract_factory.factories;

import design.pattern.abstract_factory.buttons.Button;
import design.pattern.abstract_factory.buttons.MacOSButton;
import design.pattern.abstract_factory.checkboxes.Checkbox;
import design.pattern.abstract_factory.checkboxes.MacOSCheckbox;

public class MacOSFactory implements GUIFactory {
    @Override
    public Button createButton() {
        return new MacOSButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new MacOSCheckbox();
    }
}
