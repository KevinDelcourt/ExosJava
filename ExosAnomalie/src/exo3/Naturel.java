package exo3;

public class Naturel {
	
	private int valeur;
	
	public Naturel(int valeur) throws ConstraintError {
		this.setValeur(valeur);
	}

	public int getValeur() {
		return (this.valeur); 
	}
	
	public void setValeur(int valeur) throws ConstraintError {
		if (valeur < 0)
			throw new ConstraintError();
		this.valeur = valeur;
	}
	
	public void moinsUn() throws ConstraintError {
		this.setValeur(this.valeur - 1);
	}
	
}
