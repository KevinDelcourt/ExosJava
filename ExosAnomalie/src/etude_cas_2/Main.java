package etude_cas_2;

import java.util.Scanner;

public class Main {
	
	  public static void main(String[] args) throws ConteneurPlein {
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
		   		
		   		try {
			   		produit = new Produit(charge);
		   			conteneur.ajouter(produit);
		   		}catch(ConteneurPlein cp) {
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

