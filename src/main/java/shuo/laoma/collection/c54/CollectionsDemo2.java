package shuo.laoma.collection.c54;

import java.util.*;

/**
 * 适配器
 */
public class CollectionsDemo2 {
    public static <T> List<T> asList(T... elements) {
        if (elements.length == 0) {
            return Collections.emptyList();
        }
        List<T> list = new ArrayList<>(elements.length);
        for (T e : elements) {
            list.add(e);
        }
        return list;
    }

    public static void main(String[] args) {
        List<String> emptyList = Collections.emptyList();
        try {
            emptyList.add("abc");
        } catch (UnsupportedOperationException e) {
            System.out.println("empty list不可变");
        }
        Map<String, Integer> emptyMap = Collections.emptyMap();
        try {
            emptyMap.put("abc", 120);
        } catch (UnsupportedOperationException e) {
            System.out.println("empty map不可变");
        }

        List<String> values1 = asList(new String[]{"a", "b", "c"});
        System.out.println(values1);

        // 我们将空容器方法看做是适配器，是因为它将null或"空"转换为了容器对象。
        List<Integer> values2 = asList(new Integer[]{});
        System.out.println(values2);

        // 单一对象方法, 可以将一个单独的对象转换为一个标准的容器接口对象
        Collection<String> coll = Collections.singleton("编程");
        System.out.println(coll);
        System.out.println("coll contains 编程?" + coll.contains("编程"));
        Set<String> set = Collections.singleton("编程");
        System.out.println(set);
        try {
            set.add("a");
        } catch (UnsupportedOperationException e) {
            System.out.println("singleton也是不可变的");
        }

        List<String> list = Collections.singletonList("老马");
        System.out.println(list);
        Map<String, String> map = Collections.singletonMap("老马", "编程");
        System.out.println(map);

        List<String> list2= new ArrayList<>();
        Collections.addAll(list2, "a", "b", "c", "d", "b");
        list2.removeAll(Collections.singleton("b")); // 小技巧: 删除所有的b, 而不是只有第一条
        System.out.println(list2);

        //将Map接口转换为Set接口
        Map<String, Boolean> map1 = new LinkedHashMap<>();
        Set<String> set1 = Collections.newSetFromMap(map1);
        set1.add("a");
        set1.add("2");
        set1.add("4");
        System.out.println(set1);
    }
}
