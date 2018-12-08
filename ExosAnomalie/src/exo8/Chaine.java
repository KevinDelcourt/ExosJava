package exo8;

public class Chaine {
	
	public static final int LG_MAX = 250;
	
	private Tableau<Character> valeur;
	
	public Chaine(String s) {
		this.valeur = new Tableau<Character>(LG_MAX);
		for (int i = 0; i <= s.length() - 1; i++)
			this.valeur.setIeme(i, s.charAt(i));
		this.valeur.setIeme(s.length(), '!');
	}
	
	public Chaine() {
		this(" ");
	}
	
	public Character getCharAt(int i) {
		return this.valeur.getIeme(i);
	}
	
	public void setCharAt(int i, Character c) {
		this.valeur.setIeme(i, c);
	}
	
	public ChaineAvecIndicateur versChaineAvecIndicateur() {
		// recopier les caracteres de la chaine courante this dans c
		ChaineAvecIndicateur c = new ChaineAvecIndicateur();
		int i = 0;
		while (this.valeur.getIeme(i) != '!') {
			c.setCharAt(i, this.getCharAt(i));
			i++;
		}
		c.setCharAt(i, '!');
		return c;
	}
	
	public String toString() { 
		return this.valeur.toString();
	}
	
}
