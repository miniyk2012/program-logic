package headfirst.designpatterns.combining;

public class DecoyDuck implements Quackable {
    @Override
    public void quack() {
        System.out.println("<< Silence >>");
    }
}
