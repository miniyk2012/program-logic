package shuo.laoma.collection.c44;

import java.util.Arrays;
import java.util.NavigableSet;
import java.util.SortedSet;
import java.util.TreeSet;

public class TreeSetDemoMy {
    public static void main(String[] args) {
        basic();
        compare();
        System.out.println("navigate:");
        navigate();
    }

    public static void basic() {
        SortedSet<String> set = new TreeSet<>();
        set.addAll(Arrays.asList(new String[]{
                "c", "a", "b", "d", "f", "a",
        }));
        System.out.println(set);

        // headSet/tailSet/subSet都返回一个视图
        // 对返回视图的操作会直接影响原Set
        System.out.println(set.first()); //a
        System.out.println(set.last()); //f
        System.out.println(set.headSet("b"));//[a]
        System.out.println(set.tailSet("d"));//[d, f]
        System.out.println(set.subSet("b", "e")); //[b, c, d]
        set.subSet("b", "e").clear(); //会从原set中删除
        System.out.println(set); //[a, f]
    }

    public static void compare() {
        SortedSet<String> words = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);
        words.addAll(Arrays.asList(new String[]{
                "tree", "map", "hash", "Map",
        }));
        System.out.println(words);
        System.out.println(words.comparator());

        words = new TreeSet<>();
        words.addAll(Arrays.asList(new String[]{
                "tree", "map", "hash", "Map",
        }));
        System.out.println(words);
        System.out.println(words.comparator());
    }

    public static void navigate() {
        NavigableSet<String> set = new TreeSet<String>();
        set.addAll(Arrays.asList(new String[]{
                "c", "a", "b", "d","f"
        }));
        System.out.println(set);
        System.out.println(set.floor("a")); //a
        System.out.println(set.lower("b")); //a
        System.out.println(set.ceiling("d"));//d
        System.out.println(set.higher("c"));//d
        System.out.println(set.subSet("b", true,"d", true)); //[b, c, d]
        System.out.println(set.pollFirst()); //a
        System.out.println(set.pollLast()); //f
        System.out.println(set.descendingSet()); //[d, c, b]
    }
}
