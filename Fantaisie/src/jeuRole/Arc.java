package jeuRole;

public class Arc extends Arme {

	private int nbrFleche;
	
	public Arc(int nbrFleche) {
		super("arc",30);
		this.nbrFleche = nbrFleche;
	}
	
	public void attaque(Dragon dragon) {
		
		if(nbrFleche > 0) {
			super.attaque(dragon);
			nbrFleche--;
		}else {
			System.out.print("Malheureusement, " + getProprietaire().getNom() + " ne possaidait plus de fleches.");
		}
		
		
		
	}
}
