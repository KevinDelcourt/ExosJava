package primitiveLanguage;


/**
 * Un compte, apprtient à une banque et à un titulaire.
 * Possède un numéro, une date de création, un solde et un découvert autorisé.
 * 
 * @author dlk1560a
 *
 */
public class Compte {
	private Banque banque;
	private Personne titulaire;
	private int numero;
	private Date date;
	private float solde;
	private int decouvertAutorise = 1000;
	
	/**Constructeur d'un compte
	 * @param banque la banque dans laquelle est crée le compte
	 * @param titulaire le titulaire du compte
	 * @param numero le numéro du compte
	 * @param date la date de création du compte
	 */
	public Compte(Banque banque, Personne titulaire, int numero, Date date) {
		
		this.banque = banque;
		this.titulaire = titulaire;
		this.numero = numero;
		this.date = date;
	}
	
	/**Constructeur d'un compte, avec initialisation d'un solde
	 * @param banque la banque dans laquelle est crée le compte
	 * @param titulaire le titulaire du compte
	 * @param numero le numéro du compte
	 * @param date la date de création du compte
	 * @param solde le solde initial
	 */
	public Compte(Banque banque, Personne titulaire, int numero, Date date, float solde) {
		
		this(banque,titulaire,numero,date);
		this.solde = solde;
	}

	/**Getter banque
	 * 
	 * @return la banque de ce compte
	 */
	public Banque getBanque() {
		return banque;
	}

	/**Getter titulaire
	 * @return le titulaire du compte
	 */
	public Personne getTitulaire() {
		return titulaire;
	}

	/**Getter numéro
	 * @return le numéro du compte
	 */
	public int getNumero() {
		return numero;
	}
	
	/**Getter date
	 * @return la date de création du compte
	 */
	public Date getDate() {
		return date;
	}
	
	/**Getter solde
	 * @return le solde du compte
	 */
	public float getSolde() {
		return solde;
	}

	
	
	/**Getter découvert autorisé
	 * @return le montant du découvert autorisé du compte
	 */
	public int getDecouvertAutorise() {
		return decouvertAutorise;
	}

	/**Setter découvert autorisé
	 * @param decouvertAutorise le montant du nouveau découvert autorisé
	 */
	public void setDecouvertAutorise(int decouvertAutorise) {
		this.decouvertAutorise = decouvertAutorise;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		
		String output = "Compte N°" + numero ;
		output += "\n créé le " + date;
		output += "\n au prêt de "+ banque.getNom();
		output += "\n dont le titulaire est "+ titulaire.getPrenom()+" "+titulaire.getNom();
		output += "\n a pour solde "+ solde +"€";
		
		return output;
	}
	
	/**Crédite le compte d'un montant
	 * @param montant la somme à créditer
	 */
	public void crediter(float montant) {
		solde += montant;
	}
	
	/**Débite le compte d'un montant, si le découvert le permet
	 * @param montant la somme à débiter
	 * @return true si on a pu effectuer l'action, false sinon
	 */
	public boolean debiter(float montant) {
		
		if( solde + decouvertAutorise - montant >= 0) {
			
			solde -= montant;
			return true;
			
		}else {
			return false;
		}
		
	}
	
}
