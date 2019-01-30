package Version3;

public class PrixNormal extends Prix{

	public int getCodePrix() {
		return 0;
	}
	
	public double getMontant(Location location) {
		double montant = 2;
		if (location.getNbJours() > 2) 
			montant += (location.getNbJours() - 2) * 1.5;
		return montant;
	}
	
}
