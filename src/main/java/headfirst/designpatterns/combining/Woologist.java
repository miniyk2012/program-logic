package headfirst.designpatterns.combining;

public class Woologist implements Observer {
    @Override
    public void update(QuackObservable duck) {
        System.out.println("Woologist: " + "Woo");
    }

    @Override
    public String toString() {
        return "Woologist";
    }

}
