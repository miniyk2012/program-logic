package shuo.laoma.dynamic.c86;

public class ServiceB {

	public void action(){
		System.out.println("I'm B");
	}

	public void throwException() {
		throw new RuntimeException("this is B's exception");
	}
}
