package shuo.laoma.collection.c45;

import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapDemo {
    public static void op(Map<String, Integer> map) {
        map.put("c", 100);
        map.put("d", 200);
        map.put("a", 500);
        map.get("c");
        map.put("d", 300);
    }

    public static void main(String[] args) {
        Map<String, Integer> accessMap = new LinkedHashMap<>(16, 0.75f, true);
        op(accessMap);
        for(Map.Entry<String, Integer> entry: accessMap.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
        System.out.println();
        Map<String, Integer>seqMap = new LinkedHashMap<>();
        op(seqMap);
        for(Map.Entry<String, Integer> entry: seqMap.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
