package shuo.laoma.java8.c91;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AnonymousDemoYk {

	public static void main(String[] args) {
		//列出当前目录下的所有后缀为.txt的文件
		File f = new File("/Users/thomas_young/Documents/code/program-logic/src/shuo/laoma/java8/c91");
		File[] files = f.listFiles(new FilenameFilter(){
		    @Override
		    public boolean accept(File dir, String name) {
		        if(name.endsWith("java")){
		            return true;
		        }
		        return false;
		    }
		});
		System.out.println(Arrays.toString(files));
		
	    Arrays.sort(files, new Comparator<File>() {

	        @Override
	        public int compare(File f1, File f2) {
	            return f2.getName().compareTo(f1.getName());
	        }
	    });

		System.out.println(Arrays.toString(files));


	    ExecutorService executor = Executors.newFixedThreadPool(100);
	    executor.submit(new Runnable() {
	        @Override
	        public void run() {
	            System.out.println("hello world");
	        }
	    });
	}

}
