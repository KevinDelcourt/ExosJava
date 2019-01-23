package recherche_pattern;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class FastRecherchePatternTest {

	public final static String pattern = "AT-THAT";  
	public final static String phrase = "...WHICH-FINALLY-HALTS.--AT-THAT-POINT...";  
	private FastRecherchePattern fastRecherchePattern;
	
	@Before  
	public void setUp() throws Exception 
	{   
		this.fastRecherchePattern = new FastRecherchePattern();  	
	} 
	 
	@After  
	public void tearDown() throws Exception 
	{   
		this.fastRecherchePattern = null;  
	} 
	
	@Test
	public void performanceTestEquals() 
	{
		assertFalse(fastRecherchePattern.equals(pattern,phrase,24));
		assertEquals(1,fastRecherchePattern.getCompteur());
	}
	
	@Test
	public void testDelta1EmptyPattern()
	{
		int[] expectedResult = new int[28];
		int[] result = fastRecherchePattern.buildDelta1("");
		assertArrayEquals(expectedResult,result);
	}
	
	@Test
	public void testDelta1Pattern()
	{
		int[] expectedResult = {1,7,7,7,7,7,7,2,7,7,7,7,7,7,7,7,7,7,7,0,7,7,7,7,7,7,7,4};
		int[] result = fastRecherchePattern.buildDelta1(pattern);
		assertArrayEquals(expectedResult,result);
	}
	
	@Test
	public void testDelta2()
	{
		int[] expectedResult1 = {14,13,12,11,10,9,11,10,1};
		int[] result1 = fastRecherchePattern.buildDelta2("ABCXXXABC");
		assertArrayEquals(expectedResult1,result1);
		
		int[] expectedResult2 = {17,16,15,14,13,12,7,10,1};
		int[] result2 = fastRecherchePattern.buildDelta2("ABYXCDEYX");
		assertArrayEquals(expectedResult2,result2);
	}
	
	@Test
	public void performanceTestSearchUsingOnlyDelta1()
	{
		String phrase = "......H.A-...X......Z......QAT-THAT....";
		assertEquals(34,fastRecherchePattern.searchPattern("AT-THAT", phrase));
		assertEquals(13,fastRecherchePattern.getCompteur());
	}
	
	@Test
	public void performanceTestSearchUsingOnlyDelta2()
	{
		String phrase = "HHYXCDEYXABYXCDEYX";
		assertEquals(17,fastRecherchePattern.searchPattern("ABYXCDEYX", phrase));
		assertEquals(17,fastRecherchePattern.getCompteur());
	}
	
	@Test
	public void performanceTestAcceptation()
	{
		String phrase = "WHICH-FINALLY-HALTS.--AT-THAT-POINT";
		assertEquals(28,fastRecherchePattern.searchPattern(pattern, phrase));
		assertEquals(14,fastRecherchePattern.getCompteur());
	}
	
	
	
}

