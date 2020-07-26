package headfirst.designpatterns.adapter.ducks;


public class DuckTestDrive {
    public static void main(String[] args) {
        Turkey turkey = new WildTurkey();
        Duck duck = new TurkeyAdapter(turkey);

        duck.fly();
        duck.quack();
    }
}
