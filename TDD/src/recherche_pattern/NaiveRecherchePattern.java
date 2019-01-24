package recherche_pattern;

public class NaiveRecherchePattern extends MesurableRecherchePattern {
	
	public boolean equals(String pattern, String phrase, int position)
	{
		int debutPattern = position - pattern.length() + 1;
		
		if( debutPattern < 0 || position >= phrase.length() ) 
			return false;
		
		for(int j = 0; j < pattern.length(); j++) 
			if( pattern.charAt(j) != charAtMesurable(phrase,debutPattern+j) )
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
