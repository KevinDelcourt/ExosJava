package etude_cas_2;

import java.util.Scanner;

public class Main {
	
	  public static void main(String[] args) {
		   	Cargo cargo = new Cargo();
		   	Conteneur conteneur = new Conteneur();
		   	Produit produit;
		   	int charge;
		   	Scanner sc = new Scanner(System.in);
		   	System.out.println("Nombre de produits a quai :");
		   	int nbProduits = sc.nextInt();
		   	int nb = 0;
		   	while (nb < nbProduits) {
		   		System.out.println("Charge du produit :");
		   		charge = sc.nextInt();
		   		if (conteneur.getCharge() + charge <= Conteneur.CHARGE_UTILE) {
		   			// ajouter le produit dans le conteneur courant
		   			produit = new Produit(charge);
		   			conteneur.ajouter(produit);
		   		} else {
		   			// charger le conteneur courant dans le cargo 
		   			// et passer au conteneur suivant
		   			System.out.println(conteneur);
		   			cargo.charger(conteneur);
		   			conteneur = new Conteneur();
		   			produit = new Produit(charge);
		   			conteneur.ajouter(produit);
		   		}
		   		nb++;
		   	}
		   	// charger le dernier conteneur dans le cargo
		   	if (nbProduits != 0) {
				System.out.println(conteneur);
				cargo.charger(conteneur);
		   	}
		   	// afficher le contenu du cargo
		   	System.out.println(cargo);
		   	sc.close();
	  }

}

