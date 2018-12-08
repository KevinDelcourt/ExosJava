package exo8;

public class ChaineAvecIndicateur extends Chaine {
	
	private boolean valide;
	
	public ChaineAvecIndicateur(String s) {
		super(s);
		this.valide = true;
	}
	
	public ChaineAvecIndicateur() {
		this(" ");
	}
	
	public boolean estValide() {
		return this.valide;
	}
	
	public Chaine versChaine() {
		return (Chaine) this;
	}
	
	public ChaineAvecIndicateur concat(ChaineAvecIndicateur c2) {
		// recopier les caractères de la chaîne this dans c
		ChaineAvecIndicateur c = new ChaineAvecIndicateur();
		int i = 0;
		while (this.getCharAt(i) != '!') {
			c.setCharAt(i, this.getCharAt(i));
			i++;
		}
		// ajouter les caractères de la chaîne c2 à c
		int j = 0;
		while (i <= Chaine.LG_MAX - 2 && c2.getCharAt(j) != '!') {
			c.setCharAt(i, c2.getCharAt(j));
			i++;
			j++;
		}
		
		if(i > Chaine.LG_MAX - 2 || !c2.estValide() || !this.estValide())
			c.valide = false;
		
		c.setCharAt(i,'!');
		return c;

	}
	
	public String toString() { 
		return super.toString() + this.valide + "\n";
	}

}
