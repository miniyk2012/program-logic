package eg.button.adapter;

public class Phone {
    public final static int SEND_BUTTON = -99;
    private Dialer dialer;
    private Button[] digitButtons;
    private Button sendButton;

    public Phone() {
        dialer = new Dialer();
        digitButtons = new Button[10];
        DigitButtonDailerAdapter digitAdapter = new DigitButtonDailerAdapter(dialer);
        SendButtonDialerAdapter sendAdapter = new SendButtonDialerAdapter(dialer);
        for (int i = 0; i < digitButtons.length; i++) {
            digitButtons[i] = new Button(i, digitAdapter);
        }
        sendButton = new Button(SEND_BUTTON, sendAdapter);
    }

    public static void main(String[] args) {
        Phone phone = new Phone();
        phone.digitButtons[9].press();
        phone.digitButtons[1].press();
        phone.digitButtons[6].press();
        phone.sendButton.press();
    }
}
