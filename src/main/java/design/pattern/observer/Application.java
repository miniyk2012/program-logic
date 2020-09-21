package design.pattern.observer;

import design.pattern.observer.editor.Editor;
import design.pattern.observer.listeners.EmailNotificationListener;
import design.pattern.observer.listeners.EventListener;
import design.pattern.observer.listeners.LogOpenListener;

public class Application {
    public static void main(String[] args) {
        Editor editor = new Editor();
        EventListener emailListener = new EmailNotificationListener("admin@example.com");
        EventListener logListener = new LogOpenListener("./file.txt");
        editor.events.subscribe("open", emailListener);
        editor.events.subscribe("save", emailListener);
        editor.events.subscribe("open", logListener);

        try {
            editor.openFile("./test.txt");
            editor.saveFile();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
