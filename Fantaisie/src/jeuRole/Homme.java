package jeuRole;

public class Homme extends EtreVivant {
	
	public Homme(String nom){
		super(nom,100);
		
	}
	
	public void parler(String texte) {
		System.out.print( getNom() + " : " + texte);
	}
	
	@Override
	public void rejointBataille(Bataille bataille) {
		super.rejointBataille(bataille);
		bataille.ajouter(this);
	}
	
	@Override
	public void mourir() {
		super.mourir();
		bataille.eliminer(this);
		System.out.print("C'est ainsi que le courageux "+ getNom() + " mourut.");
	}
}
