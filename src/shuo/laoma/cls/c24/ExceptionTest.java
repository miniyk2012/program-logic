package shuo.laoma.cls.c24;

public class ExceptionTest {
  
    public static void main(String[] args) {
        if(args.length<1){
            System.out.println(Integer.valueOf(100).floatValue());
            System.out.println(Double.valueOf(100).longValue());
            Character a = Character.valueOf('熙');
            System.out.println(Character.isHighSurrogate('熙'));
            System.out.println(Character.toCodePoint((char)0xD891, (char)0xDC10));
            System.out.println(Character.toChars(214032));
            Integer.reverse(0x12345678);
            System.out.println("请输入数字");
            return;
        }
        try{
            int num = Integer.parseInt(args[0]);
            System.out.println(num);    
        }catch(NumberFormatException e){
            System.err.println("参数"+args[0]
                    +"不是有效的数字，请输入数字");
        }
    }
}
