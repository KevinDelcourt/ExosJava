import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestTennisGame {

	private TennisGame Win;	
	
	@Before
	public void setUp() throws Exception {
		this.Win = new TennisGame();
	}

	@After
	public void tearDown() throws Exception {
		this.Win = null ;
	}

	private void setterScores(int score1, int score2) {
		for(int i = 0; i < score1; i++)
			this.Win.player1Scores();
		
		for(int j = 0; j < score2; j++)
			this.Win.player2Scores();
	}
	
	@Test
	public void testNouveauJeu() {
		
		assertEquals("Love-All" , this.Win.currentScore());
		
	}
	
	@Test
	public void testJoueur1Marque1Point() {
		
		setterScores(1,0);
		assertEquals("Fifteen-Love" , this.Win.currentScore());
		
	}
	
	@Test
	public void testJoueur2Marque1Point() {
		
		setterScores(0,1);
		assertEquals("Love-Fifteen" , this.Win.currentScore());
		
	}
	
	@Test
	public void testJoueur1Et2Marquent1Point() {
		
		setterScores(1,1);
		assertEquals("Fifteen-All" , this.Win.currentScore());
		
	}
	
	@Test
	public void testJoueur1Marque2Points() {
		
		setterScores(2,0);
		assertEquals("Thirty-Love" , this.Win.currentScore());
		
	}
	
	@Test
	public void testJoueur2Marque2Points() {
		
		setterScores(0,2);
		assertEquals("Love-Thirty" , this.Win.currentScore());
		
	}
	
	@Test
	public void testJoueur1Et2Marquent2Points() {
		
		setterScores(2,2);
		assertEquals("Thirty-All" , this.Win.currentScore());
		
	}

	@Test
	public void testJoueur1Marque3Points() {
		
		setterScores(3,0);
		assertEquals("Forty-Love" , this.Win.currentScore());
		
	}
	
	@Test
	public void testJoueur2Marque3Points() {
		
		setterScores(0,3);
		assertEquals("Love-Forty" , this.Win.currentScore());
		
	}
	
	@Test
	public void testDeuce3Points() {
		
		setterScores(3,3);
		assertEquals("Deuce" , this.Win.currentScore());
		
	}
	
	@Test
	public void testJoueur1Jeu() {
		
		setterScores(4,0);
		assertEquals("Win for player1" , this.Win.currentScore());
		
	}
	
	@Test
	public void testJoueur2Jeu() {
		
		setterScores(1,4);
		assertEquals("Win for player2" , this.Win.currentScore());
		
	}
	
	@Test
	public void testDeuce4Points() {
		
		setterScores(4,4);
		assertEquals("Deuce" , this.Win.currentScore());
		
	}
	
	@Test
	public void testJoueur1Avantage() {
		
		setterScores(5,4);
		assertEquals("Advantage player1" , this.Win.currentScore());
		
	}
	
	@Test
	public void testJoueur2Avantage() {
		
		setterScores(4,5);
		assertEquals("Advantage player2" , this.Win.currentScore());
		
	}

	@Test
	public void testJoueur1JeuPartieLongue() {
		
		setterScores(52,50);
		assertEquals("Win for player1" , this.Win.currentScore());
		
	}
	
	@Test
	public void testJoueur2JeuPartieLongue() {
		
		setterScores(15,17);
		assertEquals("Win for player2" , this.Win.currentScore());
		
	}
	
	@Test
	public void testDeucePartieLongue() {
		
		setterScores(25,25);
		assertEquals("Deuce" , this.Win.currentScore());
		
	}
	
	@Test
	public void testJoueur1AvantagePartieLongue() {
		
		setterScores(18,17);
		assertEquals("Advantage player1" , this.Win.currentScore());
		
	}
	
	@Test
	public void testJoueur2AvantagePartieLongue() {
		
		setterScores(25,26);
		assertEquals("Advantage player2" , this.Win.currentScore());
		
	}
}
