package Version3;

import java.util.Iterator;
import java.util.Vector;

public class SituationText extends Situation{
	public SituationText(Vector locations) {
		super(locations);
	}
	
	protected String miseEnFormeEnTete(String nomClient) {
		return "Situation du client: " + nomClient + "\n";
	}
	
	protected String miseEnFormeLocation(Location location) {
		return "\t" + location.getFilm().getTitre() + "\t" + String.valueOf(location.getFilm().getPrix().getMontant(location)) + "\n";
	}
	
	protected String miseEnFormeRecapClient() {
		String result = "Total du " + String.valueOf(getMontantTotal()) + "\n";
		result += "Vous gagnez " + String.valueOf(getPointsFideliteTotal()) + " points de fidelite\n";
		return result;
	}

}
