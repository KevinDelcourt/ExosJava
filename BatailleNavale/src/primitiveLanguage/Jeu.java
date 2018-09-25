package primitiveLanguage;

public class Jeu {

	private Grille grilleJoueur1;
	private Grille grilleJoueur2;
	
	public void initialiser(int numJoueur, String nomBateau, int tailleBateau, char lettre, int chiffre, char sens) {
		
		Bateau bateau = new Bateau(nomBateau,tailleBateau);
		
		bateau.placerBateau(lettre, chiffre, sens);
		
	}
}
