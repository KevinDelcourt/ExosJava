package etude_cas_2;

import java.util.ArrayList;
import java.util.List;

public class Conteneur {
	
	public static final int CHARGE_UTILE = 100;

	private int charge;

	private List<Produit> contenu;

	public Conteneur() {
		this.charge = 0;
		this.contenu = new ArrayList<Produit>();
	}

	public int getCharge() {
		return this.charge;
	}
	
	public boolean ajouter(Produit produit) {
		if(this.charge + produit.getCharge() > Conteneur.CHARGE_UTILE) {
			return false;
		}
		
		this.charge = this.charge + produit.getCharge();
		this.contenu.add(produit);
		return true;
	}

	public String toString() {
		return 	"\n" + "Nombre de produits : " + this.contenu.size() 
				+ "\n" + "Charge du conteneur : " + this.charge;
	}

}


