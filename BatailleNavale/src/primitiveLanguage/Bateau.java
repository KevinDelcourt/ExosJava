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
	
	/**Place tout les �l�ments du bateau selon les coordonn�es et le sens
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
	
}
