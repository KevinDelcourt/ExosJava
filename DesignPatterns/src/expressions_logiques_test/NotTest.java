package expressions_logiques_test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import expressions_logiques.Not;
import expressions_logiques.VariableBool�enne;

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
		this.not.setOperande(new VariableBool�enne("a", "truc"));
		assertEquals("!a",this.not.toString());
	}
	
	@Test
	public void testIsSatisfiablePasOperande() {
		assertFalse(this.not.isSatisfiable());
	}
	
	@Test
	public void testIsSatisfiableFauxSiNonVrai() {
		VariableBool�enne a = new VariableBool�enne("a","truc");
		a.fixerValeurDeV�rit�(true);
		this.not.setOperande(a);
		assertFalse(this.not.isSatisfiable());
	}
	
	@Test
	public void testIsSatisfiableVraiSiNonFaux() {
		VariableBool�enne a = new VariableBool�enne("a","truc");
		a.fixerValeurDeV�rit�(false);
		this.not.setOperande(a);
		assertTrue(this.not.isSatisfiable());
	}

}
