package expressions_logiques_test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import expressions_logiques.VariableBooléenne;

public class VariableBooléenneTest {

	private VariableBooléenne v;
	
	@Before
	public void setUp() throws Exception {
		this.v = new VariableBooléenne("a","truc");
	}

	@After
	public void tearDown() throws Exception {
		this.v = null;
	}

	@Test
	public void testInit() {
		assertEquals("truc", this.v.interprétation());
		assertEquals("a", this.v.toString());
		assertTrue(this.v.isSatisfiable());
	}
	
	@Test
	public void testFixerValeurDeVeriteVrai() {
		v.fixerValeurDeVérité(true);
		assertTrue(this.v.isSatisfiable());
	}
	
	@Test
	public void testFixerValeurDeVeriteFaux() {
		v.fixerValeurDeVérité(false);
		assertFalse(this.v.isSatisfiable());
	}
	
	@Test
	public void testInterpretentationFausse() {
		v.fixerValeurDeVérité(false);
		assertEquals("non truc", this.v.interprétation());
	}

}
