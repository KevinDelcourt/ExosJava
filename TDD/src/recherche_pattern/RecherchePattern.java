package recherche_pattern;

public class RecherchePattern extends MesurableRecherchePattern {
	
	public boolean equals(String pattern, String phrase, int position)
	{
		//Position du début du pattern dans la phrase
		int debutPattern = position - pattern.length() + 1;
		
		if( debutPattern < 0 || position >= phrase.length() ) 
			return false;
		
		for(int i = 0; i < pattern.length(); i++) 
			if( pattern.charAt(i) != charAt(phrase,debutPattern+i) )
				return false;
			
		return true;
	}

	public int searchPattern(String pattern, String phrase) 
	{
		resetCompteur();
		for(int i = 0; i < phrase.length(); i++) {
			if( this.equals(pattern, phrase, i) ) 
				return i;
		}
		return -1;
	}
	
}
