package eg.timedoor;

public class TimeDoorAdapter implements TimerClient {
    private Door door;
    private Timer timer;

    public TimeDoorAdapter() {
        door = new Door();
        timer = new Timer();
        timer.register(10, this);
    }

    @Override
    public void timeout() {
        if (door.isDoorOpen())
            door.lock();
    }
}
