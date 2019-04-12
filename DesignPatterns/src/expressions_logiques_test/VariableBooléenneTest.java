package expressions_logiques_test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import expressions_logiques.VariableBool�enne;

public class VariableBool�enneTest {

	private VariableBool�enne v;
	
	@Before
	public void setUp() throws Exception {
		this.v = new VariableBool�enne("a","truc");
	}

	@After
	public void tearDown() throws Exception {
		this.v = null;
	}

	@Test
	public void testInit() {
		assertEquals("truc", this.v.interpr�tation());
		assertEquals("a", this.v.toString());
		assertTrue(this.v.isSatisfiable());
	}
	
	@Test
	public void testFixerValeurDeVeriteVrai() {
		v.fixerValeurDeV�rit�(true);
		assertTrue(this.v.isSatisfiable());
	}
	
	@Test
	public void testFixerValeurDeVeriteFaux() {
		v.fixerValeurDeV�rit�(false);
		assertFalse(this.v.isSatisfiable());
	}
	
	@Test
	public void testInterpretentationFausse() {
		v.fixerValeurDeV�rit�(false);
		assertEquals("non truc", this.v.interpr�tation());
	}

}
