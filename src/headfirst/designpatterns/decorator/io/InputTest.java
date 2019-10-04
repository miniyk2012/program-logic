package headfirst.designpatterns.decorator.io;

import java.io.*;

public class InputTest {
    public static void main(String[] args) throws IOException {
        System.out.println(new File(".").getAbsolutePath());
        InputStream in = null;
        int c;
        int off = 5, len = 20;

        try {
            in = new LowerCaseInputStream(
                    new BufferedInputStream(
                            new FileInputStream("src/headfirst/designpatterns/decorator/io/test.txt")));

            while ((c = in.read()) >= 0) {
                System.out.print((char) c);
            }
            System.out.println();
            byte[] tmp = new byte[50];
            int num = in.read(tmp, off, len);
            System.out.println(num);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                in.close();
            }
        }

        System.out.println();
        try {
            in = new LowerCaseInputStream(
                    new BufferedInputStream(
                            new FileInputStream("src/headfirst/designpatterns/decorator/io/test.txt")));
            byte[] tmp = new byte[50];
            int num = in.read(tmp, off, len);
            for (int i = off; i < off + len; i++)
                System.out.print((char) tmp[i]);
            System.out.println("\n" + num);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                in.close();
            }
        }
    }
}
