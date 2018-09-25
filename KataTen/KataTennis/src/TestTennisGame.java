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
	
	@Test
	public void testJoueur1Marque1Point() {
		
		this.game.player1Scores();
		assertEquals("fifteen - love" , this.game.currentScore());
		
	}
	
	@Test
	public void testJoueur2Marque1Point() {
		
		this.game.player2Scores();
		assertEquals("love - fifteen" , this.game.currentScore());
		
	}
	
	@Test
	public void testJoueur1Et2Marquent1Point() {
		
		this.game.player2Scores();
		this.game.player1Scores();
		assertEquals("fifteen - fifteen" , this.game.currentScore());
		
	}
	
	@Test
	public void testJoueur1Marque2Points() {
		
		this.game.player1Scores();
		this.game.player1Scores();
		assertEquals("thirty - love" , this.game.currentScore());
		
	}
	
	@Test
	public void testJoueur2Marque2Points() {
		
		this.game.player2Scores();
		this.game.player2Scores();
		assertEquals("love - thirty" , this.game.currentScore());
		
	}
	
	@Test
	public void testJoueur1Et2Marquent2Points() {
		
		this.game.player2Scores();
		this.game.player2Scores();
		this.game.player1Scores();
		this.game.player1Scores();
		assertEquals("thirty - thirty" , this.game.currentScore());
		
	}
	
	@Test
	public void testJoueur1Marque3Points() {
		
		this.game.player1Scores();
		this.game.player1Scores();
		this.game.player1Scores();
		assertEquals("forty - love" , this.game.currentScore());
		
	}
	
	@Test
	public void testJoueur2Marque3Points() {
		
		this.game.player2Scores();
		this.game.player2Scores();
		this.game.player2Scores();
		assertEquals("love - forty" , this.game.currentScore());
		
	}

}
