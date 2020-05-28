package eg.button.listener;

public class SendButtonDialerAdapter implements ButtonListener {
    private Dialer dialer;
    public SendButtonDialerAdapter(Dialer dialer) {
        this.dialer = dialer;
    }
    @Override
    public void buttonPress(int token) {
        dialer.dial();
    }
}
