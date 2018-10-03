package jeuRole;

public class Homme extends EtreVivant {
	
	private Arme maPossetion;
	
	public Homme(String nom){
		super(nom,100);
		
	}
	
	public void parler(String texte) {
		EntiteLivre.livre.ecrire( getNom() + " : " + texte);
	}
	
	@Override
	public void rejointBataille(Bataille bataille) {
		super.rejointBataille(bataille);
		bataille.ajouter(this);
	}
	
	@Override
	public void mourir() {
		
		bataille.eliminer(this);
		EntiteLivre.livre.ecrire("C'est ainsi que le courageux "+ getNom() + " mourut.");
	}
	
	public void lacher() {
		EntiteLivre.livre.ecrire(getNom() + " lâche son " + maPossetion.getNature());
		maPossetion = null;
		maPossetion.lacher();
	}
}
