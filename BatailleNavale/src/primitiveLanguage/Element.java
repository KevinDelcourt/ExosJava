package primitiveLanguage;

/**
 * Un element d'un bateau, occupe une case
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
		 * @param lettre Coordonnee 1
		 * @param chiffre Coordonnee 2
		 */
		public Element(char lettre, int chiffre) {
			this.lettre = lettre;
			this.chiffre = chiffre;
		}
		
		
		/**vrai si l'element est touche, faux sinon
		 * @return elementtouche
		 */
		public boolean isElementTouche() {
			
			return elementTouche;
			
		}
		
		
		/** vrai si les coordonnes en parametre correspondent a celles du bateau
		 * @param lettre coordonnee 1
		 * @param chiffre coordonnee 2
		 * @return vrai ou faux
		 */
		public boolean verifierCoordonnees(char lettre, int chiffre) {
			
			return (this.lettre == lettre)&&(this.chiffre == chiffre);
			
		}
		
		
		/**
		 * L'ï¿½lï¿½ment est touche, passe elementTouche a true
		 */
		public void touche() {
			
			this.elementTouche = true;
			
		}
}
