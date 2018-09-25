package primitiveLanguage;

import java.util.Scanner;

public class Jeu {

	//initialise le tableau avec des cases vides
	static String[] creationGrille() {
		String[] tableau = new String[9];
		
		for(int i = 0; i < tableau.length ; i++) {
			tableau[i] = " |";	
		}
		
		return tableau;
	}
	
	//affiche le tableau
	static void afficherTableau(String[] tableau) {
		
		System.out.print("\n|");
		for(int i = 0; i < tableau.length; i++) {
			
			System.out.print(tableau[i]);
			
			if(i == 2 || i == 5) {
				System.out.println("\n-------");
				System.out.print("|");
			}
		}
		System.out.print("\n");
		
	}
	
	//Joue la marque d'un joueur aux coordonnées indiquées
	static void entrerCoordonnee(boolean joueurO, String[] tableau, int ligne, int colonne) {
		
		int cooCase = 0;
		String marque = "X|";
		
		switch (ligne) {
			case 1:
				cooCase = colonne -1;
				break;
			case 2:
				cooCase = colonne +2;
				break;
			case 3:
				cooCase = colonne +5;
				break;
		}
		
		if(joueurO) {
			marque = "O|";
		}
		
		tableau[cooCase] = marque;
		
		System.out.println("\nJoueur |"+marque+" a joué la case ("+ligne+","+colonne+")");
	}
	
	//Lire un entier rentré par l'utilisateur
	static int lireEntier() {
		Scanner clavier = new Scanner(System.in);
		int chiffre = clavier.nextInt();
		return chiffre;
	}
	
	
	//Regarde si une case aux coordonnées indiquées est vide, utilisée, ou si les coordonnées sont hors tableau
	static String isCaseValide(String[] tableau, int ligne, int colonne) {
		
		//Cas case hors tableau
		if(ligne > 3 || ligne < 1 || colonne > 3 || colonne < 1) {
			
			return "Hors tableau";
			
		}else if( tableau[(ligne-1)*3 + (colonne-1)] == " |"){//Cas case vide
			
			return "OK";
			
		}else {//Case déjà utilisée
			
			return "Case déjà utilisée";
			
		}
		
	}
	
	//Demande à l'utilisateur de saisir les coordonnées d'une case à jouer jusqu'à ce que les coordonnées soient valides. Puis joue.
	static void jouerUneCase(String[] tableau, boolean joueurO) {
		
		String caseValide = "";
		int ligne = 0;
		int colonne = 0;
		
		do {
			
			System.out.println("\nSaisir ligne :");
			ligne = lireEntier();
			
			System.out.println("Saisir colonne :");
			colonne = lireEntier();
			
			caseValide = isCaseValide(tableau, ligne, colonne);
			
			System.out.println("Case("+ligne+","+colonne+") : " + caseValide);
			
		} while( caseValide != "OK" );
		
		entrerCoordonnee(joueurO, tableau, ligne, colonne);
		
	}
	
	//Création d'un tableau de booléen, à true si la marque est présente dans le tableau, faux sinon.
	static boolean[] creationTableauVerif( String[] tableau, String marque) {
		
		boolean[] tableauVerif = new boolean[9];
		
		for(int i = 0; i < tableau.length; i++) {
			
			tableauVerif[i] = (tableau[i] == marque);
			
		}
		
		return tableauVerif;
	}
	
	//Regarde si un joueur a gagné, à partir du tableau de vérif
	static boolean controlTableauVerif( boolean[] tableauVerif) {
		
		boolean gagne = false;
		
		//Sans doute pas la bonne méthode
		/*gagne = (tableauVerif[0] && tableauVerif[4] && tableauVerif[8])|| //Diagonale 1
				(tableauVerif[2] && tableauVerif[4] && tableauVerif[6])|| //Diagonale 2
				(tableauVerif[0] && tableauVerif[1] && tableauVerif[2])|| //l1
				(tableauVerif[3] && tableauVerif[4] && tableauVerif[5])|| //l2
				(tableauVerif[6] && tableauVerif[7] && tableauVerif[8])|| //l3
				(tableauVerif[0] && tableauVerif[3] && tableauVerif[6])|| //c1
				(tableauVerif[1] && tableauVerif[4] && tableauVerif[7])|| //c2
				(tableauVerif[2] && tableauVerif[5] && tableauVerif[8]); //c3*/
		
		//Test diagonale 1
		gagne = (tableauVerif[0] && tableauVerif[4] && tableauVerif[8]); 
		
		//Test diagonale 2
		gagne = gagne || (tableauVerif[2] && tableauVerif[4] && tableauVerif[6]);
		
		//test des lignes/colonnes
		for( int i = 0; i < 3; i++ ) {
			
			//Test ligne i 			
			gagne = gagne || (tableauVerif[i*3] && tableauVerif[i*3 + 1] && tableauVerif[i*3 + 2] );
			
			//test colonne i			
			gagne = gagne || (tableauVerif[i] && tableauVerif[i + 3] && tableauVerif[i + 6] );
			
		}
		
		return gagne;
	}
	
