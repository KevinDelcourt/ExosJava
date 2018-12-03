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
		

	}
	
	// insere la valeur v dans le tableau tab au rang n
	// nécessite que 0 <= this.n <= this.tab.length -1
	// entraine this.n' == this.n + 1 et this.tab'[this.n] == v
	private void ajouterValeur(int v) {
		tab[n] = v;
		n++;
	}
	
	
	// fournit les valeurs lues du tableau tab
	public String toString() {
		String res = "";
		for (int i = 0; i < this.n; i++)
			res += "tab[" + i + "] = " + tab[i] + "\n";	
		return res;
	}
	
}
