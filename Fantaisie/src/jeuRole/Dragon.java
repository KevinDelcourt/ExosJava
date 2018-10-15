package jeuRole;

public class Dragon extends EtreVivant {
	
	private int nbBoules = 10;
	
	public Dragon(String nom){
		super(nom,200);
		
	}
	
	@Override
	public void rejointBataille(Bataille bataille) {
		super.rejointBataille(bataille);
		bataille.ajouter(this);
	}
	
	@Override
	public void mourir() {
		
		
		EntiteLivre.livre.ecrire("C'est ainsi que le dragon "+ getNom() + " mourut.\n");
		bataille.eliminer(this);
	}
	
	public void cracheBouleFeu(Homme homme) {
		
		if(nbBoules >= 0) {
			EntiteLivre.livre.ecrire(getNom() + " crache une boule de feu sur " + homme.getNom() + ".\n");
			
			nbBoules--;
			
			homme.subirAttaque(100);
		}else {
			
			EntiteLivre.livre.ecrire(getNom() + " ne pouvait plus cracher de boules de feu! " + homme.getNom() + " a eu beaucoup de chances.\n");
		}
		
	}
}
