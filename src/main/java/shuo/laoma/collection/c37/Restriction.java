package shuo.laoma.collection.c37;

import shuo.laoma.collection.c35.MyPair;
import shuo.laoma.collection.c36.MyDynamicArray;

import java.util.Date;

public class Restriction<E> {
    /**
     * 通过反射创建对象
     *
     * @param type
     * @param <T>
     * @return
     */
    public static <T> T create(Class<T> type) {
        try {
            return type.newInstance();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static class A {
        @Override
        public String toString() {
            return "A";
        }
    }

    public static void main(String[] args) {
        System.out.println(String.class);
        Class<?> cls = "hello".getClass();
        System.out.println(cls);
        MyPair<String, Integer> a = new MyPair<>("a", 10);
        MyPair<Integer, Integer> b = new MyPair<>(20, 10);
        System.out.println(MyPair.class == a.getClass());
        System.out.println(MyPair.class == b.getClass());
        System.out.println(a.getClass());
        System.out.println(a instanceof MyPair);
        System.out.println(a instanceof MyPair<?, ?>);

        System.out.println(create(A.class));
        System.out.println(create(StringBuilder.class));
        System.out.println(create(Date.class));

        System.out.println(MyPair.class);


        MyDynamicArray<? extends Number> aa = new MyDynamicArray<>();
        MyDynamicArray<Integer> bb = new MyDynamicArray<>();
        aa = bb;

//        Integer[] ints = new Integer[10];
//        Object[] objs = ints;
//        objs[0] = "hello";

        /**
         * 不能创建泛型数组, 只能下面这样不写数组的泛型, 只写元素的泛型
         */
        MyPair[] options = new MyPair[]{
                new MyPair<>("1元", 7),
                new MyPair<>("2元", 2),
                new MyPair<>("10元", 1)
        };
        System.out.println(options[0].getSecond());
        System.out.println(options[0].getFirst().getClass());
        System.out.println(options[0].getSecond().getClass());

        /**
         * 更推荐使用泛型容器
         */
        MyDynamicArray<MyPair<String, Integer>> options2 = new MyDynamicArray<>();
        options2.add(new MyPair<String,Integer>("1元",7));
        options2.add(new MyPair<String,Integer>("2元",2));
        options2.add(new MyPair<String,Integer>("10元",1));

        System.out.println(options2.toArray(MyPair.class)[0].getFirst());
        System.out.println(options2.toArray(MyPair.class)[0].getSecond());
        System.out.println(options2.toArray(MyPair.class).getClass());
    }
}
