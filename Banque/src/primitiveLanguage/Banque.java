package primitiveLanguage;

/**
 * Une banque, avec un nom, une adresse.
 * Possède un portefeuille de comptes.
 * Peut procéder à des virements et ouvrir des comptes.
 * 
 * @author dlk1560a
 *
 */
public class Banque {
	private String nom;
	private Adresse adresse;
	private Compte[] portefeuille = new Compte[1000];
	private int prochainNumero = 0;
	
	/**Constructeur
	 * @param nom le nom de la banque
	 * @param adresse l'adresse de la banque
	 */
	public Banque(String nom, Adresse adresse) {
		this.nom = nom;
		this.adresse = adresse;
	}
	
	/**Getter du nom	
	 * @return le nom de la banque
	 */
	public String getNom() {
		return nom;
	}
	
	/**Getter de l'adresse
	 * @return l'adresse
	 */
	public Adresse getAdresse() {
		return adresse;
	}
	
	/**Setter de l'adresse
	 * @param adresse la nouvelle adresse
	 */
	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}
	
	/**Ouvre un compte dans la banque, le place dans le portefeuille
	 * @param titulaire Le titulaire du compte à ouvrir
	 * @param date La date de création du compte
	 * @return La référence vers le compte ouvert
	 */
	public Compte ouvrir(Personne titulaire, Date date) {
		Compte compte = new Compte(this, titulaire, prochainNumero, date);
		
		portefeuille[prochainNumero] = compte;
		
		prochainNumero++;
		return compte;
	}
	
	/**Ouvre un compte dans la banque, le place dans le portefeuille, avec solde initial
	 * @param titulaire Le titulaire du compte à ouvrir
	 * @param date La date de création du compte
	 * @param solde Le solde initial, doit être positif
	 * @return La référence vers le compte ouvert
	 */
	public Compte ouvrir(Personne titulaire, Date date, float solde) {
		
		Compte compte;
		
		if(solde >= 0) {
			
			compte = new Compte(this, titulaire, prochainNumero, date, solde);
			
			portefeuille[prochainNumero] = compte;
			prochainNumero++;
			
			return compte;
			
		}else {
			
			System.out.println("Erreur compte "+ prochainNumero +" : solde initial négatif");

			return this.ouvrir(titulaire, date);
			
		}
	}
	
	/**Effectue un virement entre 2 comptes, si c'est possible
	 * @param compteDebite Le compte qui donne de l'argent
	 * @param compteCredite Le compte qui reçoit de l'argent
	 * @param montant Le montant du virement
	 */
	public void virement(Compte compteDebite, Compte compteCredite, float montant) {
		
		if( compteDebite.debiter(montant) ) {
			compteCredite.crediter(montant);
		}
	}
	
	/**Retourne le montant total du portefeuille de la banque
	 * @return la somme des soldes des comptes ouverts
	 */
	public float volumePortefeuille() {
		
		float somme = 0;
		
		for(int i = 0; i < prochainNumero; i++) {
			somme += portefeuille[i].getSolde();
		}
		
		return somme;
	}
}
