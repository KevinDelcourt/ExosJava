package exo4;

import java.util.Scanner;
import java.util.InputMismatchException;

public class Entree {

	private int valeur;
	
	private int nbEssais;
	
	public Entree() {
		this.nbEssais = 0;
	}
	
	public int getValeur() {
		return (this.valeur); 
	}
	
	public void lire3Essais() throws Exception {
		Scanner sc = new Scanner(System.in);
		try {
			System.out.println("Entrez un entier : ");
			nbEssais++;
			valeur = sc.nextInt();
		}catch(InputMismatchException e) {
			if(nbEssais >= 3) {
				sc.close();
				throw new Exception();
			}	
			else 
				lire3Essais();	
		}
	}
}
