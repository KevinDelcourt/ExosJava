package Version2;
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
		double totalDu = 0;
		int pointsFidelites = 0;
		Iterator forEach = locations.iterator();
		String result = "Situation du client: " + getNom() + "\n";
		
		while (forEach.hasNext()) {
			double du = 0;
			Location each = (Location) forEach.next();
			
			//determine le montant de chaque location
			switch (each.getFilm().getCodePrix()) {
			case Film.NORMAL:
				du += 2;
				if (each.getNbJours() > 2) 
					du += (each.getNbJours() - 2) * 1.5;
				break;
			case Film.NOUVEAUTE:
				du += each.getNbJours() * 3;
				break;
			case Film.ENFANT:
				du += 1.5;
				if (each.getNbJours() > 3)
					du += (each.getNbJours() - 3) * 1.5;
				break;
			case Film.COFFRET_SERIES_TV:
				du += each.getNbJours() * 0.5;
				break;
			case Film.CINEPHILE:
				du += 2;
				if (each.getNbJours() > 1)
					du += (each.getNbJours() - 1) * 4;
				break;
			}
			
			// ajout des points de fid�lit� sauf pour les coffrets series
			if((each.getFilm().getCodePrix() != Film.COFFRET_SERIES_TV))
				pointsFidelites++;
			// ajout d'un bonus pour les nouveaut�s lou�es depuis au moins deux jours
			if ((each.getFilm().getCodePrix() == Film.NOUVEAUTE) && each.getNbJours() > 1) 
				pointsFidelites++;
			
			//Ajout de 2 points pour la categorie cinephile louée depuis 1 jour
			if ((each.getFilm().getCodePrix() == Film.CINEPHILE) && each.getNbJours() <= 1) 
				pointsFidelites += 2;
			
			// mise en forme location
			result += "\t" + each.getFilm().getTitre() + "\t" + String.valueOf(du) + "\n";
			totalDu += du;
		}
		
		// ajout r�capitulatif client
		result += "Total du " + String.valueOf(totalDu) + "\n";
		result += "Vous gagnez " + String.valueOf(pointsFidelites) + " points de fidelite\n";
		
		return result;
	}
	
	public String situationHTML() {
		double totalDu = 0;
		int pointsFidelites = 0;
		Iterator forEach = locations.iterator();
		String result = "<h1>Situation du client: " + getNom() + "</h1>";
		
		while (forEach.hasNext()) {
			double du = 0;
			Location each = (Location) forEach.next();
			
			//determine le montant de chaque location
			switch (each.getFilm().getCodePrix()) {
			case Film.NORMAL:
				du += 2;
				if (each.getNbJours() > 2) 
					du += (each.getNbJours() - 2) * 1.5;
				break;
			case Film.NOUVEAUTE:
				du += each.getNbJours() * 3;
				break;
			case Film.ENFANT:
				du += 1.5;
				if (each.getNbJours() > 3)
					du += (each.getNbJours() - 3) * 1.5;
				break;
			case Film.COFFRET_SERIES_TV:
				du += each.getNbJours() * 0.5;
				break;
			case Film.CINEPHILE:
				du += 2;
				if (each.getNbJours() > 1)
					du += (each.getNbJours() - 1) * 4;
				break;
			}
			
			// ajout des points de fid�lit� sauf pour les coffrets series
			if((each.getFilm().getCodePrix() != Film.COFFRET_SERIES_TV))
				pointsFidelites++;
			// ajout d'un bonus pour les nouveaut�s lou�es depuis au moins deux jours
			if ((each.getFilm().getCodePrix() == Film.NOUVEAUTE) && each.getNbJours() > 1) 
				pointsFidelites++;
			
			//Ajout de 2 points pour la categorie cinephile louée depuis 1 jour
			if ((each.getFilm().getCodePrix() == Film.CINEPHILE) && each.getNbJours() <= 1) 
				pointsFidelites += 2;
			
			// mise en forme location
			result += "<h3>" + each.getFilm().getTitre() + " : " + String.valueOf(du) + "</h3>";
			totalDu += du;
		}
		
		// ajout r�capitulatif client
		result += "<h2>Total du " + String.valueOf(totalDu) + "</h2>";
		result += "<h3>Vous gagnez " + String.valueOf(pointsFidelites) + " points de fidelite</h3>";
		
		return result;
	}

}