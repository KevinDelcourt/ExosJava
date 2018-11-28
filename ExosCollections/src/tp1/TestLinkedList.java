package tp1;

import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

public class TestLinkedList {
	
	private ConcurrentLinkedQueue<Integer> linkedlist = new ConcurrentLinkedQueue<Integer>();
	
	
	public TestLinkedList(int n) {
		for(int i = 1; i<=n; i++) 
			linkedlist.add(i);
	}
	
	public void affichage() {
		
		Iterator<Integer> iter = linkedlist.iterator();
		
		while(iter.hasNext()) {
			int i = iter.next();
			
			System.out.println(i);
		}
	}
	
	public void removeMultipleOf(int n) {
		if(n>1) {
			Iterator<Integer> iter = linkedlist.iterator();
			
			while(iter.hasNext()) {
				int x = iter.next();
				
				if( ( x % n == 0)&&( x > n ) ) 
					iter.remove();
						
			}
		}
	}
	
	public void toPrime() {
		Iterator<Integer> iter = linkedlist.iterator();
		
		while(iter.hasNext()) {
			int current = iter.next();
			
			if(current > 1) 
				removeMultipleOf(current);
		}
		
		
	}
	
	public static void main(String[] args) {
		
		TestLinkedList test = new TestLinkedList(100);
		
		test.toPrime();
		
		test.affichage();
		
	}
}


