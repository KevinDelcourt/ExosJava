package expressions_logiques;

public class Or extends OperandeBinaire {

	public Or() {
		super("+");
	}

	public boolean isSatisfiable() {
		if(!super.isValid())
			return false;
		
		return this.operandeGauche.isSatisfiable() || this.operandeDroit.isSatisfiable() ;
	}
}
