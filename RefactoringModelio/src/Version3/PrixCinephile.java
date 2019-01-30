package Version3;

public class PrixCinephile extends Prix{

	public int getCodePrix() {
		return Film.CINEPHILE;
	}
	
	public double getMontant(Location location) {
		double du = 2;
		if(location.getNbJours() > 1)
			du += (location.getNbJours()-1) * 4;	
		return du;
	}
	
	public int getPointsFidelite(Location location) {
		if (location.getNbJours() <= 1) 
			return 3;
		
		return super.getPointsFidelite(location);
	}
}
