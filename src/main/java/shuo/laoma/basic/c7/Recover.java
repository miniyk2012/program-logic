package shuo.laoma.basic.c7;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class Recover {

	public static void recover(String str) 
	        throws UnsupportedEncodingException{
	    String[] charsets = new String[]{"windows-1252","GB18030","Big5","UTF-8"};
	    int length = 5;
	    for(int i=0;i<charsets.length;i++){
	        for(int j=0;j<charsets.length;j++){
	            if(i!=j){
	                String s = new String(str.getBytes(charsets[i]),charsets[j]);
	                System.out.println("---- 原来编码(A)假设是: "+charsets[j]+", 被错误解读为了(B): "+charsets[i]);
	                System.out.println(s);
	                System.out.println();    
	            }
	        }
	    }
	} 
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String str = "ÀÏÂí";
//		String str = "脌脧脗铆";

		try {
			recover(str);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

//		Math
//      Arrays
        char c = '\u0000';
        System.out.println(c);
    }

}
