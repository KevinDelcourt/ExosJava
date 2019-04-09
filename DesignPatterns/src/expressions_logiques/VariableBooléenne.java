package expressions_logiques;

public class VariableBool�enne extends Satisfiable {

	private boolean valeur;
	private String nomVariable, descriptionVariable;
	
	public VariableBool�enne(String nomVariable, String descriptionVariable) {
		this.nomVariable = nomVariable;
		this.descriptionVariable = descriptionVariable;
		this.valeur = true;
	}

	public void fixerValeurDeV�rit�(boolean valeur) {
		this.valeur = valeur;
	}

	public String interpr�tation() {
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
