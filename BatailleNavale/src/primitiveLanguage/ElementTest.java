package primitiveLanguage;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ElementTest {

	private Element element;
	
	@Before
	public void setUp() throws Exception {
		this.element = new Element('A',3);
	}

	@After
	public void tearDown() throws Exception {
		this.element = null;
	}

	@Test
	public void testVerifCoordonnee() {
		assertTrue( element.verifierCoordonnees('A', 3) );
		assertFalse( element.verifierCoordonnees('A', 6) );
		assertFalse( element.verifierCoordonnees('B', 3) );
	}
	
	@Test
	public void testIsElementTouche() {
		assertFalse( element.isElementTouche() );
	}
	
	@Test
	public void testTouche() {
		element.touche();
		assertTrue( element.isElementTouche() );
	}

}
