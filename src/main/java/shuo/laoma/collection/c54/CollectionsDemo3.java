package shuo.laoma.collection.c54;

import java.util.*;

/**
 * 装饰器
 */
public class CollectionsDemo3 {

    // 写安全
    public static void safeWrite() {
        List<String> list = new ArrayList<>(Arrays.asList(
                new String[]{"a", "b", "c", "d"}));
        try {
            thirdMethod(Collections.unmodifiableCollection(list));
        } catch (UnsupportedOperationException e) {
            System.out.println("写安全");
        }
        System.out.println(list);
    }

    // 类型安全
    public static void safeType() {
        List list = new ArrayList<Integer>();
        list = Collections.checkedList(list, Integer.class);
        try {
            list.add("hello");
        } catch (ClassCastException e) {
            System.out.println("类型安全");
        }
        list.add(12);
        System.out.println(list);
    }

    // 线程安全, 是通过加锁实现的, 不是最优的
    public static void safeThread() {
        List<String> list = new ArrayList<>();
        list = Collections.synchronizedList(list);
        list.add("hellp");
        System.out.println(list);
    }

    public static void thirdMethod(Collection<String> c){
        c.add("bad");
    }

    public static void main(String[] args) {
        safeWrite();
        safeType();
        safeThread();
    }
}
