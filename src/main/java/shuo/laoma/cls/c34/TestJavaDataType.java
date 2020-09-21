package shuo.laoma.cls.c34;

public class TestJavaDataType {

    //字符型
    char flag;

    //布尔型
    boolean sex;

    /*数值型*/
    //整数类型
    byte number;

    short age;

    int workYears;

    long money;

    //浮点类型(小数类型)

    float score;

    double income;


    /**
     * @Description: (java中8个基本数据类型的默认值)
     * @param @param args  参数说明
     * 2018年4月9日下午6:59:10
     * jerry
     * @return void    返回类型
     */
    public static void main(String[] args) {
        TestJavaDataType testJavaDataType = new TestJavaDataType();
        testJavaDataType.printJavaDataDefaultValue();
    }

    //打印java中8个基本数据类型的默认值
    public void printJavaDataDefaultValue() {
        System.out.println("**********打印java中8个基本数据类型的默认值**********");
        System.out.println("char / flag = " + flag);
        System.out.println("boolean / sex = " + sex);
        System.out.println("byte / number = " + number);
        System.out.println("short / age = " + age);
        System.out.println("int / workYears = " + workYears);
        System.out.println("long / money = " + money);
        System.out.println("float / score = " + score);
        System.out.println("double / income = " + income);
        System.out.println("**********打印java中8个基本数据类型的默认值**********");
    }

}
