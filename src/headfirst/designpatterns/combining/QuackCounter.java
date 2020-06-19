package headfirst.designpatterns.combining;

public class QuackCounter implements Quackable {
    private Quackable duck;
    public static int numberOfQuacks;

    public QuackCounter(Quackable duck) {
        this.duck = duck;
    }
    @Override
    public void quack() {
        duck.quack();
        numberOfQuacks++;
    }
    public static int getQuacks() {
        return numberOfQuacks;
    }
}