	//Regarde si un joueur a gagné ou si toutes les cases sont pleines (match nul)
	static boolean isPartieFinie( String[] tableau ) {
		
		boolean fin = true;
		
		//On regarde si il y a une case vide
		for(int i = 0; i < tableau.length; i++) {
			
			fin = fin && ( tableau[i] != " |");
					
		}
		
		//On regarde si un des 2 joueurs a gagné
		if(!fin) {
			boolean[] tabVerifO = creationTableauVerif(tableau,"O|");
			boolean[] tabVerifX = creationTableauVerif(tableau,"X|");
			
			fin = controlTableauVerif(tabVerifO) ||  controlTableauVerif(tabVerifX);
		}
		
		return fin;
	}
	
	//joue la partie, tour à tour jusqu'à la fin de la partie
	static void jouerPartie() {
		
		boolean joueurO = false;
		
		String[] tableau = creationGrille();
		
		System.out.println("\n--------- Début de partie ---------");
		do { 
			//Un tour de jeu
			joueurO = !joueurO;
			
			String marque = "X|";
			if(joueurO) {
				marque = "O|";
			}
			
			System.out.println("\n--- Tour du joueur |"+ marque +" ---");
			
			afficherTableau(tableau);
			
			jouerUneCase(tableau, joueurO);
			
		} while( !isPartieFinie(tableau) );
		
		System.out.println("\n--------- Partie finie ---------");
		afficherTableau(tableau);
		
		
	}
	
	public static void main(String[] args) {
		
		
		/*System.out.println("Jeu du Morpion");
		
		String[] tableau = creationGrille();
				
		
		afficherTableau(tableau);
		
		System.out.println("\n\n----------- EXO1 - Test affichage tableau -----------");
		
		entrerCoordonnee(true, tableau, 1, 1);
		entrerCoordonnee(false, tableau, 3, 3);
		
		afficherTableau(tableau);
		
		
		//EXO 2 - Le joueur O joue un coup
		System.out.println("\n\n----------- EXO2 - Test jeu joueur |O| -----------\n");
		
		System.out.print("\nSaisir une ligne: ");
		int ligne = lireEntier();
		System.out.print("\nSaisir une colonne : ");
		int colonne = lireEntier();
		
		entrerCoordonnee(true, tableau, ligne, colonne);
		afficherTableau(tableau);
		
		//EXO 3
		System.out.println("\n\n----------- EXO3 - Test méthode isCaseValide() ------------\n");
		
		afficherTableau(tableau);
		
		System.out.println("\nCase(1,1) : " + isCaseValide(tableau,1,1) );
		System.out.println("Case(7,3) : " + isCaseValide(tableau,7,3));
		System.out.println("Case(2,2) : " + isCaseValide(tableau,2,2));
		
		//EXO 4
		System.out.println("\n\n----------- EXO4 - Test fin de partie ------------\n");
		
		//entrerCoordonnee(true, tableau, 1, 1);
		//entrerCoordonnee(true, tableau, 3, 3);
		//entrerCoordonnee(true, tableau, 2, 2);
		//entrerCoordonnee(false, tableau, 1, 3);
		//entrerCoordonnee(false, tableau, 2, 2);
		//entrerCoordonnee(false, tableau, 3, 1);
		//entrerCoordonnee(true, tableau, 3, 1);
		//entrerCoordonnee(true, tableau, 3, 2);
		//entrerCoordonnee(true, tableau, 3, 3);
		
		afficherTableau(tableau);
		
		System.out.println("\nPartie finie ? " + isPartieFinie(tableau) );*/
		
		//EXO 5
		jouerPartie();
	}

}
