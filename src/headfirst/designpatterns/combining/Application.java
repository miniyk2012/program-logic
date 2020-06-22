package headfirst.designpatterns.combining;

public class Application {
    public static void main(String[] args) {
        Application simulator = new Application();
        AbstractDuckFactory duckFactory = new CountingDuckFactory();
        simulator.simulate(duckFactory);
    }

    private void simulate(AbstractDuckFactory duckFactory) {
        System.out.println("\nDuck Simulator");

        Quackable redheadDuck = duckFactory.createRedheadDuck();
        Quackable duckCall = duckFactory.createDuckCall();
        Quackable rubberDuck = duckFactory.createRubberDuck();
        Quackable gooseDuck = new GooseAdapter(new Goose());
        Flock flockOfDucks = new Flock();
        flockOfDucks.add(redheadDuck);
        flockOfDucks.add(duckCall);
        flockOfDucks.add(rubberDuck);
        flockOfDucks.add(gooseDuck);

        Flock flockOfMallar = new Flock();
        Quackable mallardDuck1 = duckFactory.createMallardDuck();
        Quackable mallardDuck2 = duckFactory.createMallardDuck();
        Quackable mallardDuck3 = duckFactory.createMallardDuck();
        Quackable mallardDuck4 = duckFactory.createMallardDuck();
        flockOfMallar.add(mallardDuck1);
        flockOfMallar.add(mallardDuck2);
        flockOfMallar.add(mallardDuck3);
        flockOfMallar.add(mallardDuck4);
        flockOfDucks.add(flockOfMallar);

        Quackologist quackologist = new Quackologist();
        Woologist woologist = new Woologist();
        flockOfDucks.registerObserver(quackologist);
        flockOfDucks.registerObserver(woologist);
        simulate(flockOfDucks);

        System.out.println("The ducks quacked " +
                QuackCounter.getQuacks() + " times");
    }

    void simulate(Quackable duck) {
        duck.quack();
    }
}
