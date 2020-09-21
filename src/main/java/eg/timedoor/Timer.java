package eg.timedoor;

public class Timer {
    void register(int timeout, TimerClient client) {
        client.timeout();
    };
}
