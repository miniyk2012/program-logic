package shuo.laoma.java8.c92;

import java.util.function.Supplier;

/**
 * Created by thomas_young on 6/8/2017.
 */
public class FibonacciSupplier implements Supplier<Long> {
    long a = 0;
    long b = 1;

    @Override
    public Long get() {
        long x = a + b;
        a = b;
        b = x;
        return a;
    }
}
