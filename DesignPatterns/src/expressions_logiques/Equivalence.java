package expressions_logiques;

public class Equivalence extends OperandeBinaire {

	public Equivalence() {
		super("<=>");
	}

	public boolean isSatisfiable() {
		if(!this.isValid())
			return false;
		
		return this.operandeGauche.isSatisfiable() && this.operandeDroit.isSatisfiable() || !this.operandeGauche.isSatisfiable() && !this.operandeDroit.isSatisfiable();
	
	}


}
