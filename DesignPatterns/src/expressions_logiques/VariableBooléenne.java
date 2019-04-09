package expressions_logiques;

public class VariableBooléenne {

	private boolean valeur;
	private String nomVariable, descriptionVariable;
	
	public VariableBooléenne(String nomVariable, String descriptionVariable) {
		this.nomVariable = nomVariable;
		this.descriptionVariable = descriptionVariable;
		valeur = true;
	}

	public void fixerValeurDeVérité(boolean valeur) {
		this.valeur = valeur;
	}

	public String interprétation() {
		if(valeur)
			return descriptionVariable;
		else
			return "non "+descriptionVariable;
	}

}
