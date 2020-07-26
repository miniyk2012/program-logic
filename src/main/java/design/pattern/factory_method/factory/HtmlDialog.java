package design.pattern.factory_method.factory;

import design.pattern.factory_method.buttons.Button;
import design.pattern.factory_method.buttons.HtmlButton;

public class HtmlDialog extends Dialog {
    @Override
    public Button createButton() {
        return new HtmlButton();
    }
}
