package shuo.laoma.collection.c40;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class MyMapDemo {
    public static void clearView() {
        Map<Integer, Integer> aMap = new HashMap<>();
        aMap.put(1, 2);
        System.out.println(aMap.toString());
        aMap.values().clear();  // 视图, 对视图的修改会修改原map
        System.out.println(aMap.toString());
    }

    public static void randomMap() {
        Random rnd = new Random();
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int i = 0; i < 1000; i++) {
            int number = rnd.nextInt(4);
            Integer count = countMap.get(number);
            if (count == null) {
                countMap.put(number, 1);
            } else {
                countMap.put(number, count + 1);
            }
        }
        for (Map.Entry<Integer, Integer> kv : countMap.entrySet()) {
            System.out.println(kv.getKey() + ": " + kv.getValue());
        }
        System.out.println();
        Map<Integer, Object> numberMap = new HashMap<>(countMap);
        for (Map.Entry<Integer, Object> kv : numberMap.entrySet()) {
            System.out.println(kv.getKey() + ": " + ((Integer) kv.getValue() * (-1)));
        }
    }

    public static void main(String[] args) {
        clearView();
        randomMap();
    }
}
