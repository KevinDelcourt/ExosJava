package expressions_logiques;

public class Implication extends OperandeBinaire {

	public Implication() {
		super("=>");
	}

	@Override
	public boolean isSatisfiable() {
		if(!this.isValid())
			return false;
		
		return !this.operandeGauche.isSatisfiable() || this.operandeDroit.isSatisfiable();
	}


}
