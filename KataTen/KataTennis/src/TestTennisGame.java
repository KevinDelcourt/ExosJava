import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestTennisGame {

	private TennisGame game;	
	
	@Before
	public void setUp() throws Exception {
		this.game = new TennisGame();
	}

	@After
	public void tearDown() throws Exception {
		this.game = null;
	}

	@Test
	public void testNouveauJeu() {
		
		assertEquals("love - love" , this.game.currentScore());
		
	}

}
