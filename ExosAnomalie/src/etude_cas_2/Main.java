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
		   	int nb = 1;
		   	while (nb <= nbProduits) {
		   		for(int n = 0; nb <= nbProduits && n < 3; n++) {
		   			System.out.println("Charge du produit :");
			   		charge = sc.nextInt();
			   		
			   		produit = new Produit(charge);
		   			conteneur.ajouter(produit);
		   			nb++;
		   		}
		   		
		   		for(int n = 0; !conteneur.getValide() && n < 3; n++) 
   					System.out.println("Un produit " + conteneur.enlever() + " reste à quai");
	   				
		   		System.out.println(conteneur);
	   			cargo.charger(conteneur);
		   		conteneur = new Conteneur();
	   			
		   	}
		   			   	
		   	// afficher le contenu du cargo
		   	System.out.println(cargo);
		   	sc.close();
	  }

}

