package jeuRole;

abstract class Arme {
	
	private Homme proprietaire;
	private String nature;
	private int degats;
	
	public Arme(String nature, int degats) {
		this.nature = nature;
		this.degats = degats;
	}
	
	public Homme getProprietaire() {
		return proprietaire;
	}
	
	public String getNature() {
		return nature;
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
		EntiteLivre.livre.ecrire(proprietaire.getNom() + " attaque " + dragon.getNom() + " avec son " + nature + "\n");
		dragon.subirAttaque(degats);
	}
}
