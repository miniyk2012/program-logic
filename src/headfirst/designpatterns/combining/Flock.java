package headfirst.designpatterns.combining;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Flock implements Quackable {
    private List<Quackable> quackables;

    public Flock() {
        quackables = new ArrayList<>();
    }

    public void add(Quackable quackable) {
        quackables.add(quackable);
    }

    @Override
    public void quack() {
        Iterator<Quackable> iterator = quackables.iterator();
        while (iterator.hasNext()) {
            iterator.next().quack();
        }
    }
}
