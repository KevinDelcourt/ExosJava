package primitiveLanguage;

/**
 * Une adresse, contient un numéro, un nom de rue, un code postal et un nom de ville
 * 
 * @author dlk1560a
 *
 */
public class Adresse {

	private int numero;
	private String rue;
	private int codePostal;
	private String ville;
	
	public Adresse(int numero, String rue, int codePostal, String ville) {
		
		this.numero = numero;
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
	}
	
	
	public int getNumero() {
		return this.numero;
	}
	
	public String getRue() {
		return this.rue;
	}
	
	public int getCodePostal() {
		return this.codePostal;
	}
	
	public String getVille() {
		return this.ville;
	}
	
	public String toString() {
		return numero + " " + rue + ", " + codePostal + " " + ville;
	}
	
}
