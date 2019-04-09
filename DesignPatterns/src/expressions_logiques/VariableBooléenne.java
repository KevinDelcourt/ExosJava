package expressions_logiques;

public class VariableBooléenne extends Satisfiable {

	private boolean valeur;
	private String nomVariable, descriptionVariable;
	
	public VariableBooléenne(String nomVariable, String descriptionVariable) {
		this.nomVariable = nomVariable;
		this.descriptionVariable = descriptionVariable;
		this.valeur = true;
	}

	public void fixerValeurDeVérité(boolean valeur) {
		this.valeur = valeur;
	}

	public String interprétation() {
		if(this.valeur)
			return descriptionVariable;
		else
			return "non "+descriptionVariable;
	}

	public boolean isSatisfiable() {
		return this.valeur;
	}

	public String toString() {
		return this.nomVariable;
	}

}
