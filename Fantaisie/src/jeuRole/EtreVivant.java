package jeuRole;

public class EtreVivant {

	private String nom;
	protected int qteVie;
	
	EtreVivant(String nom){
		this.nom = nom;
	}
	
	public String getNom() {
		return nom;
	}
}
