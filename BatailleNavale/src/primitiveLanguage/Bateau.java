package primitiveLanguage;

/**Un bateau, avec un nom, une taille, un etat 
 * 
 * @author dlk1560a
 *
 */
public class Bateau {

	private String nom;
	private int tailleBateau;
	private char etatBateau = 'S';
	private Element[] bateau;
	
	/**Constructeur
	 * 
	 * @param nom nom du bateau
	 * @param tailleBateau taille du bateau
	 */
	Bateau(String nom, int tailleBateau) {
		this.nom = nom;
		this.tailleBateau = tailleBateau;
		this.bateau = new Element[tailleBateau];
	}
	
	/**Place tout les elements du bateau selon les coordonn�es et le sens
	 * 
	 * @param lettre coordonn�e 1
	 * @param chiffre coordonn�e 2
	 * @param sens V ou H, vertical ou horizontal
	 */
	public void placerBateau(char lettre, int chiffre, char sens) {
		
		if(sens == 'H') {
			
			for(int i = 0; i < bateau.length; i++) {
				bateau[i] = new Element(lettre, chiffre + i);
			}
			
			
		}else {
			
			for(int i = 0; i < bateau.length; i++) {
				char newLettre = (char)(lettre + i);
				bateau[i] = new Element(newLettre, chiffre);
			}
			
		}

	}

	/** renvoie true si la coo passee en parametre appartient au tableau
	 * @param lettre coo 1
	 * @param chiffre coo2
	 * @return boolean - true si la coo en parametre correspond a un element du bateau
	 */
	public boolean appartientBateau(char lettre,int chiffre) {
		
		boolean appartientBateau = false;
		
		for(int i = 0; i < this.bateau.length; i++) {
			boolean appartient = bateau[i].verifierCoordonnees(lettre, chiffre);
			
			if(appartient) {
				appartientBateau = appartient;
			}
		}
			
		return appartientBateau;
	}
	
	/** Simule un tir sur le bateau avec les coordonnes passees en param
	 *  Change l'etat du bateau en consequence
	 * @param lettre coordonnee 1
	 * @param chiffre coordonnee 2
	 * @return boolean true si le coup est bon, faux sinon
	 */
	public boolean coup(char lettre, int chiffre) {
		
		boolean resultat = false;
		
		for(int i = 0; i < this.bateau.length; i++) 	
			if( bateau[i].verifierCoordonnees(lettre, chiffre) && !bateau[i].isElementTouche()) {
				
				bateau[i].touche();
				resultat = true;
				
				if(this.isCoule()) {
					etatBateau = 'C';
				}else {
					etatBateau = 'T';
				}
			}
		
		return resultat;
	}
	
	/**
	 * @return int la taille du bateau
	 */
	public int getTailleBateau() {
		return tailleBateau;
	}

	/**
	 * @param tailleBateau int la nouvelle taille du bateau en cases
	 */
	public void setTailleBateau(int tailleBateau) {
		this.tailleBateau = tailleBateau;
	}

	/**
	 * @return char - l'etat du bateau
	 */
	public char getEtatBateau() {
		return etatBateau;
	}

	/**
	 * @param etatBateau char le nouvel etat du bateau
	 */
	public void setEtatBateau(char etatBateau) {
		this.etatBateau = etatBateau;
	}
	
	/** regarde tout les elements du bateau pour voir si ils sont tous touche
	 * @return vrai si le bateau est coule
	 */
	private boolean isCoule(){
		boolean resultat = true;
		
		for(int i = 0; i < this.bateau.length; i++) 	
			resultat = resultat && bateau[i].isElementTouche();
		
		return resultat;
	}
	
	/** retourne le caractère de l'etat de l'element cible par les coordonnes
	 * @param lettre coordonnees 1
	 * @param chiffre coordonnees 2
	 * @return S pour Sain, T pour touché, C pour coulé, X si les coordonnees ne sont pas bonnes
	 */
	public char getEtatElement(char lettre, int chiffre) {
		char etat = '_';
		
		for(int i = 0; i < this.bateau.length; i++)
			if(bateau[i].verifierCoordonnees(lettre, chiffre) && bateau[i].isElementTouche() && etatBateau =='C'){
				etat = 'C';
			}else if(bateau[i].verifierCoordonnees(lettre, chiffre) && bateau[i].isElementTouche()) {
				etat = 'T';
			}else if(bateau[i].verifierCoordonnees(lettre, chiffre)) {
				etat = 'S';
			}
			
		return etat;
	}
	
}
