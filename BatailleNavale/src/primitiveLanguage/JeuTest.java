package primitiveLanguage;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class JeuTest {
	
	private Jeu jeu;

	private void initialiser() {
		
		jeu.initialiser(1, "porte avion", 5, 'A', 1, 'V');
		jeu.initialiser(1, "croiseur", 4, 'A', 2, 'V');
		jeu.initialiser(1, "torpilleur", 3, 'A', 3, 'V');
		jeu.initialiser(1, "contre torpilleur", 2, 'A', 4, 'V');
		jeu.initialiser(1, "sous-marin", 3, 'A', 5, 'V');
		
		jeu.initialiser(2, "porte avion", 5, 'A', 1, 'V');
		jeu.initialiser(2, "croiseur", 4, 'A', 2, 'V');
		jeu.initialiser(2, "torpilleur", 3, 'A', 3, 'V');
		jeu.initialiser(2, "contre torpilleur", 2, 'A', 4, 'V');
		jeu.initialiser(2, "sous-marin", 3, 'A', 5, 'V');
	}
	
	@Before
	public void setUp() throws Exception {
		this.jeu = new Jeu();
	}

	@After
	public void tearDown() throws Exception {
		this.jeu = null;
	}

	@Test
	public void testNomsBateaux() {
		String[] resultatAttendu = {"porte avion","croiseur","sous-marin","contre torpilleur","torpilleur"};
		assertArrayEquals(resultatAttendu, jeu.nomsBateaux() );
	}
	
	@Test
	public void testNbElementBateau() {
		
		assertEquals(5, jeu.nbElementBateau("porte avion") );
		assertEquals(4, jeu.nbElementBateau("croiseur") );
		assertEquals(3, jeu.nbElementBateau("torpilleur") );
		assertEquals(2, jeu.nbElementBateau("contre torpilleur") );
		assertEquals(3, jeu.nbElementBateau("sous-marin") );
		
	}
	
	@Test
	public void testInitialiser() {
		
		this.initialiser();
		assertFalse( jeu.finDuJeu() );
		
	}

}
