package shuo.laoma.java8.c91;

import org.junit.Test;
import org.msgpack.core.annotations.VisibleForTesting;
import shuo.laoma.basic.c11.Array;
import java.io.File;
import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BasicLambdaYk {

	public static void main(String[] args) {
        File f = new File("/Users/thomas_young/Documents/code/program-logic/src/shuo/laoma/java8/c91");
//		File[] files = f.listFiles((File dir, String name) -> {
//		    if (name.endsWith(".txt")) {
//		        return true;
//		    }
//		    return false;
//		});
//		
//		File[] files = f.listFiles((File dir, String name) -> {
//		    return name.endsWith(".txt");
//		});
//		
//		File[] files = f.listFiles((File dir, String name) -> name.endsWith(".txt"));
		
		File[] files = f.listFiles((dir, name) -> name.endsWith(".java"));
        System.out.println(Arrays.toString(files));
		
		Arrays.sort(files);
        System.out.println(Arrays.toString(files));

		ExecutorService executor = Executors.newFixedThreadPool(100);
        executor.submit(() -> System.out.printf("hello "));
//        executor.submit(() -> System.out.printf("hello world "));
//        executor.submit(() -> System.out.printf("hello nihao "));
//        executor.submit(() -> System.out.printf("hello nice "));
//        executor.submit(() -> System.out.printf("hello yk "));

        File[] files2 = f.listFiles(path -> path.getName().endsWith("Yk.java"));
        System.out.println(Arrays.toString(files2));


	}

    @Test
    public void testLambda1() {
        String msg = "hello world";
        ExecutorService executor = Executors.newFixedThreadPool(100);
        executor.submit(()->System.out.println(msg));
    }


}
