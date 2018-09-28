package primitiveLanguage;

/**
 * @author Kevin
 *
 */
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
	
	
	/** Retourne un tableau de chaines de caractere avec la liste des noms de bateaux
	 * @return String[] la liste de noms
	 */
	public String[] nomsBateaux() {		
		
		return EnumNomBateau.enumToArray();
		
	}
	
	
	/** Retourne le nombre d'éléments du bateau à partir de son nom
	 * @param nomBateau le nom du bateau
	 * @return int le nombre d'elements
	 */
	public int nbElementBateau(String nomBateau) {
		
		int nbElement = 0;
		
		switch( EnumNomBateau.stringToEnum(nomBateau) ) {
			case PORTE_AVION:
				nbElement = 5;
				break;
			case CROISEUR:
				nbElement = 4;
				break;
			case TORPILLEUR:
				nbElement = 3;
				break;
			case CONTRE_TORPILLEUR:
				nbElement = 2;
				break;
			case SOUS_MARIN:
				nbElement = 3;
				break;
			default :
				System.out.println("Erreur de reconnaissance de nom du bateau");
		}
		
		return nbElement;
	}
	
	/** vrai si une des flottes a coulé, faux sinon
	 * 
	 * @return boolean vrai si la partie est finie
	 */
	public boolean finDuJeu() {
		
		return (grille1.flotteCoulee() || grille2.flotteCoulee());
		
	}
	
	/** Jouer un coup, retourne l'information du résultat à afficher
	 * 
	 * @param joueur numéro du joueur
	 * @param lettre coordonnee 1
	 * @param chiffre coordonnee 2
	 * @return texte du resultat
	 */
	public String jouer(int joueur, char lettre, int chiffre) {
		char resultat;
		if (joueur == 1) {
			resultat = grille2.jouerCoup(lettre, chiffre);
		} else {
			resultat = grille1.jouerCoup(lettre, chiffre);
		}
		if (resultat == 'C')
			return "Bateau coule";
		else if (resultat == 'T')
			return "Bateau touche";
		else
			return "A l'eau";
	}
	
	/** Affiche l'element de la grille d'un joueur (avec toutes les infos)
	 * @param joueur le numero du joueur
	 * @param lettre coordonnee 1
	 * @param chiffre coordonnee 2
	 * @return le caractere à afficher
	 */
	public char affichageElementGrilleCoteJoueur(int joueur, char 
			lettre, int chiffre) {
		if (joueur == 1)
			return grille1.visualisationCaseGrille(lettre, chiffre);
		else
			return grille2.visualisationCaseGrille(lettre, chiffre);
	}


	/** Affiche l'element de la grille de l'adversaire (en masquant les bateaux sain)
	 * @param joueur le numero du joueur
	 * @param lettre coordonnee 1
	 * @param chiffre coordonnee 2
	 * @return le caractere à afficher
	 */
	public char affichageElementGrilleCoteAdversaire(int joueur, char 
			lettre, int chiffre) {
		char visualisationElement;
		if (joueur == 1)
			visualisationElement = grille1.visualisationCaseGrille(
					lettre, chiffre);
		else
			visualisationElement = grille2.visualisationCaseGrille(
					lettre, chiffre);
		if (visualisationElement == 'S')
			return '_';
		else
			return visualisationElement;
	}
}
