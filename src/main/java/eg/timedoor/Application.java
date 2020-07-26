package eg.timedoor;

public class Application {
    private static void useAdapter() {
        new TimeDoorAdapter();
    }

    private static void useInterface() {
        new TimedDoor();
    }

    public static void main(String[] args) {
        useAdapter();
        useInterface();
    }
}
