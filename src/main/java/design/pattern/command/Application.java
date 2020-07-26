package design.pattern.command;

import design.pattern.command.editor.Editor;

public class Application {
    public static void main(String[] args) {
        Editor editor = new Editor();
        editor.init();
    }
}
