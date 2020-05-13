package design.pattern.command.commands;

import design.pattern.command.editor.Editor;

public abstract class Command {
    public Editor editor;
    private String backup;

    Command(Editor editor) {
        this.editor = editor;
    }

    public abstract boolean execute();

    public void undo() {
        editor.textField.setText(backup);
    }

    protected void backup() {
        backup = editor.textField.getText();
    }
}
