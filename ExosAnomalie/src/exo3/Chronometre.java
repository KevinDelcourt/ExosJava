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
//			System.out.println(this);
//			this.decompterUneSeconde();
//			this.compteARebours();
			
			do {
				System.out.println(this);
				this.decompterUneSeconde();
			}while(true);

		}
		catch (Exception e) {
			System.out.println("le chronometre est epuise");
		}
	}

	public void decompterUneSeconde() throws Exception {
		try {
			this.secondes.moinsUn();
		}catch (ConstraintError e) {
			deroutementSecondes();
		}
	}
	
	private void deroutementSecondes() throws Exception {
		this.secondes.setValeur(59);
		try {
			this.minutes.moinsUn();
		}catch (ConstraintError e) {
			deroutementMinutes();
		}
	}
	
	private void deroutementMinutes() throws Exception {
		this.minutes.setValeur(59);
		try {
			this.heures.moinsUn();
		}catch (ConstraintError e) {
			System.out.println(this);
			throw new Exception();//Fin du chronometre
		}
	}


	public String toString() {
		int heures = this.heures.getValeur();
		int minutes = this.minutes.getValeur();
		int secondes = this.secondes.getValeur();
		return ("" + heures + "h " + minutes + "mn " + secondes + "s");
	}

}
