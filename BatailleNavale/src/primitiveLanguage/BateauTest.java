package primitiveLanguage;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BateauTest {

	private Bateau bateau;
	
	@Before
	public void setUp() throws Exception {
		this.bateau = new Bateau("test",4);
	}

	@After
	public void tearDown() throws Exception {
		bateau = null;
	}

	@Test
	public void testGetTailleBateau() {
		assertEquals(4, bateau.getTailleBateau());
	}
	
	@Test
	public void testSetTailleBateau() {
		
		bateau.setTailleBateau(2);
		assertEquals(2, bateau.getTailleBateau());
	}

	@Test
	public void testGetEtatBateau() {
		assertEquals('S', bateau.getEtatBateau());
	}
	
	@Test
	public void testSetEtatBateau() {
		bateau.setEtatBateau('C');
		assertEquals('C', bateau.getEtatBateau());
	}
	
	@Test
	public void testPlacerBateauHorizontal() {
		
		bateau.placerBateau('C', 2 , 'H');
		
		assertTrue( bateau.appartientBateau( 'C' , 2) );
		assertTrue( bateau.appartientBateau( 'C' , 3) );
		assertTrue( bateau.appartientBateau( 'C' , 4) );
		assertTrue( bateau.appartientBateau( 'C' , 5) );
		
		assertFalse( bateau.appartientBateau( 'C' , 6) );
		assertFalse( bateau.appartientBateau( 'C' , 1) );
		assertFalse( bateau.appartientBateau( 'B' , 3) );
		assertFalse( bateau.appartientBateau( 'D' , 4) );
		
	}
	
	@Test
	public void testPlacerBateauVertical() {
		
		bateau.placerBateau('B', 2 , 'A');
		
		assertTrue( bateau.appartientBateau( 'B' , 2) );
		assertTrue( bateau.appartientBateau( 'C' , 2) );
		assertTrue( bateau.appartientBateau( 'D' , 2) );
		assertTrue( bateau.appartientBateau( 'E' , 2) );
		
		assertFalse( bateau.appartientBateau( 'A' , 2) );
		assertFalse( bateau.appartientBateau( 'F' , 2) );
		assertFalse( bateau.appartientBateau( 'B' , 3) );
		assertFalse( bateau.appartientBateau( 'B' , 1) );
		
	}
	
	@Test
	public void testCoupRate() {
		bateau.placerBateau('C', 2 , 'H');
		
		assertFalse( bateau.coup('A',2) );
		assertEquals('S', bateau.getEtatBateau());
	}
	
	@Test
	public void testCoupTouche() {
		bateau.placerBateau('C', 2 , 'H');
		
		assertEquals('S', bateau.getEtatBateau());
		assertTrue( bateau.coup('C',2) );
		assertEquals('T', bateau.getEtatBateau());
	}
	
	@Test
	public void testCoupCoule() {
		bateau.placerBateau('C', 2 , 'H');
		
		assertEquals('S', bateau.getEtatBateau());
		
		assertTrue( bateau.coup('C',2) );
		assertEquals('T', bateau.getEtatBateau());
		
		assertTrue( bateau.coup('C',3) );
		assertEquals('T', bateau.getEtatBateau());
		
		assertTrue( bateau.coup('C',4) );
		assertEquals('T', bateau.getEtatBateau());
		
		assertTrue( bateau.coup('C',5) );
		assertEquals('C', bateau.getEtatBateau());
	}
	
	@Test
	public void testGetEtatElementSain() {
		bateau.placerBateau('C', 2 , 'H');
		
		assertEquals('_', bateau.getEtatElement('A',3));
		assertEquals('S', bateau.getEtatElement('C',3));
	}
	
	@Test
	public void testGetEtatElementTouche() {
		bateau.placerBateau('C', 2 , 'H');
		bateau.coup('C',3);
		assertEquals('S', bateau.getEtatElement('C',2));
		assertEquals('T', bateau.getEtatElement('C',3));
		assertEquals('S', bateau.getEtatElement('C',4));
		assertEquals('S', bateau.getEtatElement('C',5));
	}
	
	@Test
	public void testGetEtatElementCoule() {
		bateau.placerBateau('C', 2 , 'H');
		bateau.coup('C',2);
		bateau.coup('C',3);
		bateau.coup('C',4);
		bateau.coup('C',5);
		assertEquals('C', bateau.getEtatElement('C',2));
		assertEquals('C', bateau.getEtatElement('C',3));
		assertEquals('C', bateau.getEtatElement('C',4));
		assertEquals('C', bateau.getEtatElement('C',5));
	}
}
