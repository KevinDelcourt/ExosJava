package expressions_logiques;

public abstract class OperandeBinaire extends Satisfiable {

	protected Satisfiable operandeGauche;
	protected Satisfiable operandeDroit;
	
	public void setOperandeGauche(Satisfiable satisfiable) {
		this.operandeGauche = satisfiable;
		
	}

	public void setOperandeDroit(Satisfiable satisfiable) {
		this.operandeDroit = satisfiable;
	}


}
