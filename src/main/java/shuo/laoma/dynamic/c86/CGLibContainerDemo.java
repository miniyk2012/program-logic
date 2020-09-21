package shuo.laoma.dynamic.c86;


import java.lang.reflect.Method;

public class CGLibContainerDemo {
	
	public static void main(String[] args) {
		
		ServiceA a = CGLibContainer.getInstance(ServiceA.class);
//		a.callB();
//		a.sayHello();

		ServiceB b = CGLibContainer.getInstance(ServiceB.class);
        b.toString();
        System.out.println();
        for (Method method: b.getClass().getMethods()) {
            System.out.println(method);
        }

        System.out.println();
        b.throwException();
    }
}
