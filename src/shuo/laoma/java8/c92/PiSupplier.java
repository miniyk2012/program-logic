package shuo.laoma.java8.c92;

import java.util.function.Supplier;

/**
 * Created by thomas_young on 6/8/2017.
 * π/4 = 1 - 1/3 + 1/5 - 1/7 + 1/9 - ...
 */
public class PiSupplier implements Supplier<Double> {
    double sum = 0.0;
    double current = 1.0;
    boolean sign = true;

    @Override
    public Double get() {
        sum += (sign ? 4 : -4) / current;
        current += 2;
        sign = ! sign;
        return sum;
    }
}
