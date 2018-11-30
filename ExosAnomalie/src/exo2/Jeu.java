package exo2;

public class Jeu {
	
	public static final int NB_CASES = 63;
	
    private int position;

    public Jeu() {
        this.setPosition(1);
    }

    private void setPosition(int position) {
    	this.position = position;
    }
    
    public void jouer() {
        
        while(this.position < NB_CASES){
        	int nouvellePosition = nouvellePosition(this.position);
        	this.deplacerPion(nouvellePosition);
		}
    }

    private static int nouvellePosition(int position) {
    	int valeurDe = lancerDe();

    	if(position + valeurDe > NB_CASES)
    		return deroutementNouvellePosition(position);

    	return position + valeurDe;
    }
    
    private static int deroutementNouvellePosition(int position) {
    	int valeurDe;
    	do 
    		valeurDe = lancerDe();		
    	while(position + valeurDe > NB_CASES);

		return position + valeurDe;
	}

	private static int lancerDe() {
		int valeurDe = (int) (6.0 * Math.random() + 1.0);
		System.out.println("lancer du de : " + valeurDe);
		return valeurDe;
	}

	private void deplacerPion(int nouvellePosition) {
        System.out.println("position du pion avant de jouer : " + this.position);
        this.setPosition(nouvellePosition);
        System.out.println("position du pion après avoir joue : " + this.position);
        System.out.println();
    }
}
