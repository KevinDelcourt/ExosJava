package Version3;

import java.util.Iterator;
import java.util.Vector;

public abstract class Situation {
	
	private Vector locations;
	
	public Situation(Vector locations) {
		this.locations = locations;
	}
	
	public String situation(String nomClient) {
		String result = miseEnFormeEnTete(nomClient);
		
		Iterator forEach = locations.iterator();
		while (forEach.hasNext()) {
			Location each = (Location) forEach.next();
						
			result += miseEnFormeLocation(each);
		}
		
		result += miseEnFormeRecapClient();
		
		return result;
	}

	protected abstract String miseEnFormeRecapClient();
	
	protected abstract String miseEnFormeLocation(Location location);

	protected abstract String miseEnFormeEnTete(String nomClient);
	
	protected double getMontantTotal() {
		double totalDu = 0;
		Iterator forEach = locations.iterator();
		while (forEach.hasNext()) {
			Location each = (Location) forEach.next();
			totalDu += each.getFilm().getPrix().getMontant(each);
		}
		return totalDu;
	}
	
	protected int getPointsFideliteTotal() {
		int pointsFidelites = 0;
		Iterator forEach = locations.iterator();
		while (forEach.hasNext()) {
			Location each = (Location) forEach.next();
						
			pointsFidelites += each.getFilm().getPrix().getPointsFidelite(each);
		}
		return pointsFidelites;
	}
}
