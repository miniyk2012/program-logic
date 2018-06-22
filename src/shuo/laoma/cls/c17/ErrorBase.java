package shuo.laoma.cls.c17;

/**
 * Created by thomas_young on 10/6/2018.
 */
public class ErrorBase {

    private String member;

    public ErrorBase(String member) {
        member = member;
        test();
    }

    public void test() {
        System.out.println(member);
    }
}
