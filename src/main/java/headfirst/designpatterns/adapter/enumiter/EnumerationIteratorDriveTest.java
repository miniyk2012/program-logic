package headfirst.designpatterns.adapter.enumiter;

import java.util.*;

public class EnumerationIteratorDriveTest {
    public static void main(String[] args) {
        String[] l = new String[] {
             "1", "2", "3"
        };
        Vector<String> v = new Vector<>(Arrays.asList(l));
        Iterator<?> iterator = new EnumerationIterator(v.elements());
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
