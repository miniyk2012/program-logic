package eg.button.listener;

public class DigitButtonDailerAdapter implements ButtonListener {
    private Dialer dialer;
    public DigitButtonDailerAdapter(Dialer dialer) {
        this.dialer = dialer;
    }
    @Override
    public void buttonPress(int token) {
        dialer.enterDigit(token);
    }
}
