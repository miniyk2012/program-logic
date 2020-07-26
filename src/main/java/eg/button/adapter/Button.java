package eg.button.adapter;

public class Button {
    private ButtonServer buttonServer;
    private int token;

    public Button(int token, ButtonServer buttonServer) {
        this.token = token;
        this.buttonServer = buttonServer;
    }
    public void press() {
        this.buttonServer.buttonPress(token);
    }
}
