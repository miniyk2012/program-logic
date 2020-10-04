package shuo.laoma.collection.c39;

import java.util.*;

public class LinkListDemoMy {


	public static void reverse(){
		Deque<String> deque = new LinkedList<>(
		        Arrays.asList(new String[]{"a","b","c"}));
		Iterator<String> it = deque.descendingIterator();
		while(it.hasNext()){
		    System.out.print(it.next()+" ");
		}
	}
	public static void nullDemo() {
		Deque<String> deque = new LinkedList<>();
		deque.offer(null);
		deque.offer("a");
		deque.offer("b");
		while (!deque.isEmpty()) {
			System.out.print(deque.poll() + " ");
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		reverse();
		System.out.println();
		nullDemo();
	}

}
