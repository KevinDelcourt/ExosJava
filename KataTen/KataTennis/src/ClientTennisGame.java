
public class ClientTennisGame {

	
	public static void main(String[] args) {
		
		//--------- tests marquage de points de base j1 ---------
		
		//test 1 pt j1
		TennisGame partie = new TennisGame();
		partie.player1Scores();//0 - 15
		System.out.println("\nTest J1 marque 1x :\n" + partie.currentScore());
		
		//test 2 pt j1
		partie = new TennisGame();
		partie.player1Scores();
		partie.player1Scores();//30 - 0
		System.out.println("\nTest J1 marque 2x :\n" + partie.currentScore());
		
		//test 3 pt j1
		partie = new TennisGame();
		partie.player1Scores();
		partie.player1Scores();
		partie.player1Scores();//40 - 0
		System.out.println("\nTest J1 marque 3x :\n" + partie.currentScore());
		
		//test victoire joueur 1 - 45 - 0
		partie = new TennisGame();
		partie.player1Scores();
		partie.player1Scores();
		partie.player1Scores();
		partie.player1Scores();//Jeu
		System.out.println("\nTest victoire joueur 1 :\n" + partie.currentScore());
		
		//--------- tests marquage de points de base j2 ---------
		
		//test 1 pt j2
		partie = new TennisGame();
		partie.player2Scores();//0 - 15
		System.out.println("\nTest J2 marque 1x :\n" + partie.currentScore());
		
		//test 2 pt j2
		partie = new TennisGame();
		partie.player2Scores();
		partie.player2Scores();//0 - 30
		System.out.println("\nTest J2 marque 2x :\n" + partie.currentScore());
		
		//test 3 pt j2
		partie = new TennisGame();
		partie.player2Scores();
		partie.player2Scores();
		partie.player2Scores();//0 - 40
		System.out.println("\nTest J2 marque 3x :\n" + partie.currentScore());
		
		//test victoire joueur 2 - 0 - 45
		partie = new TennisGame();
		partie.player2Scores();
		partie.player2Scores();
		partie.player2Scores();
		partie.player2Scores();//Jeu
		System.out.println("\nTest victoire joueur 2 :\n" + partie.currentScore());
		
		//------------ tests marquage j1 et j2 ------------
		
		//Test 15 - 15
		partie = new TennisGame();
		partie.player1Scores();
		partie.player2Scores();
		System.out.println("\nTest 15 - 15 :\n" + partie.currentScore());
		
		//Test 30 - 15
		partie = new TennisGame();
		partie.player1Scores();
		partie.player1Scores();
		partie.player2Scores();
		System.out.println("\nTest 30 - 15 :\n" + partie.currentScore());
		
		//Test 15 - 30
		partie = new TennisGame();
		partie.player1Scores();
		partie.player2Scores();
		partie.player2Scores();
		System.out.println("\nTest 15 - 30 :\n" + partie.currentScore());
		
		//Test 30 - 30
		partie = new TennisGame();
		partie.player1Scores();
		partie.player1Scores();
		partie.player2Scores();
		partie.player2Scores();
		System.out.println("\nTest 30 - 30 :\n" + partie.currentScore());
		
		//Test 40 - 15
		partie = new TennisGame();
		partie.player1Scores();
		partie.player1Scores();
		partie.player1Scores();
		partie.player2Scores();
		System.out.println("\nTest 40 - 15 :\n" + partie.currentScore());
		
		//Test 15 - 40
		partie = new TennisGame();
		partie.player2Scores();
		partie.player1Scores();
		partie.player2Scores();
		partie.player2Scores();
		System.out.println("\nTest 15 - 40 :\n" + partie.currentScore());
		
		//Test 30 - 40
		partie = new TennisGame();
		partie.player2Scores();
		partie.player1Scores();
		partie.player1Scores();
		partie.player2Scores();
		partie.player2Scores();
		System.out.println("\nTest 30 - 40 :\n" + partie.currentScore());
		
		//Test 40 - 30
		partie = new TennisGame();
		partie.player2Scores();
		partie.player1Scores();
		partie.player1Scores();
		partie.player1Scores();
		partie.player2Scores();
		System.out.println("\nTest 40 - 30 :\n" + partie.currentScore());
		
		//Test 40 - 40 - deuce
		partie = new TennisGame();
		partie.player2Scores();
		partie.player1Scores();
		partie.player1Scores();
		partie.player1Scores();
		partie.player2Scores();
		partie.player2Scores();
		System.out.println("\nTest Deuce :\n" + partie.currentScore());
		
		//Test 45 - 40 - avantage 1
		partie = new TennisGame();
		partie.player2Scores();
		partie.player1Scores();
		partie.player1Scores();
		partie.player1Scores();
		partie.player1Scores();
		partie.player2Scores();
		partie.player2Scores();
		System.out.println("\nTest Avantage 1 :\n" + partie.currentScore());
		
		//Test 40 - 45 - avantage 2
		partie = new TennisGame();
		partie.player2Scores();
		partie.player1Scores();
		partie.player1Scores();
		partie.player1Scores();
		partie.player2Scores();
		partie.player2Scores();
		partie.player2Scores();
		System.out.println("\nTest Avantage 2 :\n" + partie.currentScore());
		
		//Test 45 - 45 - deuce à 45
		partie = new TennisGame();
		partie.player2Scores();
		partie.player1Scores();
		partie.player1Scores();
		partie.player1Scores();
		partie.player1Scores();
		partie.player2Scores();
		partie.player2Scores();
		partie.player2Scores();
		System.out.println("\nTest Deuce 2 :\n" + partie.currentScore());
		
		//Test victoire après avantage 1
		partie = new TennisGame();
		partie.player2Scores();
		partie.player1Scores();
		partie.player1Scores();
		partie.player1Scores();
		partie.player1Scores();
		partie.player2Scores();
		partie.player2Scores();
		partie.player1Scores();
		System.out.println("\nTest Victoire après Avantage 1 :\n" + partie.currentScore());
		
		//Test victoire après avantage 2
		partie = new TennisGame();
		partie.player2Scores();
		partie.player1Scores();
		partie.player1Scores();
		partie.player1Scores();
		partie.player2Scores();
		partie.player2Scores();
		partie.player2Scores();
		partie.player2Scores();
		System.out.println("\nTest Victoire après Avantage 2 :\n" + partie.currentScore());
		
		//Test: j1 a gagné mais on continue à jouer
		partie = new TennisGame();
		System.out.println("\nTest Jeu continue après victoire : ");
		
		partie.player1Scores();
		partie.player1Scores();
		partie.player1Scores();
		partie.player1Scores(); //victoire j1
		System.out.println("    Victoire j1 : " + partie.currentScore());
		
		partie.player2Scores();
		partie.player2Scores();
		partie.player2Scores();
		partie.player2Scores(); //On revient à égalité
		System.out.println("    j2 marque 4x : " + partie.currentScore());
		
		partie.player2Scores();
		partie.player2Scores(); //j2 repasse devant
		System.out.println("    j2 marque 2x : " + partie.currentScore());
		
		partie.player1Scores();
		partie.player1Scores();
		partie.player1Scores();
		partie.player1Scores(); //j1 repasse devant
		System.out.println("    j1 marque 4x : " + partie.currentScore());
		
	}

}
