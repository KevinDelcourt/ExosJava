package tri_table;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ConspirationTest {

	private Conspiration conspiration;
	@Before
	public void setUp() throws Exception {
		conspiration = new Conspiration();
	}

	@After
	public void tearDown() throws Exception {
		conspiration = null;
	}

	@Test
	public void testChaineVide() {
		assertEquals("",conspiration.tri(""));
	}
	
	@Test
	public void testQueDesLettresa () {
		assertEquals("aaa",conspiration.tri("aAA"));
	}

}
