package templateMethod;

import static org.junit.Assert.*;

import java.awt.Color;

import org.junit.Test;

public class MyStringTest {

	@Test
	public void testChainesEgales() {
		MyString s1 = new MyString("abcd");
		assertTrue(s1.egal(new MyString("Abcd")));
		assertFalse(s1.egal(new MyString("bbcd")));
		assertFalse(s1.egal(new MyString("accd")));
		assertFalse(s1.egal(new MyString("abdd")));
		assertFalse(s1.egal(new MyString("abce")));
		assertFalse(s1.egal(new MyString("abcde")));
		assertFalse(s1.egal(new MyString("abc")));
		assertTrue(s1.egal(s1));
	}
	
	
	@Test (expected=RuntimeException.class)
	public void testExceptionEgalPourChaineNulle() {
		MyString s1 = new MyString("abcd");
		s1.egal(null);
	}
	
	@Test (expected=RuntimeException.class)
	public void testExceptionEgalPourNonComparable() {
		MyString s1 = new MyString("abcd");
		s1.egal(new MyColor(new Color(1,2,3)));
	}
	
	@Test
	public void testChainesInferieures() {
		MyString s1 = new MyString("abcd");
		assertTrue(s1.inferieur(new MyString("bbcd")));
		assertTrue(s1.inferieur(new MyString("accd")));
		assertTrue(s1.inferieur(new MyString("abdd")));
		assertTrue(s1.inferieur(new MyString("abce")));
		assertTrue(s1.inferieur(new MyString("abcde")));
		assertFalse(s1.inferieur(new MyString("abc")));
		assertFalse(s1.inferieur(s1));
	}
	
	@Test (expected=RuntimeException.class)
	public void testExceptionInferieurPourChaineNulle() {
		MyString s1 = new MyString("abcd");
		s1.inferieur(null);
	}
	
	@Test (expected=RuntimeException.class)
	public void testExceptionInferieurPourNonComparable() {
		MyString s1 = new MyString("abcd");
		s1.egal(new MyColor(new Color(1,2,3)));
	}

}
