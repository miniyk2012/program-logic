package design.pattern.factory_method.factory;

import design.pattern.factory_method.buttons.Button;

/**
 * 工厂基类
 */
public abstract class Dialog {
    public void renderWindow() {
        // ... other code ...

        Button okButton = createButton();
        okButton.render();
    }

    /**
     * Subclasses will override this method in order to create specific button
     * objects.
     */
    public abstract Button createButton();
}
