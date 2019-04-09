package expressions_logiques;

public class Not extends OperandeUnaire {
	
	public boolean isSatisfiable() {
		return !this.operande.isSatisfiable();
	}

	public String toString() {
		return "!"+this.operande;
	}
}
