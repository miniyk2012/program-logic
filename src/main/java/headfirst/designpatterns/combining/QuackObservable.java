package headfirst.designpatterns.combining;

public interface QuackObservable {
    void registerObserver(Observer observer);

    void notifyObservers();
}
