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
	 
	private int searchWithInfo(String pattern, String phrase) 
	{
		int retour = fastRecherchePattern.searchPattern(pattern,phrase);
		
		System.out.println("Recherche de '"+pattern+"'(" + pattern.length()+")");
		System.out.println("Dans '"+phrase+"'(" + phrase.length()+")");
		System.out.println("- "+ fastRecherchePattern.getCompteur() +" Itérations");
		
		if(retour == -1)
			System.out.println("- N'a pas été trouvé");
		
		System.out.print("\n");
		
		return retour;
	}
	
	@Test 
	public void testEqualsPatternSubStringWithOneCharacter() 
	{   
		String pattern ="A";   
		assertFalse(fastRecherchePattern.equals(pattern,phrase,0));  
		assertFalse(fastRecherchePattern.equals(pattern,phrase,1)); 
	    assertFalse(fastRecherchePattern.equals(pattern,phrase,4));   
	    assertTrue(fastRecherchePattern.equals(pattern,phrase,12));   
	    assertFalse(fastRecherchePattern.equals(pattern,phrase,13));   
	    assertTrue(fastRecherchePattern.equals(pattern,phrase,18));  
	}
	
	@Test 
	public void testEqualsPatternSubStringWithTwoCharacters() 
	{  
		String pattern ="AT";   
		assertFalse(fastRecherchePattern.equals(pattern,phrase,1));   
		assertFalse(fastRecherchePattern.equals(pattern,phrase,13));   
		assertFalse(fastRecherchePattern.equals(pattern,phrase,13));
		assertFalse(fastRecherchePattern.equals(pattern,phrase,19));  
		assertTrue(fastRecherchePattern.equals(pattern,phrase,26));  	
	} 
	
	@Test
	public void  testEqualsPatternSubString() 
	{
		assertFalse(fastRecherchePattern.equals(pattern,phrase,30));
		assertFalse(fastRecherchePattern.equals(pattern,phrase,32));
		assertFalse(fastRecherchePattern.equals(pattern,phrase,26));
		assertFalse(fastRecherchePattern.equals(pattern,phrase,2));
		assertFalse(fastRecherchePattern.equals(pattern,phrase,-2));
		assertTrue(fastRecherchePattern.equals(pattern,phrase,31));
	}

	@Test  
	public void testSearchFirstOccurenceOfThePattern() 
	{   
		assertEquals(-1,searchWithInfo("BLXRT",phrase));
		assertEquals(7,searchWithInfo("WHICH",phrase));
		assertEquals(40,searchWithInfo("NT...",phrase));
		assertEquals(31,searchWithInfo(pattern,phrase)); 
	}
	
	@Test
	public void performanceTestEquals() 
	{
		//Ne peux passer que si les comparaisons commencent à droite
		fastRecherchePattern.equals(pattern,phrase,24);
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
	public void performanceTestAcceptation()
	{
		String phrase = "WHICH-FINALLY-HALTS.--AT-THAT-POINT";
		assertEquals(28,fastRecherchePattern.searchPattern(pattern, phrase));
		assertEquals(14,fastRecherchePattern.getCompteur());
	}
	
}

