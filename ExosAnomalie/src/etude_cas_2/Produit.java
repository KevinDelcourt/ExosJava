package etude_cas_2;

public class Produit {

	private int charge;

	public Produit(int charge) throws IllegalArgumentException {
		if (charge <= 0 || charge > Conteneur.CHARGE_UTILE)
			throw new IllegalArgumentException();
		this.charge = charge;
	}

	public int getCharge() {
		return this.charge;
	}

	public String toString() {
		return "" + this.charge;
	}
}


