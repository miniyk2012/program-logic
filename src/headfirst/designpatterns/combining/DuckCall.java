package headfirst.designpatterns.combining;

public class DuckCall implements Quackable {
    @Override
    public void quack() {
        System.out.println("Kwak");
    }
}
