package expressions_logiques;

public class VariableBool�enne {

	private boolean valeur;
	private String nomVariable, descriptionVariable;
	
	public VariableBool�enne(String nomVariable, String descriptionVariable) {
		this.nomVariable = nomVariable;
		this.descriptionVariable = descriptionVariable;
		valeur = true;
	}

	public void fixerValeurDeV�rit�(boolean valeur) {
		this.valeur = valeur;
	}

	public String interpr�tation() {
		if(valeur)
			return descriptionVariable;
		else
			return "non "+descriptionVariable;
	}

}
