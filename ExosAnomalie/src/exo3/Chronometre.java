package exo3;

public class Chronometre {
	
	private Naturel heures;
	private Naturel minutes;
	private Naturel secondes;
	
	public Chronometre (Naturel heures, Naturel minutes, Naturel secondes) {
		this.heures = heures;
		this.minutes = minutes;
		this.secondes = secondes;
	}

	public void compteARebours() {
		try {
			System.out.println(this);
			this.decompterUneSeconde();
			this.compteARebours();
			
//			do {
//				System.out.println(this);
//				this.decompterUneSeconde();
//			}while(true);

		}
		catch (Exception e) {
			System.out.println("le chronometre est epuise");
		}
	}

	public void decompterUneSeconde() throws Exception {
		try {
			this.secondes.moinsUn();
		}catch (ConstraintError e) {
			try {

				this.minutes.moinsUn();
				this.secondes.setValeur(59);
			}catch (ConstraintError e1) {
				try {
					this.heures.moinsUn();
					this.secondes.setValeur(59);
					this.minutes.setValeur(59);
				}catch (ConstraintError e2) {
					throw new Exception();//Fin du chronometre
				}
			}
		}
	}
	


	public String toString() {
		int heures = this.heures.getValeur();
		int minutes = this.minutes.getValeur();
		int secondes = this.secondes.getValeur();
		return ("" + heures + "h " + minutes + "mn " + secondes + "s");
	}

}
