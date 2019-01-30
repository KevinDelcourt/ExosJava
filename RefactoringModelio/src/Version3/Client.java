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
	
	public Vector getLocations() {
		return this.locations;
	}
	
	public String getNom() {
		return this.nom;
	}
	
	public String situation() {		
		return new SituationText(locations).situation(getNom());
	}
	
	public String situationHTML() {
		return new SituationHTML(locations).situation(getNom());
	}

}