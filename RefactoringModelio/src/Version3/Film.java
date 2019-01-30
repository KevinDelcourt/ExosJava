package Version3;

public class Film {
	public static final int CINEPHILE = 4;
	public static final int COFFRET_SERIES_TV = 3;
	public static final int ENFANT = 2;
	public static final int NOUVEAUTE = 1;
	public static final int NORMAL = 0;
	
	private String titre;
	private Prix prix;
	
	public Film(String titre, int codePrix) {
		this.titre = titre;
		this.setPrix(codePrix);
	}

	public String getTitre() {
		return this.titre;
	}

	public void setPrix(int codePrix) {
		this.prix = Prix.createPrix(codePrix);
	}

	public Prix getPrix() {
		return this.prix;
	}
	
}