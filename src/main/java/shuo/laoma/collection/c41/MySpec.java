package shuo.laoma.collection.c41;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class MySpec {
    String size;
    String color;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MySpec mySpec = (MySpec) o;
        return Objects.equals(size, mySpec.size) &&
                Objects.equals(color, mySpec.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(size, color);
    }

    public MySpec(String size, String color) {
        this.size = size;
        this.color = color;
    }

    @Override
    public String toString() {
        return "[size=" + size + ", color=" + color + "]";
    }

    public static void main(String[] args){
        Set<MySpec> set = new HashSet<>();
        set.add(new MySpec("M",null));
        set.add(new MySpec("M",null));

        System.out.println(set);
    }
}
