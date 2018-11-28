package exo1;

import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner entree = new Scanner(System.in);
		Couple <Integer, Integer> c = Coordonnees.lireCoordonnees(entree);
		System.out.println ("numero de ligne = " + c.getPremier());
		System.out.println ("numero de colonne = " + c.getSecond());
		entree.close();
	}
	
}
