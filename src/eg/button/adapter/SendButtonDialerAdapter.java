package eg.button.adapter;

public class SendButtonDialerAdapter implements ButtonServer {
    private Dialer dialer;
    public SendButtonDialerAdapter(Dialer dialer) {
        this.dialer = dialer;
    }
    @Override
    public void buttonPress(int token) {
        dialer.dial();
    }
}
