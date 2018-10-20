package tp1;

import java.util.Random;

public class TestRandom {

	private Random rand = new Random(2);
	
	
	
	public void generateNumbers(int x) {
		
		for(int i = 0; i < x; i++)
			System.out.println( rand.nextInt(100) );
	}
	
	public static void main(String[] args) {
		TestRandom test = new TestRandom();
		
		test.generateNumbers(100);
	}
}
