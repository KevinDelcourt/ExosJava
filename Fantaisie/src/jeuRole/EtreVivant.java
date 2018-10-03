package jeuRole;

public abstract class EtreVivant extends EntiteLivre {

	private String nom;
	protected int qteVie;
	protected Bataille bataille;
	
	public EtreVivant(String nom, int qteVie){
		this.nom = nom;
		this.qteVie = qteVie;
	}
	
	protected String getNom() {
		return nom;
	}
	
	protected void subirAttaque(int force) {
		
		EntiteLivre.livre.ecrire(this.nom + " subit une violente attaque, ");
		
		if(force >= qteVie) {
			
			qteVie = 0;
			this.mourir();
			EntiteLivre.livre.ecrire("trop violente pour survivre.");
			
		}else {
			
			qteVie -= force;
			livre.ecrire(" mais il parvient à ce relever.");
			
		}
		
	}
	
	abstract public void mourir() ;
	
	public void rejointBataille(Bataille bataille) {
		this.bataille = bataille;
	}
}
