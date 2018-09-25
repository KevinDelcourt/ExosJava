package primitiveLanguage;

/**
 * Un bateau
 * 
 * @author dlk1560a
 *
 */
public class Element {

		private char lettre;
		private int chiffre;
		private boolean elementTouche = false;
		
		/**
		 * Constructeur
		 * 
		 * @param lettre Coordonnée 1
		 * @param chiffre Coordonnée 2
		 */
		public Element(char lettre, int chiffre) {
			this.lettre = lettre;
			this.chiffre = chiffre;
		}
		
		//Le bateau est-il touché
		public boolean isElementTouche() {
			
			return elementTouche;
			
		}
		
		//Retourne vrai si les coordonnées en paramètre correspondent à celles du bateau
		public boolean verifierCoordonnees(char lettre, int chiffre, char sens) {
			
			return (this.lettre == lettre)&&(this.chiffre == chiffre);
			
		}
		
		//Le bateau est touché
		public void touche() {
			
			this.elementTouche = true;
			
		}
}
