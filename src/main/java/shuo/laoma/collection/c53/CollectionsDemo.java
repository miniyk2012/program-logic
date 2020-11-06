package shuo.laoma.collection.c53;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CollectionsDemo {
    public static void main(String[] args) {
        List<Integer> source = Arrays.asList(new Integer[]{
                35, 1, 24, 13, 12, 8, 24, 13, 7, 1
        });
        System.out.println(Collections.frequency(source, 1));
        Collections.sort(source);
        System.out.println(source);
        Collections.swap(source, 1, 3);
        System.out.println(source);
        Collections.reverse(source);
        System.out.println(source);
        Collections.shuffle(source);
        System.out.println(source);
        List<Integer> list = Arrays.asList(new Integer[]{
                8, 5, 3, 6, 2, 19, 21
        });
        Collections.rotate(list.subList(1, 5), 2);
        System.out.println(list);

        List<String> list2 = new ArrayList<>();
        list2.addAll(Arrays.asList(new String[]{"c","b","x"}));
        Collections.fill(list2, "a");
        System.out.println(list2);


        List<String> empty = Collections.emptyList();
        empty.get(0);
    }
}
