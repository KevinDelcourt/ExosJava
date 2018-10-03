package jeuRole;

public class Heros extends Homme {
	
	
	public Heros(String nom){
		super(nom);
		super.qteVie = 150;
	}
	
	@Override
	public void parler(String texte) {
		EntiteLivre.livre.ecrire("Le héros ");
		super.parler(texte);
	}
}
