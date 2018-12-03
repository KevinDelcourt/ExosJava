package exo5;

public class Jeu {
	
	public static final int NB_CASES = 63;
	
    private int position;

    public Jeu() {
        this.setPosition(1);
    }

    private void setPosition(int position) {
    	this.position = position;
    }
    
    public void jouerPartie() {
        int nouvellePosition;
		while (this.position < NB_CASES) {
        	try {
				nouvellePosition = nouvellePosition(this.position);
				this.deplacerPion(nouvellePosition);
			} catch (Exception e) {
				 System.out.print("Nouvel essai : ");
			}
        	
		}
    }

    private static int nouvellePosition(int position) throws Exception {
    	int valeurDe = (int) (10.0 * Math.random() + 1.0);
    	System.out.println("Lancer du de : " + valeurDe);
    	
    	if (position + valeurDe > NB_CASES)
    		throw new Exception();
    	
    	return position + valeurDe;
    }
    
    private void deplacerPion(int nouvellePosition) {
        System.out.print("Déplacement de " + this.position);
        this.setPosition(nouvellePosition);
        System.out.println(" à " + this.position +"\n");
    }
}