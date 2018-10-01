package jeuRole;

public class Homme extends EtreVivant {
	
	public Homme(String nom){
		super(nom,100);
		
	}
	
	public void parler(String texte) {
		System.out.print( getNom() + " : " + texte);
	}
}
