package eg.button.listener;

import java.util.ArrayList;
import java.util.List;

public class Button {
    private List<ButtonListener> listeners;
    private int token;

    public Button(int token) {
        this.token = token;
        this.listeners = new ArrayList<>();
    }

    public void addListener(ButtonListener listener) {
        listeners.add(listener);
    }

    public void press() {
        for (ButtonListener listener : listeners) {
            listener.buttonPress(token);
        }
    }
}
