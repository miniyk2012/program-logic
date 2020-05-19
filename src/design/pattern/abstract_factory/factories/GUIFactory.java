package design.pattern.abstract_factory.factories;

import design.pattern.abstract_factory.buttons.Button;
import design.pattern.abstract_factory.checkboxes.Checkbox;

/**
 * 抽象工厂
 */
public interface GUIFactory {
    Button createButton();
    Checkbox createCheckbox();
}
