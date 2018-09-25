package primitiveLanguage;

public class Jeu {

	
	public void initialiser(int numjoueur, String nomBateau, int tailleBateau, char lettre, int chiffre, char sens) {
		
		Bateau bateau = new Bateau(nomBateau,tailleBateau);
		
		bateau.placerBateau(lettre, chiffre, sens);
		
	}
}
