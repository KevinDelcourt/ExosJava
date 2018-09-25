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
		 * @param lettre Coordonn�e 1
		 * @param chiffre Coordonn�e 2
		 */
		public Element(char lettre, int chiffre) {
			this.lettre = lettre;
			this.chiffre = chiffre;
		}
		
		//Le bateau est-il touch�
		public boolean isElementTouche() {
			
			return elementTouche;
			
		}
		
		//Retourne vrai si les coordonn�es en param�tre correspondent � celles du bateau
		public boolean verifierCoordonnees(char lettre, int chiffre, char sens) {
			
			return (this.lettre == lettre)&&(this.chiffre == chiffre);
			
		}
		
		//Le bateau est touch�
		public void touche() {
			
			this.elementTouche = true;
			
		}
}
