package headfirst.designpatterns.observer.simpleobservable;

import java.util.Observable;
import java.util.Observer;

public class SimpleObserver implements Observer {

    public SimpleObserver(Observable o) {
        o.addObserver(this);
    }
    @Override
    public void update(Observable o, Object arg) {
        int value = (Integer) arg;
        display(value);
    }

    public void display(int value) {
        System.out.println("Value: " + value);
    }
}
