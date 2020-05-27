package design.pattern.adapter.adapters;

import design.pattern.adapter.round.RoundPeg;
import design.pattern.adapter.square.SquarePeg;

public class SquarePegAdapter extends RoundPeg {
    private SquarePeg adptee;

    public SquarePegAdapter(SquarePeg adptee) {
        this.adptee = adptee;
    }

    @Override
    public double getRadius() {
        double result;
        result = (Math.sqrt(Math.pow((adptee.getWidth() / 2), 2) * 2));
        return result;
    }
}
