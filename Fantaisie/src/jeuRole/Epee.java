package jeuRole;

public class Epee extends Arme {

	private String nom;
	
	public Epee(String nom) {
		super("epee",80);
		this.nom = nom;
	}

	public String getNom() {
		return nom;
	}
	
}
