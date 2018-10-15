import static org.junit.Assert.*;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/*
 * Note pour le devoir
 * 	Complétude des tests
 *  Tests dans algorithmique
 *  Des noms de test parlant
 *  Tests unitaires isolés
 *  
 *  charAt(
 *  setCharAt(
 *  append(
 */


public class StringBufferTest {

	private StringBuffer stringBuffer;
	
	@Before
	public void setUp() throws Exception {
		this.stringBuffer = new StringBuffer();
		stringBuffer.append("Ab1*%");

	}

	@After
	public void tearDown() throws Exception {
		this.stringBuffer = null;
	}

	@Test
	public void testSetUp() {

		assertEquals( "Ab1*%" , stringBuffer.toString() );
		
	}
	
	@Test
	public void testCharAt() {
		
		assertEquals( 'A' , stringBuffer.charAt(0) );
		assertEquals( 'b' , stringBuffer.charAt(1) );
		assertEquals( '1' , stringBuffer.charAt(2) );
		assertEquals( '*' , stringBuffer.charAt(3) );
		assertEquals( '%' , stringBuffer.charAt(4) );
	}
	
	@Test
	public void  testCharAtWithSuperiorIndex() {	
		
		try{   
			stringBuffer.charAt(8);
			fail( "charAt() aurait dû générer une exception");  
		}  catch ( RuntimeException e ) {  
			assertTrue( true );  
		}

	}
	
	@Test
	public void  testCharAtWithNegativeIndex() {	
		
		try{   
			stringBuffer.charAt(-2);
			fail( "charAt() aurait dû générer une exception");  
		}  catch ( RuntimeException e ) {  
			assertTrue( true );  
		}

	}
	
	@Test
	public void testSetCharAt() {
		
		stringBuffer.setCharAt(2, '§');

		assertEquals( "Ab§*%" , stringBuffer.toString() );
	}
	
	@Test
	public void  testSetCharAtWithSuperiorIndex() {
		
		try{   
			stringBuffer.setCharAt(10,'A');
			fail( "setCharAt() aurait dû générer une exception");  
		}  catch ( RuntimeException e ) {  
			assertTrue( true );  
		}
		
	}
	
	@Test
	public void  testSetCharAtWithNegativeIndex() {
		
		try{   
			stringBuffer.setCharAt(-3,'A');
			fail( "setCharAt() aurait dû générer une exception");  
		}  catch ( RuntimeException e ) {  
			assertTrue( true );  
		}
		
	}
	
	@Test
	public void  testAppend() {
		
		stringBuffer.append("a$ 8");
		
		assertEquals( "Ab1*%a$ 8" , stringBuffer.toString() );

	}
	
	@Test
	public void  testAppendWithNullString() {
		
		String str = null;
		
		stringBuffer.append(str);
		
		assertEquals( "Ab1*%null" , stringBuffer.toString() );

	}

	@Test
	public void  testAppendWithEmptyString() {
		
		stringBuffer.append("");
		
		assertEquals( "Ab1*%" , stringBuffer.toString() );
	}
}
