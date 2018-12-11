package etude_cas_1;

public class CoffreFort {
	
	private int montant;
	
	// attribue a un client un des coffres-forts de la banque
	public CoffreFort() {
		this.montant = 0;
	}

	// fournit le montant du coffre-fort
	public int getMontant() {
		return this.montant;
	}

	// depose une valeur v dans le coffre-fort
	public void deposer(int v) {
		this.montant += v;
	}

	// retire une valeur v du coffre-fort
	// nécessite v >= this.montant
	// entraine this.montant' = this.montant - v && this.montant' >= 0
	public void retirer(int v) {
		assert v >= this.montant;
		this.montant -= v;
	}
	
	// vide le contenu du coffre-fort
	 public void vider() {
		 this.montant = 0;
	 }

}
