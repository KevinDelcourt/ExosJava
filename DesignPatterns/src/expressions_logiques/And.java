package expressions_logiques;

public class And extends OperandeBinaire {

	public boolean isSatisfiable() {
		return this.operandeGauche.isSatisfiable() && this.operandeDroit.isSatisfiable() ;
	}

	public String toString() {
		return "("+this.operandeGauche+"."+this.operandeDroit+")";
	}
	
}
