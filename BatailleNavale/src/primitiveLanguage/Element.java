package primitiveLanguage;

/**
 * Un �l�ment d'un bateau, occupe une case
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
		 * @param lettre Coordonn�e 1
		 * @param chiffre Coordonn�e 2
		 */
		public Element(char lettre, int chiffre) {
			this.lettre = lettre;
			this.chiffre = chiffre;
		}
		
		
		/**vrai si l'�l�ment est touch�, faux sinon
		 * @return elementtouche
		 */
		public boolean isElementTouche() {
			
			return elementTouche;
			
		}
		
		
		/** vrai si les coordonn�es en param�tre correspondent � celles du bateau
		 * @param lettre coordonn�e 1
		 * @param chiffre coordonn�e 2
		 * @return vrai ou faux
		 */
		public boolean verifierCoordonnees(char lettre, int chiffre) {
			
			return (this.lettre == lettre)&&(this.chiffre == chiffre);
			
		}
		
		
		/**
		 * L'�l�ment est touch�, passe elementTouche � true
		 */
		public void touche() {
			
			this.elementTouche = true;
			
		}
}
