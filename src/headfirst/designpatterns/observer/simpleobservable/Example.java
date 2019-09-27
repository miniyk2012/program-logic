package headfirst.designpatterns.observer.simpleobservable;

public class Example {
    public static void main(String[] args) {
        SimpleObservable simpleObservable = new SimpleObservable();

        SimpleObserver simpleObserver = new SimpleObserver(simpleObservable);

        simpleObservable.setValue(80);
        simpleObservable.setValue(70);

        simpleObservable.deleteObserver(simpleObserver);
        simpleObservable.setValue(60);

    }
}
