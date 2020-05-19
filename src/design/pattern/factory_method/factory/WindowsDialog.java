package design.pattern.factory_method.factory;

import design.pattern.factory_method.buttons.Button;
import design.pattern.factory_method.buttons.WindowsButton;

public class WindowsDialog extends Dialog {
    @Override
    public Button createButton() {
        return new WindowsButton();
    }
}
