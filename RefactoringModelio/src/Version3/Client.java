package Version3;
import java.util.Vector;
import java.util.Iterator;

public class Client {
	private String nom;
	private Vector locations = new Vector();
	
	public Client(String nom) {
		this.nom = nom;
	}
	
	public void addLocation(Location location) {
		this.locations.add(location);
	}
	
	public String getNom() {
		return this.nom;
	}
	
	public String situation() {		
		String result = "Situation du client: " + getNom() + "\n";
		
		Iterator forEach = locations.iterator();
		while (forEach.hasNext()) {
			Location each = (Location) forEach.next();
						
			result += "\t" + each.getFilm().getTitre() + "\t" + String.valueOf(each.getMontant()) + "\n";
		}
		
		// ajout r�capitulatif client
		result += "Total du " + String.valueOf(getMontantTotal()) + "\n";
		result += "Vous gagnez " + String.valueOf(getPointsFideliteTotal()) + " points de fidelite\n";
		
		return result;
	}

	private double getMontantTotal() {
		double totalDu = 0;
		Iterator forEach = locations.iterator();
		while (forEach.hasNext()) {
			Location each = (Location) forEach.next();
			totalDu += each.getMontant();
		}
		return totalDu;
	}

	private int getPointsFideliteTotal() {
		int pointsFidelites = 0;
		Iterator forEach = locations.iterator();
		while (forEach.hasNext()) {
			Location each = (Location) forEach.next();
						
			pointsFidelites += each.getPointsFidelite();
			
		}
		return pointsFidelites;
	}

}