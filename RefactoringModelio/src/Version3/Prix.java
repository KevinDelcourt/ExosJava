package Version3;

public abstract class Prix {
	
	public abstract double getMontant(Location location);
	
	public abstract int getCodePrix();
	
	public int getPointsFidelite(Location location) {
		return 1;
	}

	public static Prix createPrix(int codePrix) {
		switch(codePrix) {
			case Film.NORMAL:
				return new PrixNormal();
			case Film.ENFANT:
				return new PrixEnfant();
			case Film.NOUVEAUTE:
				return new PrixNouveaute();
		}
		return null;
	}
}
