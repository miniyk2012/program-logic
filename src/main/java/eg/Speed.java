package eg;



/**
 * Created by thomas_young on 1/1/2019.
 */
public class Speed {
    static final long NUM = 111181111L;

    public boolean isPrime(long n) {
        long i = 2L;
        while (i < n) {
            if (n % i == 0) {
                return false;
            }
            i += 1;
        }
        return true;
    }


    public static void main(String[] args) {
        Speed s = new Speed();
        s.isPrime(NUM);
    }
}
