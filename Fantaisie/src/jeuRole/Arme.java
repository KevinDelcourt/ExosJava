package jeuRole;

abstract class Arme {
	
	private Homme proprietaire;
	private String nature;
	private int degats;
	
	public Arme(String nature, int degats) {
		this.nature = nature;
		this.degats = degats;
;	}
	
	public Homme getProprietaire() {
		return proprietaire;
	}
	public void setProprietaire(Homme proprietaire) {
		this.proprietaire = proprietaire;
	}
	public String getNature() {
		return nature;
	}
	public void setNature(String nature) {
		this.nature = nature;
	}
	
	public boolean estPris() {
		return proprietaire != null;
	}
	
	public void prendre(Homme proprietaire) {
		this.proprietaire = proprietaire;
	}
	
	public void lacher() {
		this.proprietaire = null;
	}
	
	public void attaque(Dragon dragon) {
		System.out.print(proprietaire.getNom() + " attaque " + dragon.getNom() + " avec son " + nature);
		dragon.subirAttaque(degats);
	}
}
