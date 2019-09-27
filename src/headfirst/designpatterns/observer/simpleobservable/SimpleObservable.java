package headfirst.designpatterns.observer.simpleobservable;

import java.util.Observable;

public class SimpleObservable extends Observable {
    private int value;

    public void setValue(int value) {
        this.value = value;
        setChanged();
        notifyObservers(value);
    }


}
