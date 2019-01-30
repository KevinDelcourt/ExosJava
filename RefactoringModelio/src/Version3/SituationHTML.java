package Version3;

import java.util.Vector;

public class SituationHTML extends Situation{
	public SituationHTML(Vector locations) {
		super(locations);
	}

	protected String miseEnFormeEnTete(String nomClient) {
		return "<h1>Situation du client: " + nomClient + "</h1>";
	}
	
	protected String miseEnFormeLocation(Location location) {
		return "<h3>" + location.getFilm().getTitre() + " : " + String.valueOf(location.getFilm().getPrix().getMontant(location)) + "</h3>";
	}
	
	protected String miseEnFormeRecapClient() {
		String result = "<h2>Total du " + String.valueOf(getMontantTotal()) + "</h2>";
		result += "<h3>Vous gagnez " + String.valueOf(getPointsFideliteTotal()) + " points de fidelite</h3>";
		return result;
	}

	
	
}
