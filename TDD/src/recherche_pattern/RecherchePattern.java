package recherche_pattern;

public class RecherchePattern {

	private int compteur = 0;
	
	public boolean equals(String pattern, String phrase, int position)
	{
		//Position du début du pattern dans la phrase
		int debutPattern = position - pattern.length() + 1;
		
		if( debutPattern < 0 || position >= phrase.length() ) 
			return false;
		
		for(int i = 0; i < pattern.length(); i++) {
			compteur++;
			if( pattern.charAt(i) != phrase.charAt(debutPattern+i) )
				return false;
		}
			
		return true;
	}

	public int searchPattern(String pattern, String phrase) 
	{
		compteur = 0;
		for(int i = 0; i < phrase.length(); i++) {
			compteur++;
			if( this.equals(pattern, phrase, i) ) 
				return i;
		}
		return -1;
	}
	
	public int getCompteur() 
	{
		return compteur;
	}
	
}
