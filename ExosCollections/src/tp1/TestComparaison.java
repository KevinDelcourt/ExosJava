package tp1;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Random;

public class TestComparaison {
	
	private LinkedList<Point> list = new LinkedList<>();
	
	public TestComparaison(int nbPoint) {
		Random rand = new Random();
		
		for(int i = 0; i < nbPoint; i++)
			list.add( new Point( rand.nextInt(100), rand.nextInt(100) ) );
	}
	
	public void affichage() {
		System.out.println(list);
	}
	
	public void max() {
		System.out.println("Max :" + Collections.max(list) ) ;
	}
	
	public static void main(String[] args) {
		
		TestComparaison test = new TestComparaison(20);
		
		test.affichage();
		
		test.max();
	}
}
