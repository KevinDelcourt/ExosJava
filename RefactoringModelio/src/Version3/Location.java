package Version3;

public class Location {
	private Film unFilm;
	private int nbJours;
	
	public Location(Film unFilm, int nbJours) {
		this.unFilm = unFilm;
		this.nbJours = nbJours;
	}

	public int getNbJours() {
		return this.nbJours;
	}

	public Film getFilm() {
		return this.unFilm;
	}

	public double getMontant() {
		double montantLocation = 0;
		switch (getFilm().getCodePrix()) {
		case Film.NORMAL:
			montantLocation += 2;
			if (getNbJours() > 2) 
				montantLocation += (getNbJours() - 2) * 1.5;
			break;
		case Film.NOUVEAUTE:
			montantLocation += getNbJours() * 3;
			break;
		case Film.ENFANT:
			montantLocation += 1.5;
			if (getNbJours() > 3)
				montantLocation += (getNbJours() - 3) * 1.5;
			break;
		}
		return montantLocation;
	}

	public int getPointsFidelite() {
		int pointsFidelites = 1;
		
		if ((getFilm().getCodePrix() == Film.NOUVEAUTE) && getNbJours() > 1) 
			pointsFidelites++;
		
		return pointsFidelites;
	}
	
}