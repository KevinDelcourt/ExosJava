package Version3;

public class PrixCoffret extends Prix{

	public int getCodePrix() {
		return Film.COFFRET_SERIES_TV;
	}
	
	public double getMontant(Location location) {
		return location.getNbJours() * 0.5;	
	}
	
	public int getPointsFidelite(Location location) {
		return 0;
	}
}
