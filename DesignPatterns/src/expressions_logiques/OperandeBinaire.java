package expressions_logiques;

public abstract class OperandeBinaire extends Satisfiable {

	protected String signe;
	
	protected Satisfiable operandeGauche;
	protected Satisfiable operandeDroit;
	
	public OperandeBinaire(String signe) {
		this.signe = signe;
	}
	
	public void setOperandeGauche(Satisfiable satisfiable) {
		this.operandeGauche = satisfiable;
	}

	public void setOperandeDroit(Satisfiable satisfiable) {
		this.operandeDroit = satisfiable;
	}
	
	protected boolean isValid() {
		return this.operandeGauche != null && this.operandeDroit != null;
	}
	
	public String toString() {
		if(!this.isValid())
			return "";
		return "("+this.operandeGauche+this.signe+this.operandeDroit+")";
	}

}
