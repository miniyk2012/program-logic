package shuo.laoma.collection.c50;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class MyEnumMapDemo {
    public static Map<Size, Integer> countBySize(List<Clothes> clothes) {
        Map<Size, Integer> ret = new EnumMap<>(Size.class);
        for (Clothes cloth : clothes) {
//            System.out.println(ret.size());
            Size size = cloth.getSize();
            Integer count = ret.get(size);
            if (count != null) {
                ret.put(size, count + 1);
            } else {
                ret.put(size, 1);
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        List<Clothes> clothes = Arrays.asList(new Clothes[]{
                new Clothes("C001", Size.SMALL),
                new Clothes("C002", Size.LARGE),
                new Clothes("C003", Size.LARGE),
                new Clothes("C004", Size.MEDIUM),
                new Clothes("C005", Size.SMALL),
                new Clothes("C006", Size.SMALL),
        });
        // EnumMap是保证顺序的，输出是按照键在枚举中的顺序的。
        System.out.println(countBySize(clothes));
        Map<Size, Integer> ret = countBySize(clothes);
        System.out.println(ret.get(Size.SUPERLARGE));
        System.out.println(ret.containsKey(Size.SUPERLARGE));
        ret.put(Size.SUPERLARGE, null);
        System.out.println(ret.get(Size.SUPERLARGE));  // value可以为null
        System.out.println(ret.containsKey(Size.SUPERLARGE));

    }
}
