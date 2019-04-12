package expressions_logiques;

public class And extends OperandeBinaire {

	public And() {
		super(".");
	}

	public boolean isSatisfiable() {
		if(!super.isValid())
			return false;
		
		return this.operandeGauche.isSatisfiable() && this.operandeDroit.isSatisfiable() ;
	}
	
}
