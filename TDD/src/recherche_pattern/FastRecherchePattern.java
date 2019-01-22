package recherche_pattern;

public class FastRecherchePattern extends MesurableRecherchePattern {

	private int[] delta1;
	private int[] delta2;
	private int phraseIndex;
	private String pattern;
	private String phrase;
	
	public int searchPattern(String pattern, String phrase) 
	{
		this.preProcesssing(pattern,phrase);
		
		for(phraseIndex = pattern.length()-1; phraseIndex < phrase.length();)
			if( this.equalsPatternPhrase() ) 
				return phraseIndex+pattern.length();
		
		return -1;
	}
	
	private boolean equalsPatternPhrase()
	{
		for(int patIndex = pattern.length()-1; patIndex >= 0; phraseIndex--, patIndex--) 
			if( pattern.charAt(patIndex) != charAtMesurable(phrase,phraseIndex) ) {	
				
				phraseIndex += Math.max(
						delta1[this.charCodeDelta1(phrase.charAt(phraseIndex))], 
						delta2[patIndex]);
				
				return false;
			}	
		
		return true;
	}
	
	public boolean equals(String pattern, String phrase, int position)
	{
		if( position - pattern.length() + 1 < 0 || position >= phrase.length() ) 
			return false;
		
		this.preProcesssing(pattern,phrase);
		phraseIndex = position;
		
		return this.equalsPatternPhrase();
	}

	private void preProcesssing(String pattern,String phrase) {
		this.pattern = pattern;
		this.phrase = phrase;
		this.delta1 = this.buildDelta1(pattern);
		this.delta2 = this.buildDelta2(pattern);		
		this.resetCompteur();
	}
	
	public int[] buildDelta1(String pattern) 
	{
		int[] delta1 = new int[28];//Toutes les lettres de l'alphabet + '.' + '-'
		
		for(int i = 0; i < 28; i++) 
			delta1[i] = pattern.length();
		
		for(int i = 0; i < pattern.length(); i++) 
			delta1[this.charCodeDelta1(pattern.charAt(i))] = pattern.length()-i-1;
		
		return delta1;
	}

	public int[] buildDelta2(String pattern) 
	{
		int[] delta2 = new int[pattern.length()];
		
		for(int j = 0; j < pattern.length()-1; j++) 
			delta2[j] = pattern.length() - rightmostPlausibleReoccurrence(pattern,j) ;
		
		delta2[pattern.length()-1] = 1;
		return delta2;
	}
	
	private int rightmostPlausibleReoccurrence(String pattern, int j) {
		int k;
		for(k = pattern.length()-1 ; 
			!unify(pattern,k,j) || (k>=1 && pattern.charAt(k-1) == pattern.charAt(j)); 
			k--) {}
		return k;
	}
	
	private boolean unify(String pattern, int k, int j) 
	{
		boolean unify = true;
		for(int x = 0; x < pattern.length() - j ; x++) {
			if(x+j+1 > pattern.length() || x+k > pattern.length())
				unify = false;
			
			try {
				unify = unify && pattern.charAt(x+j+1) == pattern.charAt(x+k);
			}catch(StringIndexOutOfBoundsException e) {	}
		}
			
		return unify;
	}

	
	private int charCodeDelta1(char c) {
		if(c == '-')
			return 27;
		if(c == '.')
			return 26;
		return ((int)c) - 65;
	}
}
