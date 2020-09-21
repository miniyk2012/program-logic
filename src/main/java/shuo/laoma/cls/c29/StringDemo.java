package shuo.laoma.cls.c29;

import java.nio.charset.Charset;

public class StringDemo {
    public static void main(String[] args) {
        String a = "10";
        String b = new String("10");
        System.out.println(a.toCharArray()[0]);
        System.out.println(Charset.defaultCharset().name());
        System.out.println(a == b);
        System.out.println(a == "10");
        StringBuilder c = new StringBuilder(10);
        c.append("123");
        System.out.println(c.length());
    }
}
