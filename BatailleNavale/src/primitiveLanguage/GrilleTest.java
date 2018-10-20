package primitiveLanguage;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GrilleTest {

	private Grille grille;
	
	@Before
	public void setUp() throws Exception {
		this.grille = new Grille();
		
		Bateau bat1 = new Bateau("b1",3);
		Bateau bat2 = new Bateau("b1",4);
		Bateau bat3 = new Bateau("b1",5);
		Bateau bat4 = new Bateau("b1",2);
		Bateau bat5 = new Bateau("b1",3);
		
		grille.placerBateau(bat1, 'V', 'A', 1);
		grille.placerBateau(bat2, 'V', 'A', 2);
		grille.placerBateau(bat3, 'V', 'A', 3);
		grille.placerBateau(bat4, 'V', 'A', 4);
		grille.placerBateau(bat5, 'V', 'A', 5);
	}

	@After
	public void tearDown() throws Exception {
		this.grille = null;
	}

	@Test
	public void testInit() {
		assertFalse( grille.flotteCoulee() );
	}
	
	@Test
	public void testVisualisationCaseGrille() {
		assertEquals( '_', grille.visualisationCaseGrille('J',1) );
		assertEquals( '_', grille.visualisationCaseGrille('D',1) );
		assertEquals( '_', grille.visualisationCaseGrille('A',6) );
		
		assertEquals( 'S', grille.visualisationCaseGrille('A',1) );
		assertEquals( 'S', grille.visualisationCaseGrille('C',1) );
		assertEquals( 'S', grille.visualisationCaseGrille('A',2) );
		assertEquals( 'S', grille.visualisationCaseGrille('D',2) );
		assertEquals( 'S', grille.visualisationCaseGrille('A',3) );
		assertEquals( 'S', grille.visualisationCaseGrille('E',3) );
		assertEquals( 'S', grille.visualisationCaseGrille('A',4) );
		assertEquals( 'S', grille.visualisationCaseGrille('B',4) );
		assertEquals( 'S', grille.visualisationCaseGrille('A',5) );
		assertEquals( 'S', grille.visualisationCaseGrille('C',5) );
	}

	@Test
	public void testJouerCoup() {
		assertEquals( '0', grille.jouerCoup('J',1) );
		assertEquals( '0', grille.jouerCoup('D',1) );
		assertEquals( '0', grille.jouerCoup('A',6) );
		
		assertEquals( 'T', grille.jouerCoup('A',1) );
		assertEquals( 'T', grille.jouerCoup('C',1) );
		assertEquals( 'T', grille.jouerCoup('A',2) );
		assertEquals( 'T', grille.jouerCoup('A',3) );
		assertEquals( 'T', grille.jouerCoup('E',3) );
		assertEquals( 'T', grille.jouerCoup('A',4) );
		assertEquals( 'T', grille.jouerCoup('C',5) );
		
		assertEquals( 'C', grille.jouerCoup('B',1) );
		assertEquals( 'C', grille.jouerCoup('B',4) );
	}
	
	@Test
	public void testFlotteCoulee() {
		assertFalse( grille.flotteCoulee() );
		
		grille.jouerCoup('A', 1);
		grille.jouerCoup('B', 1);
		grille.jouerCoup('C', 1);
		
		grille.jouerCoup('A', 2);
		grille.jouerCoup('B', 2);
		grille.jouerCoup('C', 2);
		grille.jouerCoup('D', 2);
		
		grille.jouerCoup('A', 3);
		grille.jouerCoup('B', 3);
		grille.jouerCoup('C', 3);
		grille.jouerCoup('D', 3);
		grille.jouerCoup('E', 3);
		
		grille.jouerCoup('A', 4);
		grille.jouerCoup('B', 4);
		
		grille.jouerCoup('A', 5);
		grille.jouerCoup('B', 5);
		
		assertFalse( grille.flotteCoulee() );
		
		grille.jouerCoup('C', 5);
		
		assertTrue( grille.flotteCoulee() );
		
	}
	
	@Test
	public void testVerifierSortieGrille() {
		Bateau bateau = new Bateau("b1",3);
		
		assertTrue( grille.verifierSortieGrille(bateau,'V','A',1) );
		/*assertTrue( grille.verifierSortieGrille(bateau,'H','E',5) );
		assertTrue( grille.verifierSortieGrille(bateau,'V','J',7) );
		assertTrue( grille.verifierSortieGrille(bateau,'H','H',10) );*/
		
		/*assertFalse( grille.verifierSortieGrille(bateau,'H','0',5) );
		assertFalse( grille.verifierSortieGrille(bateau,'V','B',-5) );
		assertFalse( grille.verifierSortieGrille(bateau,'H','I',5) );
		assertFalse( grille.verifierSortieGrille(bateau,'V','B',8) );*/
	}
	
	@Test
	public void testVerifierSuperpositionTableau() {
		Bateau bateau = new Bateau("b1",3);
		
		assertTrue( grille.verifierSuperpositionTableau(bateau,'H',7,10) );
		assertTrue( grille.verifierSuperpositionTableau(bateau,'V',7,7) );
		assertTrue( grille.verifierSuperpositionTableau(bateau,'V',9,2) );
		
		//assertFalse( grille.verifierSuperpositionTableau(bateau,'H',1,1) );
		assertFalse( grille.verifierSuperpositionTableau(bateau,'V',2,2) );
		//assertFalse( grille.verifierSuperpositionTableau(bateau,'H',1,1) );
	}
}
