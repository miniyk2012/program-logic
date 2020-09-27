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
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		reverse();
	}

}
