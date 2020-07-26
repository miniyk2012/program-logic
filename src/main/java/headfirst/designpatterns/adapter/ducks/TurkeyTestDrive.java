package headfirst.designpatterns.adapter.ducks;

public class TurkeyTestDrive {
    public static void main(String[] args) {
        Duck duck = new MallardDuck();
        Turkey turkey = new DuckAdapter(duck);

        for(int i=0;i<10;i++) {
            System.out.println("turkey said");
            turkey.gobble();
            turkey.fly();
        }
    }
}
