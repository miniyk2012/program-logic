package shuo.laoma.basic.c4;


public class Demo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int a = 25; 
		System.out.println(Integer.toBinaryString(a)); //二进制
		System.out.println(Integer.toHexString(a));  //十六进制
		System.out.println(Long.toBinaryString(a)); //二进制
		System.out.println(Long.toHexString(a));  //十六进制
        Double b = 15.33d;
        System.out.println(Double.doubleToLongBits(b));
        System.out.println(Double.longBitsToDouble(Double.doubleToLongBits(b)));
        System.out.println(Long.toBinaryString(Double.doubleToLongBits(b)));  // 浮点值的表示形式
        char x = '\u9a6c';
        System.out.println(x);
        System.out.println(Integer.toHexString(x));


    }

}
