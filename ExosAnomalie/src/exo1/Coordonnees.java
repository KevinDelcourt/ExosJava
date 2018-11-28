package exo1;

import java.util.Scanner;

/**
 * Code de retour
 *
 */
public class Coordonnees {

	private static final int N = 10;
	private static final int M = 10;
	
	public static Couple<Integer, Integer> lireCoordonnees(Scanner entree) {
		Couple<Integer,Boolean> coupleLigne;
		do 
			coupleLigne = lireNumeroLigne(entree);
		while( !coupleLigne.getSecond() );
		
		Couple<Integer,Boolean> coupleColonne;
		do 
			coupleColonne = lireNumeroColonne(entree);
		while( !coupleColonne.getSecond() );
		
		return new Couple<Integer,Integer>(coupleLigne.getPremier(),coupleColonne.getPremier());
	}
	
	private static Couple<Integer, Boolean> lireNumeroLigne(Scanner entree) {
		System.out.println("Numero de ligne entre 1 et "+N+" :");
		int ligne = entree.nextInt();
			
		boolean valide = ligne <= N && ligne > 0;
		
		return new Couple<Integer,Boolean>(ligne,valide);
	}
	
	private static Couple<Integer, Boolean> lireNumeroColonne(Scanner entree) {
		System.out.println("Numero de colonne entre 1 et "+M+" :");
		int colonne = entree.nextInt();

		boolean valide = colonne <= M && colonne > 0;
		
		return new Couple<Integer,Boolean>(colonne,valide);
	}
	
}
