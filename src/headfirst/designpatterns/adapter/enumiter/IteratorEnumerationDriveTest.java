package headfirst.designpatterns.adapter.enumiter;

import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;

public class IteratorEnumerationDriveTest {
    public static void main(String[] args) {
        String[] a = new String[]{
                "1", "2", "3"
        };
        List<String> l = Arrays.asList(a);
        Enumeration<?> enumeration = new IteratorEnumeration(l.iterator());
        while (enumeration.hasMoreElements()) {
            System.out.println(enumeration.nextElement());
        }
    }
}
