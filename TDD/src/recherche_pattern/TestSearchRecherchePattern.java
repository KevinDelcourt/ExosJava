package recherche_pattern;
import static org.junit.Assert.*;


import java.util.Arrays;

import java.util.Collection;

import org.junit.Test;

import org.junit.runner.RunWith;

import org.junit.runners.Parameterized;

import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)

public class TestSearchRecherchePattern {

	public final static String PATTERN = "AT-THAT";  

	public final static String PHRASE = "...WHICH-FINALLY-HALTS.--AT-THAT-POINT..."; 
	    
    private String pattern;
    
    private String phrase;
    
    private int expectedResult;

    public TestSearchRecherchePattern(String pattern, String phrase, int expectedResult) {

    	this.pattern = pattern;
    	
    	this.phrase = phrase;
    	
    	this.expectedResult = expectedResult;

    }
  

    @Parameters
    public static Collection<Object[]> getAllSearchTests() {

        return Arrays.asList(new Object[][] {
        	
        	{"BLXRT",PHRASE,-1},
        	
        	{"O",PHRASE,34},
        	
        	{"AL",PHRASE,13},
        	
        	{"Y-",PHRASE,16},
        	
        	{"T..",PHRASE,39},
        	
        	{"AT-T",PHRASE,28},
        	
        	{"TS.-",PHRASE,23},
        	
        	{"WHICH",PHRASE,7},
        	
        	{"NT...",PHRASE,40},
        	
        	{PATTERN,PHRASE,31}

        });

    }

    private int searchWithInfo(MesurableRecherchePattern mrp) 
	{
		int retour = mrp.searchPattern(this.pattern,this.phrase);
		
		String className = mrp.getClass().toString().split("n.")[1];
		
		System.out.println("* "+className+" *");
		System.out.println("Recherche de '"+this.pattern+"'(" + this.pattern.length()+")");
		System.out.println("Dans '"+this.phrase+"'(" + this.phrase.length()+")");
		System.out.println("- "+ mrp.getCompteur() +" Itérations");
		
		if(retour == -1)
			System.out.println("- N'a pas été trouvé");
		
		System.out.println();
		
		return retour;
	}
    
    @Test

    public void testSearchNaiveRecherchePattern() {

        NaiveRecherchePattern rp = new NaiveRecherchePattern();

        assertEquals(this.expectedResult,searchWithInfo(rp));

    }
    
    @Test

    public void testSearchFastRecherchePattern() {

        FastRecherchePattern frp = new FastRecherchePattern();

        assertEquals(this.expectedResult,searchWithInfo(frp));

    }
}