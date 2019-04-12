package expressions_logiques;

public class Inhibition extends OperandeBinaire {

	public Inhibition() {
		super("/");
	}

	@Override
	public boolean isSatisfiable() {
		if(!this.isValid())
			return false;
		
		return this.operandeGauche.isSatisfiable() && !this.operandeDroit.isSatisfiable();
	}

}
