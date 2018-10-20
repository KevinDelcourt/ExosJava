package primitiveLanguage;

import java.util.ArrayList;

/**
 * Une grille de jeu
 * 
 * @author Kevin
 *
 */
public class Grille {

	private int nbBateau = 0;
	private Bateau[] flotte = new Bateau[5];

	private int nbLigne = 10;
	private int nbColonne = 10;

	private ArrayList<int[]> coupJoue = new ArrayList<>();

	/**
	 * Place un bateau sur la grille
	 * 
	 * @param bateau
	 *            le bateau à placer
	 * @param sens
	 *            H ou V horizontal ou vertical
	 * @param lettre
	 *            coordonnee 1
	 * @param chiffre
	 *            coordonnee 2
	 */
	public void placerBateau(Bateau bateau, char sens, char lettre, int chiffre) {
		flotte[nbBateau] = bateau;
		bateau.placerBateau(lettre, chiffre, sens);
		nbBateau++;
	}

	/**
	 * true si la flotte entiere est coulee false sinon
	 * 
	 * @return boolean
	 */
	public boolean flotteCoulee() {

		boolean resultat = true;

		for (int i = 0; i < flotte.length; i++) {
			resultat = resultat && (flotte[i].getEtatBateau() == 'C');
		}

		return resultat;
	}

	/**
	 * Joue un coup sur la grille, retourne le resultat
	 * 
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

	/**
	 * Retourne le caractere d'une case de la grille
	 * 
	 * @param lettre
	 *            coordonnee 1
	 * @param chiffre
	 *            coordonnee 2
	 * @return X pour vide, S our bateau sain, T pour touché, C pour coulé
	 */
	public char visualisationCaseGrille(char lettre, int chiffre) {
		char element = '_';

		for (int i = 0; i < nbBateau; i++)
			if (flotte[i].appartientBateau(lettre, chiffre)) {
				element = flotte[i].getEtatElement(lettre, chiffre);
			}

		return element;
	}

	/**
	 * Verifie que le bateau en param ne dépasse pas de la grille
	 * 
	 * @param bateau
	 *            à placer
	 * @param sens
	 *            du bateau
	 * @param lettre
	 *            coordonnée 1
	 * @param chiffre
	 *            coordonnée 2
	 * @return boolean - true si le bateau rentre dans la grille
	 */
	public boolean verifierSortieGrille(Bateau bateau, char sens, char lettre, int chiffre) {

		boolean bienPlace = true;

		bienPlace = (chiffre > 0) && (chiffre <= nbLigne) && (lettre > 0) && (lettre <= nbColonne);

		int taille = bateau.getTailleBateau();
		if (sens == 'H') {
			bienPlace = bienPlace && (chiffre + taille > 0) && (chiffre + taille <= nbLigne)
					&& (lettre > 0) && (lettre <= nbColonne);
		} else {
			bienPlace = bienPlace && (chiffre > 0) && (chiffre <= nbLigne) && (lettre + taille > 0)
					&& (lettre + taille <= nbColonne);
		}

		return bienPlace;
	}

	/**
	 * Verifie que le bateau passé en parametre ne chevauche pas un bateau de la
	 * grille
	 * 
	 * @param bateau
	 *            à placer
	 * @param sens
	 *            vertical ou horizontal
	 * @param coordonneeH
	 *            le chiffre
	 * @param coordonneeV
	 *            la lettre (sous forme de chiffre)
	 * @return boolean - true si le placement est possible faux sinon
	 */
	public boolean verifierSuperpositionTableau(Bateau bateau, char sens, int coordonneeH, int coordonneeV) {

		boolean pasSuperpose = true;

		for (int i = 0; i < bateau.getTailleBateau(); i++) 
			for(int j = 0; j < nbBateau; j++) 
				if(sens == 'V') {
					pasSuperpose = pasSuperpose && !flotte[j].appartientBateau( (char)(coordonneeV+i), coordonneeH);
				}else {
					pasSuperpose = pasSuperpose && !flotte[j].appartientBateau( (char)coordonneeV, coordonneeH+i);
				}
		return pasSuperpose;
	}
}
