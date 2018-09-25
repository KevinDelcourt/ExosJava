package primitiveLanguage;

public class Jeu {

	private Grille grille1 = new Grille();
	private Grille grille2 = new Grille();
	
	
	public void initialiser(int numJoueur, String nomBateau, int tailleBateau, char lettre, int chiffre, char sens) {
		
		Bateau bateau = new Bateau(nomBateau,tailleBateau);
		Grille grille;
		
		if(numJoueur == 1) {
			grille = grille1;
		}else {
			grille = grille2;
		}
		
		grille.placerBateau(bateau, sens, lettre, chiffre);
		
	}
	
	//A finir
	public String[] nomsBateaux() {
		
		String[] noms = {"u","u"};
		
		return noms;
		
	}
	
	//A finir
	public int nbElementBateau(String nomBateau) {
		return 2;
	}
}
