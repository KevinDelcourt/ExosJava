package recherche_pattern;

public abstract class MesurableRecherchePattern {
	
	private int compteur = 0;
	
	public int getCompteur()
	{
		return this.compteur;
	}
	
	public void resetCompteur()
	{
		this.compteur = 0;
	}
	
	public char charAtMesurable(String string, int index) {
		compteur++;
		return string.charAt(index);	
	}
	
	public abstract boolean equals(String pattern, String phrase, int position);
	
	public abstract int searchPattern(String pattern, String phrase) ;
	
}
