package shuo.laoma.cls.c31;

import java.util.Arrays;
import java.util.Collections;


public class ArrayDemo {
    public static void main(String[] args) {
        String[] arr = {"hello","world", "Break","abc"};
        Arrays.sort(arr, String.CASE_INSENSITIVE_ORDER);
        System.out.println(Arrays.toString(arr));
        Arrays.sort(arr, (o1, o2) -> o2.compareToIgnoreCase(o1));
        System.out.println(Arrays.toString(arr));
        Arrays.sort(arr, Collections.reverseOrder(String.CASE_INSENSITIVE_ORDER));
        System.out.println(Arrays.toString(arr));
    }
}
