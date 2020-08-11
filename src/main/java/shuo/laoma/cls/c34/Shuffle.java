package shuo.laoma.cls.c34;

import java.util.Arrays;
import java.util.Random;

public class Shuffle {
    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void shuffle(int[] arr) {
        Random rnd = new Random();
        for (int i = arr.length; i >= 1; i--) {
            swap(arr, i - 1, rnd.nextInt(i));
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[] {1,2,3,4,5,6,7,8,9,0};
        shuffle(arr);
        System.out.println(Arrays.toString(arr));

        char[] b = new char[10];
        char c = 0;
        System.out.println(Arrays.toString(b));
        System.out.println(c);
    }

}
