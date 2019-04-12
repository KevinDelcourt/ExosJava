package expressions_logiques;

public class Not extends OperandeUnaire {
	
	public boolean isSatisfiable() {
		if(this.operande == null)
			return false;
		
		return !this.operande.isSatisfiable();
	}

	public String toString() {
		if(this.operande == null)
			return "";
		
		return "!"+this.operande;
	}
}
