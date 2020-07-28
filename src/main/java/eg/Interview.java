package eg;

public class Interview {
    private static int START_BABY = 2;
    private static int RABIT_MAX_AGE = 10;
    private long differentAgeNums[] = new long[RABIT_MAX_AGE + 1];

    public void initRabits() {
        differentAgeNums[1] = 1;
    }

    public long calculateAllRabits(int theYear) {
        initRabits();
        if (theYear == 1) {
            return 1;
        }
        long sum = 0;
        for (int year = 2; year <= theYear; year++) {
            liveOneyear();
        }
        for (long num : differentAgeNums) {
            sum += num;
        }
        return sum;
    }

    private void liveOneyear() {
        int newRabitNum = 0;
        for (int j = START_BABY; j <= RABIT_MAX_AGE; j++) {
            newRabitNum += differentAgeNums[j];
        }
        for (int j = RABIT_MAX_AGE; j > 1; j--) {
            differentAgeNums[j] = differentAgeNums[j - 1];
        }
        differentAgeNums[1] = newRabitNum;
    }

    public static void main(String[] args) {
        int year = 20;
        Interview interview = new Interview();
        long count = interview.calculateAllRabits(year);
        System.out.println(count);
        System.out.println(test2(year));
    }

    public static long test2(int n) {
        if (n <= 0) {
            return 1;
        }
        if (n <= 2) {
            return 1;
        } else if (n < 11) {
            return test2(n - 1) + test2(n - 2);
        }
        else if(n == 11) {
            return test2(n - 1) + test2(n - 2) - 1;
        } else {
            return test2(n - 1) + test2(n - 2) - test2(n - 11);
        }
    }
}
