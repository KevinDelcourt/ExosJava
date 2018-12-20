package tri_table;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TriNotesTest {

	private TriNotes triNotes;
	@Before
	public void setUp() throws Exception {
		this.triNotes = new TriNotes();
	}

	@After
	public void tearDown() throws Exception {
		this.triNotes = null;
	}

	@Test
	public void test0Notes() {
		Integer[] notes = null;
		
		assertEquals("",triNotes.triDesNotes(notes));
	}
	
	@Test
	public void test1Note() {
		Integer[] notes = {10};
		
		assertEquals("(1,10)",triNotes.triDesNotes(notes));
	}
	
	@Test
	public void test2NotesIdentiques() {
		Integer[] notes = {10,10};
		
		assertEquals("(2,10)",triNotes.triDesNotes(notes));
	}
	
	@Test
	public void test2NotesDifférentes() {
		Integer[] notes = {9,10};
		
		assertEquals("(1,9)(1,10)",triNotes.triDesNotes(notes));
	}
	
	@Test
	public void test3NotesDifférentesDésordre() {
		Integer[] notes = {15,10,12};
		
		assertEquals("(1,10)(1,12)(1,15)",triNotes.triDesNotes(notes));
	}
	
	@Test
	public void testAcceptation() {
		Integer[] notes = {15,10,12,18,5,10,12,5,12,18,16};
		
		assertEquals("(2,5)(2,10)(3,12)(1,15)(1,16)(2,18)",triNotes.triDesNotes(notes));
	}

}
