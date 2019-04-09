package templateMethod;

import static org.junit.Assert.*;

import java.awt.Color;

import org.junit.Test;

public class MyColorTest {

	@Test
	public void testCouleursEgales() {
		MyColor c1 = new MyColor(new Color(1,2,3));
		MyColor c2 = new MyColor(new Color(1,2,3));
		MyColor c3 = new MyColor(new Color(2,2,3));
		MyColor c4 = new MyColor(new Color(1,3,3));
		MyColor c5 = new MyColor(new Color(1,2,4));
		assertTrue(c1.egal(c2));
		assertFalse(c1.egal(c3));
		assertFalse(c1.egal(c4));
		assertFalse(c1.egal(c5));
	}

	@Test (expected=RuntimeException.class)
	public void testExceptionEgalPourCouleurNulle() {
		MyColor c1 = new MyColor(new Color(1,2,3));
		c1.egal(null);
	}
	
	@Test (expected=RuntimeException.class)
	public void testExceptionEgalPourNonComparable() {
		MyColor c1 = new MyColor(new Color(1,2,3));
		c1.egal(new MyString("test"));
	}
	
	@Test (expected=RuntimeException.class)
	public void testExceptionInferieurPourCouleurNulle() {
		MyColor c1 = new MyColor(new Color(1,2,3));
		c1.inferieur(null);
	}
	
	@Test (expected=RuntimeException.class)
	public void testExceptionInferieurPourNonComparable() {
		MyColor c1 = new MyColor(new Color(1,2,3));
		c1.inferieur(new MyString("test"));
	}
	
	@Test 
	public void testCouleursInferieures() {
		MyColor c1 = new MyColor(new Color(1,2,3));
		MyColor c2 = new MyColor(new Color(1,2,4));
		MyColor c3 = new MyColor(new Color(1,2,2));
		assertTrue(c1.inferieur(c2));
		assertFalse(c1.inferieur(c3));
		assertFalse(c1.inferieur(c1));
	}
	
	@Test 
	public void testCouleursInferieuresOuEgales() {
		MyColor c1 = new MyColor(new Color(1,2,3));
		MyColor c2 = new MyColor(new Color(1,2,4));
		MyColor c3 = new MyColor(new Color(1,2,2));
		assertTrue(c1.inferieurOuEgal(c2));
		assertFalse(c1.inferieurOuEgal(c3));
		assertTrue(c1.inferieurOuEgal(c1));
	}
	
	@Test
	public void testCouleursSuperieures() {
		MyColor c1 = new MyColor(new Color(1,2,3));
		MyColor c2 = new MyColor(new Color(1,2,4));
		MyColor c3 = new MyColor(new Color(1,2,2));
		assertFalse(c1.superieur(c2));
		assertTrue(c1.superieur(c3));
		assertFalse(c1.superieur(c1));
	}
	
	@Test
	public void testCouleursSuperieuresOuEgales() {
		MyColor c1 = new MyColor(new Color(1,2,3));
		MyColor c2 = new MyColor(new Color(1,2,4));
		MyColor c3 = new MyColor(new Color(1,2,2));
		assertFalse(c1.superieurOuEgal(c2));
		assertTrue(c1.superieurOuEgal(c3));
		assertTrue(c1.superieurOuEgal(c1));
	}
}
