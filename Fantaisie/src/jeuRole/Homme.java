package jeuRole;

public class Homme extends EtreVivant {
	
	private Arme maPossetion;
	
	public Homme(String nom){
		super(nom,100);
		
	}
	
	public void parler(String texte) {
		EntiteLivre.livre.ecrire( getNom() + " : " + texte + "\n");
	}
	
	@Override
	public void rejointBataille(Bataille bataille) {
		super.rejointBataille(bataille);
		bataille.ajouter(this);
	}
	
	@Override
	public void mourir() {
		if(maPossetion != null)
			this.lacher();
		
		livre.ecrire("C'est ainsi que le courageux "+ getNom() + " mourut.");
		
		bataille.eliminer(this);
	}
	
	public void lacher() {
		livre.ecrire(getNom() + " lâche son " + maPossetion.getNature() + ".\n");
		maPossetion.lacher();
		maPossetion = null;
	}
	
	public void prendre(Arme arme) {
		
		if(maPossetion != null) 
			maPossetion.lacher();
		
		
		if(arme.getProprietaire() != null) {
			this.parler( arme.getProprietaire().getNom() + ", peux-tu me laisser prendre ton " + arme.getNature() + "?" );
			arme.getProprietaire().parler("Pas de soucis, cela me permettra de reprendre mon souffle.");
			arme.getProprietaire().lacher();
		}
		
		
		maPossetion = arme;
		
		if(arme instanceof Epee) 
			this.prendreEpee((Epee) arme);
		else
			this.parler("Je prends un " + arme.getNature() + ".");
		
		arme.prendre(this);
		
		
	}
	
	public void prendreEpee(Epee epee) {
		
		qteVie -= 10;
		this.parler("Je prends cette épée même si pour cela je dois perdre des forces.");
		
		if(qteVie <= 0) {
			livre.ecrire( getNom() + " a voulu prendre l'épée mais son état de fatigue ne lui permettait pas cet ultime effort, il en est mort.\n");
			this.mourir();
		}
	}
	
	public void combattre(Dragon dragon) {
		if(maPossetion == null) {
			this.mourir();
		}else {
			maPossetion.attaque(dragon); 
		}
	}
}
