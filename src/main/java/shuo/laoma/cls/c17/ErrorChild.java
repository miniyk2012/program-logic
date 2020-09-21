package shuo.laoma.cls.c17;

/**
 * Created by thomas_young on 10/6/2018.
 */
public class ErrorChild extends ErrorBase {

    int a;
    public ErrorChild(String member) {
        super(member);
    }

    @Override
    public void test() {
        System.out.println(a);
    }

    public static void main(String[] args) {
        ErrorChild child = new ErrorChild("lala");
    }


}
