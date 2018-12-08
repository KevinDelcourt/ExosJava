package exo6;

import java.util.Scanner;

public class Tableau {
	
	private int[] tab;
	private int n;
	
	public Tableau(int N) {
		this.tab = new int[N];
		this.n = 0;
	}

	// lit une suite de valeurs terminee par un marqueur de fin
	// et les charge dans un tableau tab d’au plus N elements
	// edite aussi dans n le nombre de valeurs chargees dans tab
	public void lireValeurs() {
		
		int marqueur;
		int valeur;
		Scanner sc = new Scanner(System.in);
		System.out.println("valeur du marqueur de fin :");
		marqueur = sc.nextInt();
		
		System.out.println("Entrez des valeur ou le marqueur de fin: ");
		valeur = sc.nextInt();
		while(valeur != marqueur && this.n < this.tab.length){
			this.ajouterValeur(valeur);
			valeur = sc.nextInt(); 
		}
		
		while(valeur != marqueur) 
			valeur = sc.nextInt();
		
	}
	
	// insere la valeur v dans le tableau tab au rang n
	// entraine this.n' == this.n + 1 et this.tab'[this.n] == v
	private void ajouterValeur(int v) {
		assert 0 <= this.n && this.n < this.tab.length:"Débordement du tableau:";//Activer assert dans les prefs d'eclipse
		
		this.tab[n] = v;
		this.n++;
		
	}
	
	
	// fournit les valeurs lues du tableau tab
	public String toString() {
		String res = "";
		for (int i = 0; i < this.n; i++)
			res += "tab[" + i + "] = " + tab[i] + "\n";	
		return res;
	}
	
}
