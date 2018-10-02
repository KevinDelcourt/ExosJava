package jeuRole;

public class EtreVivant {

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
		
		System.out.print(this.nom + " subit une violente attaque, ");
		
		if(force >= qteVie) {
			
			qteVie = 0;
			this.mourir();
			System.out.print("trop violente pour survivre.");
			
		}else {
			
			qteVie -= force;
			System.out.print(" mais il parvient à ce relever.");
			
		}
		
	}
	
	protected void mourir() {
	}
	
	public void rejointBataille(Bataille bataille) {
		this.bataille = bataille;
	}
}
