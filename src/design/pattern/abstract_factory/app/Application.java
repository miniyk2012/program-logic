package design.pattern.abstract_factory.app;

import design.pattern.abstract_factory.buttons.Button;
import design.pattern.abstract_factory.checkboxes.Checkbox;
import design.pattern.abstract_factory.factories.GUIFactory;

public class Application {
    private Button button;
    private Checkbox checkbox;


    public Application(GUIFactory factory) {
        this.button = factory.createButton();
        this.checkbox = factory.createCheckbox();
    }

    public void render() {
        button.paint();
        checkbox.click();
    }
}
