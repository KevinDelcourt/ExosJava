package recherche_pattern;

public class FastRecherchePattern extends RecherchePattern {

	public boolean equals(String pattern, String phrase, int position)
	{
		int debutPattern = position - pattern.length() + 1;
		
		if( debutPattern < 0 || position >= phrase.length() ) 
			return false;
		
		for(int i = pattern.length()-1; i >= 0; i--) {
			_compteur++;
			if( pattern.charAt(i) != phrase.charAt(debutPattern+i) )
				return false;
		}
			
		return true;
	}
	
	
}
