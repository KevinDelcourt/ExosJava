package primitiveLanguage;

/**
 * Une date: contient une valeur de jour/mois/annee
 * 
 * @author dlk1560a
 *
 */
public class Date {

		private int jour;
		private int mois;
		private int annee;
		
		public Date(int jour, int mois, int annee) {
			
			this.jour = jour;
			this.mois = mois;
			this.annee = annee;
		}
		
		public int getjour() {
			return this.jour;
		}
		
		public int getMois() {
			return this.mois;
		}
		
		public int getAnnee(){
			return this.annee;
		}
		
		public String toString() {
			return this.jour + "/" + this.mois + "/" + this.annee;
		}
}
