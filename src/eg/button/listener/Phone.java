package eg.button.listener;

public class Phone {
    public final static int SEND_BUTTON = -99;
    private Dialer dialer;
    private Ding ding;
    private Button[] digitButtons;
    private Button sendButton;

    public Phone() {
        dialer = new Dialer();
        ding = new Ding();
        digitButtons = new Button[10];
        ButtonListener digitButtonListener = new DigitButtonDailerAdapter(dialer);
        ButtonListener SendButtonListener = new SendButtonDialerAdapter(dialer);
        ButtonListener dingButtonListener = new DingButtonAdapter(ding);
        for (int i = 0; i < digitButtons.length; i++) {
            digitButtons[i] = new Button(i);
            digitButtons[i].addListener(digitButtonListener);
            digitButtons[i].addListener(dingButtonListener);
        }
        sendButton = new Button(SEND_BUTTON);
        sendButton.addListener(SendButtonListener);
        sendButton.addListener(dingButtonListener);
    }

    public static void main(String[] args) {
        Phone phone = new Phone();
        phone.digitButtons[9].press();
        phone.digitButtons[1].press();
        phone.digitButtons[6].press();
        phone.sendButton.press();
    }
}
