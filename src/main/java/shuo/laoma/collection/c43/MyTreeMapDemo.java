package shuo.laoma.collection.c43;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

public class MyTreeMapDemo {
    public static void main(String[] args) {
        caseInsensitive();
        System.out.println();
        reverse();
        System.out.println();
        sameKey();
        System.out.println();
        date();
        System.out.println();
        navigate();
        System.out.println(String.format("ayngkai", null));

    }

    public static void caseInsensitive() {
        Map<String, String> map  = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
        map.put("a", "abstract");
        map.put("c", "call");
        map.put("b", "basic");
        map.put("T", "tree");

        for (Map.Entry<String, String> entry: map.entrySet()) {
            System.out.println(entry.getKey() + "=" + entry.getValue());
        }
    }
    public static void reverse() {
        Map<String, String> map  = new TreeMap<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });
        map.put("a", "abstract");
        map.put("c", "call");
        map.put("b", "basic");
        map.put("T", "tree");

        for (Map.Entry<String, String> entry: map.entrySet()) {
            System.out.println(entry.getKey() + "=" + entry.getValue());
        }
    }
    public static void sameKey() {
        Map<String, String> map  = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
        map.put("t", "abstract");
        map.put("T", "tree");
        // 看上去有两个不同的键"T"和"t"，但因为比较器忽略大小写，所以只会有一个
        for (Map.Entry<String, String> entry: map.entrySet()) {
            System.out.println(entry.getKey() + "=" + entry.getValue());
        }
    }
    public static void date() {
        Map<String, Integer> map  = new TreeMap<>(new Comparator<String>() {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            @Override
            public int compare(String o1, String o2) {
                try {
                    return sdf.parse(o1).compareTo(sdf.parse(o2));
                } catch (ParseException e) {
                    e.printStackTrace();
                    return 0;
                }
            }
        });
        map.put("2016-7-3", 100);
        map.put("2016-7-10", 120);
        map.put("2016-8-1", 90);

        for(Map.Entry<String,Integer> kv : map.entrySet()){
            System.out.println(kv.getKey()+","+kv.getValue());
        }


    }

    public static void navigate() {
        NavigableMap<String, String> map  = new TreeMap<>();
        map.put("a", "abstract");
        map.put("f", "final");
        map.put("c", "call");

        //输出：a=abstract
        System.out.println(map.firstEntry());
        //输出：f=final
        System.out.println(map.lastEntry());
        //输出：c=call
        System.out.println(map.floorEntry("d"));
        //输出：f=final
        System.out.println(map.ceilingEntry("d"));
        System.out.println(map.descendingMap()
                .subMap("d", false, "a", true));

    }
}
