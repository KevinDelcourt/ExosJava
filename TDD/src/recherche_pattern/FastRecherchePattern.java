package recherche_pattern;

public class FastRecherchePattern extends MesurableRecherchePattern {

	private int[] _delta1;
	private int[] _delta2;
	private int _i;
	
	public int searchPattern(String pattern, String phrase) 
	{
		_delta1 = buildDelta1(pattern);
		_delta2 = buildDelta2(pattern);		

		resetCompteur();
		for(_i = pattern.length()-1; _i < phrase.length();)
			if( this.equals(pattern, phrase) ) 
				return _i+pattern.length();
		
		return -1;
	}
	
	private boolean equals(String pattern, String phrase)
	{
		if( _i - pattern.length() + 1 < 0 || _i >= phrase.length() ) 
			return false;
		
		for(int j = pattern.length()-1; j >= 0; _i--, j--) {
			if( pattern.charAt(j) != charAt(phrase,_i) ) {	
				
				_i += Math.max(
						_delta1[this.charCodeDelta1(phrase.charAt(_i))], 
						_delta2[j]);
				
				return false;
			}	
		}
		return true;
	}
	
	public boolean equals(String pattern, String phrase, int i)
	{
		resetCompteur();
		_i = i;
		_delta1 = this.buildDelta1(pattern);
		_delta2 = this.buildDelta2(pattern);	
		return this.equals(pattern,phrase);
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
		
		for(int j = 0; j < pattern.length()-1; j++) {
			int k;
			for(k = pattern.length() - 3; 
				!unify(pattern,k,j) || (k>=1 && pattern.charAt(k-1) == pattern.charAt(j)); 
				k--) {}
			delta2[j] = pattern.length() - k ;
		}
		delta2[pattern.length()-1] = 1;
		return delta2;
	}
	
	//Voir définition de unify dans l'article
	private boolean unify(String pattern, int k, int j) 
	{
		boolean unify = true;
		for(int x = 0; x < pattern.length() - j - 1 ; x++) {
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
