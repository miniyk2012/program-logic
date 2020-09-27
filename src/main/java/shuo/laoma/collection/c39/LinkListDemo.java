package shuo.laoma.collection.c39;

import java.util.*;

public class LinkListDemo {

	public static void stack(){
		Deque<String> stack = new LinkedList<>();

		stack.push("a");
		stack.push("b");
		stack.push("c");

		while(stack.peek()!=null){
		    System.out.println(stack.pop());
		}
	}

	public static void queue() {
		Queue<String> queue = new LinkedList<>();

		queue.offer("a");
		queue.offer("b");
		queue.offer("c");
		while(queue.peek()!=null){
			System.out.println(queue.poll());
		}
	}
	
	public static void reverse(){
		Deque<String> deque = new LinkedList<>(
		        Arrays.asList(new String[]{"a","b","c"}));
		Iterator<String> it = deque.descendingIterator();
		while(it.hasNext()){
		    System.out.print(it.next()+" ");
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<String> list = new LinkedList<>(Arrays.asList(new String[]{"a","b","c"}));
		queue();
		System.out.println();
		stack();
		System.out.println();
		reverse();
	}

}
