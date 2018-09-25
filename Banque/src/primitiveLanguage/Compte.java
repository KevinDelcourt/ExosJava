package primitiveLanguage;


/**
 * Un compte, apprtient � une banque et � un titulaire.
 * Poss�de un num�ro, une date de cr�ation, un solde et un d�couvert autoris�.
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
	 * @param banque la banque dans laquelle est cr�e le compte
	 * @param titulaire le titulaire du compte
	 * @param numero le num�ro du compte
	 * @param date la date de cr�ation du compte
	 */
	public Compte(Banque banque, Personne titulaire, int numero, Date date) {
		
		this.banque = banque;
		this.titulaire = titulaire;
		this.numero = numero;
		this.date = date;
	}
	
	/**Constructeur d'un compte, avec initialisation d'un solde
	 * @param banque la banque dans laquelle est cr�e le compte
	 * @param titulaire le titulaire du compte
	 * @param numero le num�ro du compte
	 * @param date la date de cr�ation du compte
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

	/**Getter num�ro
	 * @return le num�ro du compte
	 */
	public int getNumero() {
		return numero;
	}
	
	/**Getter date
	 * @return la date de cr�ation du compte
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

	
	
	/**Getter d�couvert autoris�
	 * @return le montant du d�couvert autoris� du compte
	 */
	public int getDecouvertAutorise() {
		return decouvertAutorise;
	}

	/**Setter d�couvert autoris�
	 * @param decouvertAutorise le montant du nouveau d�couvert autoris�
	 */
	public void setDecouvertAutorise(int decouvertAutorise) {
		this.decouvertAutorise = decouvertAutorise;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		
		String output = "Compte N�" + numero ;
		output += "\n cr�� le " + date;
		output += "\n au pr�t de "+ banque.getNom();
		output += "\n dont le titulaire est "+ titulaire.getPrenom()+" "+titulaire.getNom();
		output += "\n a pour solde "+ solde +"�";
		
		return output;
	}
	
	/**Cr�dite le compte d'un montant
	 * @param montant la somme � cr�diter
	 */
	public void crediter(float montant) {
		solde += montant;
	}
	
	/**D�bite le compte d'un montant, si le d�couvert le permet
	 * @param montant la somme � d�biter
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
