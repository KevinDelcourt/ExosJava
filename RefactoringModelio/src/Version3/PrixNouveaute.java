package Version3;

public class PrixNouveaute extends Prix{

	public int getCodePrix() {
		return Film.NOUVEAUTE;
	}
	
	public double getMontant(Location location) {
		return location.getNbJours() * 3;	
	}
	
	public int getPointsFidelite(Location location) {
		if (location.getNbJours() > 1) 
			return 2;
		
		return 1;
	}
}
