package jeuRole;

public abstract class EtreVivant extends EntiteLivre {

	private String nom;
	protected int qteVie;
	protected Bataille bataille;
	
	public EtreVivant(String nom, int qteVie){
		this.nom = nom;
		this.qteVie = qteVie;
	}
	
	public String getNom() {
		return nom;
	}
	
	protected void subirAttaque(int force) {
		
		livre.ecrire(this.nom + " subit une violente attaque, ");
		
		if(force >= qteVie) {
			
			qteVie = 0;
			livre.ecrire("trop violente pour survivre.\n");
			this.mourir();
			
		}else {
			
			qteVie -= force;
			livre.ecrire("mais il parvient à ce relever.\n");
			
		}
		
	}
	
	abstract public void mourir() ;
	
	public void rejointBataille(Bataille bataille) {
		this.bataille = bataille;
	}
	
	public boolean isMort() {
		return qteVie <= 0;
	}
}
