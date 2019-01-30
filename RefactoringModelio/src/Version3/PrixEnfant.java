package Version3;

public class PrixEnfant extends Prix{

	public int getCodePrix() {
		return Film.ENFANT;
	}
	
	public double getMontant(Location location) {
		double montant = 1.5;
		if (location.getNbJours() > 3) 
			montant += (location.getNbJours() - 3) * 1.5;
		return montant;
		
	}
}
