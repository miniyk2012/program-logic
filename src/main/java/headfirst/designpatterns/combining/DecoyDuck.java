package headfirst.designpatterns.combining;

public class DecoyDuck implements Quackable {
    private Observable observable;

    public DecoyDuck() {
        observable = new Observable(this);
    }

    @Override
    public void quack() {
        System.out.println("<< Silence >>");
        notifyObservers();
    }

    @Override
    public void registerObserver(Observer observer) {
        observable.registerObserver(observer);
    }

    @Override
    public void notifyObservers() {
        observable.notifyObservers();
    }

    public String toString() {
        return "Decoy Duck";
    }
}
