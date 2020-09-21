package shuo.laoma.cls.c17.protected_test.protected_test2;

import shuo.laoma.cls.c17.protected_test.BasePro;

/**
 * Created by thomas_young on 10/6/2018.
 */
public class ChildPro1 extends BasePro {

    public void test() {
        protect();  // 类内部才行
    }
    public static void main(String[] args) {
        ChildPro1 childPro1 = new ChildPro1();
        childPro1.test();

        // 不行哟
//        BasePro basePro = new BasePro();
//        basePro.protect()

    }
}
