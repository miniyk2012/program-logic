package headfirst.designpatterns.combining;

public interface AbstractDuckFactory {
    Quackable createMallardDuck();
    Quackable createRedheadDuck();
    Quackable createDuckCall();
    Quackable createRubberDuck();
    Quackable createDecoyDuck();
}
