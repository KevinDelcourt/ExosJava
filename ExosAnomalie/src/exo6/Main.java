package exo6;

import java.util.Scanner;

public class Main {

	public static void main (String[] args) {
		System.out.println("nombre d'elements du tableau :");
		Scanner sc = new Scanner(System.in);
		int nb = sc.nextInt();
		Tableau tab = new Tableau(nb);
		tab.lireValeurs();
		System.out.println(tab);
		sc.close();
	}

}
