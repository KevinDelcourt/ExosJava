package primitiveLanguage;


/**
 * Une personne, avec un nom un prenom et une adresse
 * 
 * @author dlk1560a
 *
 */
public class Personne {

	private String nom;
	private String prenom;
	private Date dateNaissance;
	private Adresse adresse;
	
	/**Constructeur
	 * @param nom le nom de la personne
	 * @param prenom son prenom
	 * @param dateNaissance sa date de naissance
	 * @param adresse son adresse
	 */
	public Personne(String nom, String prenom, Date dateNaissance, Adresse adresse) {
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.adresse = adresse;
	}
	
	/**getter date de naissace
	 * @return la date de naissance
	 */
	public Date getDateNaissance() {
		return dateNaissance;
	}
	
	/**
	 * @return
	 */
	public String getNom() {
		return nom;
	}
	
	public String getPrenom() {
		return prenom;
	}
	
	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}
	public String toString() {
		return prenom + " " + nom + " né le " + dateNaissance;
	}
	
	public void renseignement() {
		System.out.println(this);
		System.out.println("Adresse : " + adresse);
	}
}
