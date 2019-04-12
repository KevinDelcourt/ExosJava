package expressions_logiques_test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import expressions_logiques.Not;
import expressions_logiques.VariableBooléenne;

public class NotTest {

	private Not not;
	@Before
	public void setUp() throws Exception {
		this.not = new Not();
	}

	@After
	public void tearDown() throws Exception {
		this.not = null;
	}

	@Test
	public void testToStringPasOperande() {
		assertEquals("",this.not.toString());
	}
	
	@Test
	public void testToString() {
		this.not.setOperande(new VariableBooléenne("a", "truc"));
		assertEquals("!a",this.not.toString());
	}
	
	@Test
	public void testIsSatisfiablePasOperande() {
		assertFalse(this.not.isSatisfiable());
	}
	
	@Test
	public void testIsSatisfiableFauxSiNonVrai() {
		VariableBooléenne a = new VariableBooléenne("a","truc");
		a.fixerValeurDeVérité(true);
		this.not.setOperande(a);
		assertFalse(this.not.isSatisfiable());
	}
	
	@Test
	public void testIsSatisfiableVraiSiNonFaux() {
		VariableBooléenne a = new VariableBooléenne("a","truc");
		a.fixerValeurDeVérité(false);
		this.not.setOperande(a);
		assertTrue(this.not.isSatisfiable());
	}

}
