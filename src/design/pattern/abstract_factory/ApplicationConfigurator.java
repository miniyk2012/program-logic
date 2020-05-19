package design.pattern.abstract_factory;

import design.pattern.abstract_factory.app.Application;
import design.pattern.abstract_factory.factories.GUIFactory;
import design.pattern.abstract_factory.factories.MacOSFactory;
import design.pattern.abstract_factory.factories.WindowsFactory;

public class ApplicationConfigurator {

    public static void main(String[] args) {
        Application app = configureApplication();
        app.render();
    }

    private static Application configureApplication() {
        Application app;
        GUIFactory factory;
        String osName = System.getProperty("os.name").toLowerCase();
        if (osName.contains("mac")) {
            factory = new MacOSFactory();
            app = new Application(factory);
        } else {
            factory = new WindowsFactory();
            app = new Application(factory);
        }
        return app;
    }
}
