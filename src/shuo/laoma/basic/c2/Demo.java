package shuo.laoma.basic.c2;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

public class Demo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		byte b = 23;
		short s = 3333;
		int i = 9999;
		long l = 32323;
		
		long a = 3232343433L;
		
		double d = 333.33;
		
		float f = 333.33f;
		
		int[] arr = {1,2,3};
//		int[] arr = new int[]{1,2,3};
//		int[] arr = new int[3]; 
//		arr[0]=1; arr[1]=2; arr[2]=3;

		List<String> obj = Arrays.asList(new String[]{"老马","编程"});
		Class<?> cls = obj.getClass();
		for(Field ff : cls.getDeclaredFields()){
			ff.setAccessible(true);
			try {
				System.out.println(ff.getName()+" - "+ff.get(obj));
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}

	}

}
