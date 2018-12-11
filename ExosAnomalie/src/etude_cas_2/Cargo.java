package etude_cas_2;

import java.util.ArrayList;
import java.util.List;

public class Cargo {

	private List<Conteneur> chargement;

	public Cargo() {
		this.chargement = new ArrayList<Conteneur>();
	}

	public void charger(Conteneur conteneur) {
		this.chargement.add(conteneur);
	}

	public String toString() {
		int charge = 0;
		for (Conteneur conteneur : this.chargement)
			charge += conteneur.getCharge();
		return 	"\n" + "Nombre de conteneurs : " + this.chargement.size()
				+ "\n" + "Charge du cargo : " + charge;
	}	
}
