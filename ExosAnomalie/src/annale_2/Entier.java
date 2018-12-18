package annale_2;

public class Entier extends Expression {

	private static int nbEntiers = 0;
	private int valeur;
	
	public Entier(int valeur) {
		this.valeur = valeur;
		nbEntiers++;
	}
	
	public int évaluer() {
		return this.valeur;
	}
	
	public static int getNbEntiers() {
		return nbEntiers;
	}

}
