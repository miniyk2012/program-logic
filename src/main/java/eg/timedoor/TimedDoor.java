package eg.timedoor;

public class TimedDoor extends Door implements TimerClient {
    private Timer timer;
    public TimedDoor() {
        timer = new Timer();
        timer.register(10, this);
    }
    @Override
    public void timeout() {
        if (isDoorOpen())
            lock();
    }
}
