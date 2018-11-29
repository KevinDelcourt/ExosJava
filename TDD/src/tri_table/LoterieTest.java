package tri_table;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class LoterieTest {

	private Loterie loterie;
	
	@Before
	public void setUp() throws Exception {
		loterie = new Loterie();
	}

	@After
	public void tearDown() throws Exception {
		loterie = null;
	}

	@Test
	public void testAucuneBouleTiree() {
		assertEquals("",loterie.tirage(null));
	}

	@Test
	public void testUneBouleTiree() {
		int[] boules = {10};
		assertEquals("10",loterie.tirage(boules) );
	}
	
	@Test
	public void testDeuxBoulesTirees() {
		int[] boules = {10,20};
		assertEquals("10 20",loterie.tirage(boules) );
	}
	
	@Test
	public void testTroisBoulesTirees() {
		int[] boules = {10,20,30};
		assertEquals("10 20 30",loterie.tirage(boules) );
	}
}
