package jeuRole;

public class Arc extends Arme {

	private int nbrFleche;
	
	public Arc(int nbrFleche) {
		super("arc",30);
		this.nbrFleche = nbrFleche;
	}
	
	@Override
	public void attaque(Dragon dragon) {
		
		if(nbrFleche > 0) {
			super.attaque(dragon);
			nbrFleche--;
		}else {
			EntiteLivre.livre.ecrire("Malheureusement, " + getProprietaire().getNom() + " ne possaidait plus de fleches.\n");
		}
		
	}

	public int getNbrFleche() {
		return nbrFleche;
	}

	
}
