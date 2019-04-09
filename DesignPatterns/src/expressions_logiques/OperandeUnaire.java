package expressions_logiques;

public abstract class OperandeUnaire extends Satisfiable{

	protected Satisfiable operande;
	
	public void setOperande(Satisfiable satisfiable) {
		this.operande = satisfiable;
	}

}
