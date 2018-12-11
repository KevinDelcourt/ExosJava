package etude_cas_1;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		CoffreFort cf = new CoffreFort();
		cf.deposer(1000);
		effectuerRetraits(cf);
	}
	
	// effectue les retraits correspondants à la suite v0 v1 v2 ... vn v0
	private static void effectuerRetraits(CoffreFort cf) {
		int marqueur;
		int v;
		Scanner sc = new Scanner(System.in);
		System.out.println("valeur du marqueur de fin :");
		marqueur = sc.nextInt();
		System.out.println("montant du coffre-fort : " + cf.getMontant());
		System.out.println("montant du retrait :");
		v = sc.nextInt();
		while (v != marqueur ) {
			if(cf.retirer(v)) {
				System.out.println("montant du coffre-fort : " + cf.getMontant());
				System.out.println("montant du retrait :");
				v = sc.nextInt();
			}
			else
				System.out.println("Retrait impossible");
				
		}
		System.out.println("montant final du coffre-fort : " + cf.getMontant());
		sc.close();
	}

}
