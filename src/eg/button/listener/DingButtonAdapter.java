package eg.button.listener;

public class DingButtonAdapter implements ButtonListener {
    private Ding ding;

    public DingButtonAdapter(Ding ding) {
        this.ding = ding;
    }

    @Override
    public void buttonPress(int token) {
        if (token <= 0) return;
        for (int i = 0; i < token; i++)
            ding.ding();
        System.out.println();
    }
}
