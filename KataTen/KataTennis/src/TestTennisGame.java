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

	private void setterScores(int score1, int score2) {
		for(int i = 0; i < score1; i++)
			this.game.player1Scores();
		
		for(int j = 0; j < score2; j++)
			this.game.player2Scores();
	}
	
	@Test
	public void testNouveauJeu() {
		
		assertEquals("love - love" , this.game.currentScore());
		
	}
	
	@Test
	public void testJoueur1Marque1Point() {
		
		setterScores(1,0);
		assertEquals("fifteen - love" , this.game.currentScore());
		
	}
	
	@Test
	public void testJoueur2Marque1Point() {
		
		setterScores(0,1);
		assertEquals("love - fifteen" , this.game.currentScore());
		
	}
	
	@Test
	public void testJoueur1Et2Marquent1Point() {
		
		setterScores(1,1);
		assertEquals("fifteen - fifteen" , this.game.currentScore());
		
	}
	
	@Test
	public void testJoueur1Marque2Points() {
		
		setterScores(2,0);
		assertEquals("thirty - love" , this.game.currentScore());
		
	}
	
	@Test
	public void testJoueur2Marque2Points() {
		
		setterScores(0,2);
		assertEquals("love - thirty" , this.game.currentScore());
		
	}
	
	@Test
	public void testJoueur1Et2Marquent2Points() {
		
		setterScores(2,2);
		assertEquals("thirty - thirty" , this.game.currentScore());
		
	}

	
	
	@Test
	public void testJoueur1Marque3Points() {
		
		setterScores(3,0);
		assertEquals("forty - love" , this.game.currentScore());
		
	}
	
	@Test
	public void testJoueur2Marque3Points() {
		
		setterScores(0,3);
		assertEquals("love - forty" , this.game.currentScore());
		
	}

}
