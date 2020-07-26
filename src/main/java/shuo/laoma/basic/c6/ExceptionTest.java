package shuo.laoma.basic.c6;

public class ExceptionTest {
    public static void main(String[] args) {
        try {
            number(args);
        } catch (NumberFormatException e) {
            System.out.println("参数" + args[0] + "不是有效数字");
        }
    }

    public static void number(String[] args) {
        if (args.length < 1) {
            System.out.println("请输入数字");
            return;
        }
        System.out.println(Integer.parseInt(args[0]));
    }
}
