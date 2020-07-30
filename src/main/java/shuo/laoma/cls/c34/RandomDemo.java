package shuo.laoma.cls.c34;

import java.util.Arrays;
import java.util.Random;

public class RandomDemo {
    private void randomBytes() {
        Random rnd = new Random();
        byte[] a = new  byte[10];
        for (int i=0; i<5; i++) {
            rnd.nextBytes(a);
            System.out.println(Arrays.toString(a));
        }
    }

    private void seed() {
        Random rnd = new Random(20160824);
        for (int i=0; i<5; i++) {
            System.out.print(rnd.nextInt(100) + " ");
        }
    }


    public static void main(String[] args) {
        RandomDemo randomDemo = new RandomDemo();
        randomDemo.randomBytes();
        randomDemo.seed();
    }
}
