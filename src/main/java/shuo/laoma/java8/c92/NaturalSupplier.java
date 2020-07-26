package shuo.laoma.java8.c92;

import java.util.function.Supplier;

/**
 * Created by thomas_young on 6/8/2017.
 */
public class NaturalSupplier implements Supplier<Long> {
    long value = 0;
    @Override
    public Long get() {
        this.value = this.value + 1;
        return this.value;
    }
}
