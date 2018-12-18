package etude_cas_2;

import java.util.ArrayList;
import java.util.List;

public class Conteneur {
	
	public static final int CHARGE_UTILE = 100;

	private int charge;

	private List<Produit> contenu;
	
	private boolean valide = true;

	public Conteneur() {
		this.charge = 0;
		this.contenu = new ArrayList<Produit>();
	}

	public int getCharge() {
		return this.charge;
	}
	
	public void ajouter(Produit produit){
		
		this.charge = this.charge + produit.getCharge();

		this.valide = this.charge <= Conteneur.CHARGE_UTILE;
		
		this.contenu.add(produit);
	}

	public Produit enlever() {
		
		Produit dernierProduit = contenu.remove(contenu.size() - 1);
		this.charge -= dernierProduit.getCharge();
		
		this.valide = this.charge <= Conteneur.CHARGE_UTILE;
		
		return dernierProduit;
	}
	
	public String toString() {
		return 	"\n" + "Nombre de produits : " + this.contenu.size() 
				+ "\n" + "Charge du conteneur : " + this.charge;
	}
	
	public boolean getValide() {
		return this.valide;
	}

}


