package shuo.laoma.cls.c31;

import java.util.Arrays;
import java.util.Collections;
import org.apache.commons.lang3.ArrayUtils;


public class ArrayDemo {
    public static void main(String[] args) {
        String[] arr = {"hello", "world", "Break", "abc"};
        Arrays.sort(arr, String.CASE_INSENSITIVE_ORDER);
        System.out.println(Arrays.toString(arr));
        Arrays.sort(arr, (o1, o2) -> o2.compareToIgnoreCase(o1));
        System.out.println(Arrays.toString(arr));
        Arrays.sort(arr, Collections.reverseOrder(String.CASE_INSENSITIVE_ORDER));
        System.out.println(Arrays.toString(arr));

        deepOp();

        // apache.commons.lang3提供了大量好用的工具类
        int[] ret = ArrayUtils.addAll(new int[]{1, 2}, new int[]{3, 4});
        System.out.println(Arrays.toString(ret));
    }

    public static void deepOp() {
        int[][] arr = new int[][]{
                {0, 1},
                {2, 3, 4},
        };
        System.out.println(Arrays.deepToString(arr));
    }
}
