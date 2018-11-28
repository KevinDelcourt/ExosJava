import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class FizzBuzzTest {

	private FizzBuzz fizzBuzz;
	
	@Before
	public void setUp() throws Exception {
		fizzBuzz = new FizzBuzz();
	}
	
	@After
	public void tearDown() throws Exception {
		fizzBuzz = null;
	}


	@Test
	public void testCasUsuel() {
		
		assertEquals("1", fizzBuzz.getFizzOrBuzz(1));
		
	}
	
	@Test
	public void testFizz() {
			
		assertEquals("Fizz", fizzBuzz.getFizzOrBuzz(3));
		assertEquals("Fizz", fizzBuzz.getFizzOrBuzz(6));
		assertEquals("Fizz", fizzBuzz.getFizzOrBuzz(18));

	}
	
	@Test
	public void testBuzz() {
			
		assertEquals("Buzz", fizzBuzz.getFizzOrBuzz(5));
		assertEquals("Buzz", fizzBuzz.getFizzOrBuzz(10));
		assertEquals("Buzz", fizzBuzz.getFizzOrBuzz(20));

	}
	
	@Test
	public void testFizzBuzz() {
			
		assertEquals("FizzBuzz", fizzBuzz.getFizzOrBuzz(15));
		assertEquals("FizzBuzz", fizzBuzz.getFizzOrBuzz(30));
		assertEquals("FizzBuzz", fizzBuzz.getFizzOrBuzz(45));

	}

}
