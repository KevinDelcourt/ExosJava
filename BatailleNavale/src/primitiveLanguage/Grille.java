package primitiveLanguage;

import java.util.ArrayList;

/** Une grille de jeu
 * @author Kevin
 *
 */
public class Grille {
	
	private int nbBateau = 0;
	private Bateau[] flotte = new Bateau[5];
	
	private ArrayList<int[]> coupJoue = new ArrayList<int[]>();
	
	/** Place un bateau sur la grille
	 * @param bateau le bateau à placer
	 * @param sens H ou V horizontal ou vertical
	 * @param lettre coordonnee 1
	 * @param chiffre coordonnee 2
	 */
	public void placerBateau(Bateau bateau, char sens, char lettre, int chiffre) {
		flotte[nbBateau] = bateau;
		bateau.placerBateau(lettre, chiffre, sens);
		nbBateau++;
	}
	
	/** true si la flotte entiere est coulee false sinon
	 * @return boolean
	 */
	public boolean flotteCoulee() {
		
		boolean resultat = true;
		
		for(int i = 0; i < flotte.length; i++) {
			resultat = resultat && (flotte[i].getEtatBateau() == 'C');
		}
		
		return resultat;
	}
	
	/** Joue un coup sur la grille, retourne le resultat
	 * @param lettre
	 * @param chiffre
	 * @return l'etat du bateau touché ou d'un tir dans l'eau
	 */
	public char jouerCoup(char lettre, int chiffre) {
		char resultat = '0';
		int[] coordonne = new int[2];
		coordonne[0] = lettre;
		coordonne[1] = chiffre;
		coupJoue.add(coordonne);
		for (int i = 0; i < nbBateau; i++) {
			if (flotte[i].coup(lettre, chiffre)) {
				resultat = (flotte[i].getEtatBateau());
			}
		}
		return resultat;
	}
	
	/** Retourne le caractere d'une case de la grille
	 * @param lettre coordonnee 1
	 * @param chiffre coordonnee 2
	 * @return X pour vide, S our bateau sain, T pour touché, C pour coulé
	 */
	public char visualisationCaseGrille(char lettre, int chiffre) {
		char element = 'X';
		
		for (int i = 0; i < nbBateau; i++) 
			if( flotte[i].appartientBateau(lettre, chiffre)  ) {
				element = flotte[i].getEtatElement(lettre, chiffre);
			}
		
		return element;
	}
}
