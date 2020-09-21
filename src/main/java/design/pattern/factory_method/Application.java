package design.pattern.factory_method;

import design.pattern.factory_method.factory.Dialog;
import design.pattern.factory_method.factory.HtmlDialog;
import design.pattern.factory_method.factory.WindowsDialog;

public class Application {
    private static Dialog dialog;

    public static void main(String[] args) {
        configure();
        runBusinessLogic();
    }

    private static void configure() {
        if (System.getProperty("os.name").equals("Mac OS X")) {
            dialog = new WindowsDialog();
        } else {
            dialog = new HtmlDialog();
        }
    }

    /**
     * All of the client code should work with factories and products through
     * abstract interfaces. This way it does not care which factory it works
     * with and what kind of product it returns.
     */
    private static void runBusinessLogic() {
        dialog.renderWindow();
    }
}
