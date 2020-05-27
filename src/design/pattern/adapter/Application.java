package design.pattern.adapter;

import design.pattern.adapter.adapters.SquarePegAdapter;
import design.pattern.adapter.round.RoundHole;
import design.pattern.adapter.round.RoundPeg;
import design.pattern.adapter.square.SquarePeg;

public class Application {
    public static void main(String[] args) {
        RoundHole roundHole = new RoundHole(10);
        RoundPeg roundPeg1 = new RoundPeg(22);
        System.out.println(roundHole.fits(roundPeg1));

        RoundPeg roundPeg2 = new RoundPeg(10);
        System.out.println(roundHole.fits(roundPeg2));

        SquarePeg squarePeg1 = new SquarePeg(20);
        SquarePeg squarePeg2 = new SquarePeg(5);

        SquarePegAdapter sqPegAdapter1 = new SquarePegAdapter(squarePeg1);
        SquarePegAdapter sqPegAdapter2 = new SquarePegAdapter(squarePeg2);
        System.out.println(roundHole.fits(sqPegAdapter1));
        System.out.println(roundHole.fits(sqPegAdapter2));
    }
}
