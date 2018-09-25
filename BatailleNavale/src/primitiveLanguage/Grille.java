package primitiveLanguage;

public class Grille {
	
	private int nbBateau;
	private Bateau[] flotte;
	
	
	public void placerBateau(Bateau bateau, char sens, char lettre, int chiffre) {
		bateau.placerBateau(lettre, chiffre, sens);
	}
}
