package jeuRole;

public class Heros extends Homme {
	
	
	public Heros(String nom){
		super(nom);
		super.qteVie = 150;
	}
	
	public void parler(String texte) {
		System.out.print("Le héros ");
		super.parler(texte);
	}
}
