package facteurs_premiers;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestFacteursPremiers {

	private DecompositionEnFacteursPremiers d; 
	
	@Before
	public void setUp() throws Exception {
		this.d = new DecompositionEnFacteursPremiers(); 
	}

	@After
	public void tearDown() throws Exception {
		this.d = null;
	}

	@Test  public void unNapasDeFacteursPremiers() {   
		
		assertEquals(Arrays.asList(), d.compute(1));  
		
	}  
	
	@Test  public void deuxAUnFacteurPremierDeux() {   
		
		assertEquals(Arrays.asList(2), d.compute(2)); 
		
	} 
	
	@Test  public void troisAUnFacteurPremierTrois() {   
		
		assertEquals(Arrays.asList(3), d.compute(3)); 
		
	} 

	@Test  public void quatreADeuxFacteursPremiersDeuxDeux() {   
		
		assertEquals(Arrays.asList( new Integer[]{2,2} ), d.compute(4)); 
		
	} 
	
	@Test  public void cingAUnFacteurPremierCinq() {   
		
		assertEquals(Arrays.asList(5), d.compute(5)); 
		
	} 
	
	@Test  public void sixADeuxFacteursPremiersDeuxTrois() {   
		
		assertEquals(Arrays.asList( new Integer[]{2,3} ), d.compute(6)); 
		
	} 
	
	@Test  public void huitATroisFacteursPremiersDeuxDeuxDeux() {   
		
		assertEquals(Arrays.asList( new Integer[]{2,2,2} ), d.compute(8)); 
		
	} 
	
	@Test  public void neufADeuxFacteursPremiersTroisTrois() {   
		
		assertEquals(Arrays.asList( new Integer[]{3,3} ), d.compute(9)); 
		
	} 
	
	@Test  public void dixADeuxFacteursPremiersDeuxCinq() {   
		
		assertEquals(Arrays.asList( new Integer[]{2,5} ), d.compute(10)); 
		
	} 
	
	@Test  public void quaranteDeuxATroisFacteursPremiersDeuxTroisSept() {   
		
		assertEquals(Arrays.asList( new Integer[]{2,3,7} ), d.compute(42)); 
		
	} 
}
