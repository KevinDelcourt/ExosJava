package jeuRole;

public class EtreVivant {

	private String nom;
	protected int qteVie;
	
	public EtreVivant(String nom, int qteVie){
		this.nom = nom;
		this.qteVie = qteVie;
	}
	
	public String getNom() {
		return nom;
	}
}
