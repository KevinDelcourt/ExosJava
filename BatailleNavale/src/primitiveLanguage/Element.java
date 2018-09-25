package primitiveLanguage;

/**
 * Un élément d'un bateau, occupe une case
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
		
		
		/**vrai si l'élément est touché, faux sinon
		 * @return elementtouche
		 */
		public boolean isElementTouche() {
			
			return elementTouche;
			
		}
		
		
		/** vrai si les coordonnées en paramètre correspondent à celles du bateau
		 * @param lettre coordonnée 1
		 * @param chiffre coordonnée 2
		 * @param sens H ou V, donne le sens
		 * @return vrai ou faux
		 */
		public boolean verifierCoordonnees(char lettre, int chiffre, char sens) {
			
			return (this.lettre == lettre)&&(this.chiffre == chiffre);
			
		}
		
		
		/**
		 * L'élément est touché, passe elementTouche à true
		 */
		public void touche() {
			
			this.elementTouche = true;
			
		}
}
