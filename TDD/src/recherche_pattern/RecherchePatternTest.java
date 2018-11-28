package recherche_pattern;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class RecherchePatternTest {

	public final static String pattern = "AT-THAT";  
	public final static String phrase = "...WHICH-FINALLY-HALTS.--AT-THAT-POINT...";  
	private RecherchePattern recherchePattern;
	
	@Before  
	public void setUp() throws Exception 
	{   
		this.recherchePattern = new RecherchePattern();  	
	} 
	 
	@After  
	public void tearDown() throws Exception 
	{   
		this.recherchePattern = null;  
	} 
	 
	private int searchWithInfo(String pattern, String phrase) 
	{
		int retour = recherchePattern.searchPattern(pattern,phrase);
		
		System.out.println("Recherche de '"+pattern+"' Longueur " + pattern.length());
		System.out.println("Dans '"+phrase+"' Longueur " + phrase.length());
		System.out.println("- "+ recherchePattern.getCompteur() +" Itérations.");
		
		if(retour == -1)
			System.out.println("- N'a pas été trouvé");
		
		System.out.print("\n");
		
		return retour;
	}
	
	@Test 
	public void testEqualsPatternSubStringWithOneCharacter() 
	{   
		String pattern ="A";   
		assertFalse(recherchePattern.equals(pattern,phrase,0));  
		assertFalse(recherchePattern.equals(pattern,phrase,1)); 
	    assertFalse(recherchePattern.equals(pattern,phrase,2));  
	    assertFalse(recherchePattern.equals(pattern,phrase,3));  
	    assertFalse(recherchePattern.equals(pattern,phrase,4));   
	    assertTrue(recherchePattern.equals(pattern,phrase,12));   
	    assertFalse(recherchePattern.equals(pattern,phrase,13));   
	    assertTrue(recherchePattern.equals(pattern,phrase,18));  
	}
	
	@Test 
	public void testEqualsPatternSubStringWithTwoCharacters() 
	{  
		String pattern ="AT";   
		assertFalse(recherchePattern.equals(pattern,phrase,1));   
		assertFalse(recherchePattern.equals(pattern,phrase,13));   
		assertFalse(recherchePattern.equals(pattern,phrase,13));
		assertFalse(recherchePattern.equals(pattern,phrase,19));  
		assertTrue(recherchePattern.equals(pattern,phrase,26));  	
	} 
	
	@Test
	public void  testEqualsPatternSubString() 
	{
		assertFalse(recherchePattern.equals(pattern,phrase,30));
		assertFalse(recherchePattern.equals(pattern,phrase,32));
		assertFalse(recherchePattern.equals(pattern,phrase,25));
		assertFalse(recherchePattern.equals(pattern,phrase,2));
		assertFalse(recherchePattern.equals(pattern,phrase,-2));
		
		assertTrue(recherchePattern.equals(pattern,phrase,31));
	}
	
	@Test  
	public void testSearchFirstOccurenceOfThePattern() 
	{   
		assertEquals(-1,searchWithInfo(pattern,"...WHIC")); 
		assertEquals(40,searchWithInfo(phrase,phrase));
		assertEquals(-1,searchWithInfo("BLXRT",phrase));
		assertEquals(7,searchWithInfo("WHICH",phrase));
		assertEquals(31,searchWithInfo("-THAT",phrase));
		assertEquals(37,searchWithInfo("POINT",phrase));
		assertEquals(40,searchWithInfo("NT...",phrase));
		assertEquals(31,searchWithInfo(pattern,phrase)); 
	}
}

