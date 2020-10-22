package shuo.laoma.collection.c47;

import org.jetbrains.annotations.NotNull;

public class Base implements Comparable<Base> {
    protected int score;
    public Base(int score) {
        this.score = score;
    }
    @Override
    public int compareTo(@NotNull Base o) {
        return score - o.score;
    }

    @Override
    public String toString() {
        return "B: " + score;
    }
}
