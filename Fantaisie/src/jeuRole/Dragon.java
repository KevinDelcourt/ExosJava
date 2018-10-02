package jeuRole;

public class Dragon extends EtreVivant {
	
	
	
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
		super.mourir();
		bataille.eliminer(this);
		System.out.print("C'est ainsi que le dragon "+ getNom() + " mourut.");
	}
}
