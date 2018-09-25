package primitiveLanguage;

public class Bateau {

	protected String nom;
	protected int tailleBateau;
	protected char etatBateau = 'S';
	protected Element[] bateau;
	
	public Bateau(String nom, int tailleBateau) {
		this.nom = nom;
		this.tailleBateau = tailleBateau;
		this.bateau = new Element[tailleBateau];
	}
	
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
