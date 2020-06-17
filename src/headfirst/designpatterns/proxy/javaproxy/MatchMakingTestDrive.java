package headfirst.designpatterns.proxy.javaproxy;

import java.lang.reflect.Proxy;
import java.lang.reflect.UndeclaredThrowableException;
import java.util.HashMap;

public class MatchMakingTestDrive {

    HashMap<String, PersonBean> datingDB = new HashMap<String, PersonBean>();

    public static void main(String[] args) {

        MatchMakingTestDrive test = new MatchMakingTestDrive();
        test.drive();
    }

    private PersonBean getOwnerProxy(PersonBean person) {
        return (PersonBean) Proxy.newProxyInstance(person.getClass().getClassLoader(),
                person.getClass().getInterfaces(),
                new OwnerInvocationHandler(person));
    }

    private PersonBean getNonOwnerProxy(PersonBean person) {
        return (PersonBean) Proxy.newProxyInstance(person.getClass().getClassLoader(),
                person.getClass().getInterfaces(),
                new NonOwnerInvocationHandler(person));
    }

    private void drive() {
        PersonBeanImpl person = new PersonBeanImpl();
        getOwnerProxy(person).setGender("x");
        System.out.println(getOwnerProxy(person).getGender());

        System.out.println(getNonOwnerProxy(person).getGender());
        try {
            getNonOwnerProxy(person).setGender("y");
        } catch (RuntimeException e) {
            System.out.println(e);
        }
    }
}
