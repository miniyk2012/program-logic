package eg.button.adapter;

public class DigitButtonDailerAdapter implements ButtonServer {
    private Dialer dialer;
    public DigitButtonDailerAdapter(Dialer dialer) {
        this.dialer = dialer;
    }
    @Override
    public void buttonPress(int token) {
        dialer.enterDigit(token);
    }
}
