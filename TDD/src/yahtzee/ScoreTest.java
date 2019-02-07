package yahtzee;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ScoreTest {

	private Category category;

	@After
	public void tearDown() throws Exception {
		category = null;
	}

	@Test
	public void testChance() {
		category = new Chance();
		
		assertEquals(5,category.score(new int[] {1,1,1,1,1}));
		
		assertEquals(16,category.score(new int[] {1,3,4,2,6}));
		
		assertEquals(20,category.score(new int[] {3,2,5,5,5}));
	}
	
	@Test
	public void testYahtzee() {
		category = new Yahtzee();
		
		assertEquals(50,category.score(new int[] {1,1,1,1,1}));
		
		assertEquals(50,category.score(new int[] {3,3,3,3,3}));
		
		assertEquals(0,category.score(new int[] {3,2,5,5,5}));
		
		assertEquals(0,category.score(new int[] {1,2,6,5,5}));
	}
	
	@Test
	public void testFullHouse() {
		category = new FullHouse();
		
		assertEquals(8,category.score(new int[] {1,2,1,2,2}));
		
		assertEquals(21,category.score(new int[] {3,6,3,6,3}));
		
		assertEquals(0,category.score(new int[] {3,5,5,5,5}));
		
		assertEquals(0,category.score(new int[] {1,2,6,5,5}));
	}
	
	@Test
	public void testSmallStraight() {
		category = new SmallStraight();
		
		assertEquals(15,category.score(new int[] {1,2,3,4,5}));
		
		assertEquals(15,category.score(new int[] {3,2,1,4,5}));

		assertEquals(0,category.score(new int[] {2,3,4,5,6}));
	}
	
	@Test
	public void testLargeStraight() {
		category = new LargeStraight();
		
		assertEquals(20,category.score(new int[] {2,3,4,5,6}));
		
		assertEquals(20,category.score(new int[] {3,2,6,4,5}));

		assertEquals(0,category.score(new int[] {1,3,4,5,6}));
	}
	
	@Test
	public void testOnes() {
		category = new Ones();
		
		assertEquals(0,category.score(new int[] {2,3,4,5,6}));
		
		assertEquals(2,category.score(new int[] {3,2,1,1,5}));

		assertEquals(4,category.score(new int[] {1,3,1,1,1}));
	}
	
	@Test
	public void testTwos() {
		category = new Twos();
		
		assertEquals(0,category.score(new int[] {1,3,4,5,6}));
		
		assertEquals(4,category.score(new int[] {3,2,1,2,5}));

		assertEquals(6,category.score(new int[] {1,3,2,2,2}));
	}
	
	@Test
	public void testThrees() {
		category = new Threes();
		
		assertEquals(0,category.score(new int[] {1,2,4,5,6}));
		
		assertEquals(3,category.score(new int[] {3,2,1,2,5}));

		assertEquals(15,category.score(new int[] {3,3,3,3,3}));
	}

	@Test
	public void testFours() {
		category = new Fours();
		
		assertEquals(0,category.score(new int[] {1,2,3,5,6}));
		
		assertEquals(4,category.score(new int[] {4,2,1,2,5}));

		assertEquals(16,category.score(new int[] {3,4,4,4,4}));
	}
	
	@Test
	public void testFives() {
		category = new Fives();
		
		assertEquals(0,category.score(new int[] {1,2,3,4,6}));
		
		assertEquals(5,category.score(new int[] {4,2,1,2,5}));

		assertEquals(10,category.score(new int[] {6,5,5,4,4}));
	}
	
	@Test
	public void testSixes() {
		category = new Sixes();
		
		assertEquals(0,category.score(new int[] {1,2,3,4,5}));
		
		assertEquals(6,category.score(new int[] {4,2,1,2,6}));

		assertEquals(18,category.score(new int[] {6,5,6,6,4}));
	}
	
	@Test
	public void testFourOfAKind() {
		category = new FourOfAKind();
		
		assertEquals(0,category.score(new int[] {1,2,2,2,5}));
		
		assertEquals(4,category.score(new int[] {4,1,1,1,1}));

		assertEquals(24,category.score(new int[] {6,6,6,6,4}));
		
		assertEquals(0,category.score(new int[] {4,4,4,4,4}));

	}
}
