package recherche_pattern;
import static org.junit.Assert.*;


import java.util.Arrays;

import java.util.Collection;

import org.junit.Test;

import org.junit.runner.RunWith;

import org.junit.runners.Parameterized;

import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)

public class TestEqualsRecherchePattern {

	public final static String phrase = "...WHICH-FINALLY-HALTS.--AT-THAT-POINT..."; 
	
    private boolean expectedResult;
    
    private int searchIndex;
    
    private String pattern;

    public TestEqualsRecherchePattern(String pattern, int searchIndex, boolean expectedResult) {

    	this.pattern = pattern;
    	
    	this.searchIndex = searchIndex;
    	
    	this.expectedResult = expectedResult;

    }
  

    @Parameters
    public static Collection<Object[]> getAllEqualsTests() {

        return Arrays.asList(new Object[][] {

        	{"A" , 0 , false},
        	
        	{"A" , 1 , false},
        	
        	{"A" , 4 , false},
        	
        	{"A" , 12, true },
        	
        	{"A" , 13, false},
        	
        	{"A" , 18, true },
        	
        	{"AT", 1 , false},
        	
        	{"AT", 13, false},
        	
        	{"AT", 19, false},
        	
        	{"AT", 26, true },
        	
        	{"AT-THAT", 30, false},
        	
        	{"AT-THAT", 32, false},
        	
        	{"AT-THAT", 26, false},
        	
        	{"AT-THAT", 2 , false},
        	
        	{"AT-THAT", -2, false},
        	
        	{"AT-THAT", 31, true }

        });

    }

    @Test

    public void testEqualsNaiveRecherchePattern() {

        NaiveRecherchePattern rp = new NaiveRecherchePattern();

        assertEquals(this.expectedResult,rp.equals(this.pattern, phrase, this.searchIndex));

    }
    
    @Test

    public void testEqualsFastRecherchePattern() {

        FastRecherchePattern frp = new FastRecherchePattern();

        assertEquals(this.expectedResult,frp.equals(this.pattern, phrase, this.searchIndex));

    }
}