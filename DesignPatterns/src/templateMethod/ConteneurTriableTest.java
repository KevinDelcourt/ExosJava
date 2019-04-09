package templateMethod;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ConteneurTriableTest {

	protected ConteneurTriable test;

	@Before
	public void setUp() throws Exception {
		this.test.addElement(new MyString("coucou"));
		this.test.addElement(new MyString("Hello"));
		this.test.addElement(new MyString("World"));
		this.test.addElement(new MyString("Monde"));
		this.test.addElement(new MyString("alphabet"));
		this.test.addElement(new MyString("alphabetisation"));
		this.test.addElement(new MyString("coucou"));
		this.test.addElement(new MyString("Zorro"));
		this.test.addElement(new MyString("Zoe"));
		this.test.addElement(new MyString("TouteBonneChoseAUneFin"));
	}

	@Test
	public void testTriArray() {
		this.test.trier();
		for(int i = 0; i < this.test.getLength() - 1 ; i++)
			assertTrue(this.test.getElement(i).inferieurOuEgal(this.test.getElement(i+1)));
	}

}
