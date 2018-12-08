package recherche_pattern;

public class FastRecherchePattern extends RecherchePattern {

	private int[] _delta1;
	private int[] _delta2;
	private int i;
	public int searchPattern(String pattern, String phrase) 
	{
		_delta1 = buildDelta1(pattern);
		_delta2 = buildDelta2(pattern);		
		_compteur = 0;
		for(i = pattern.length()-1; i < phrase.length();) {

			if( this.equals(pattern, phrase) ) 
				return i+pattern.length();
		}
		return -1;
	}
	
	public boolean equals(String pattern, String phrase)
	{
		int debutPattern = i - pattern.length() + 1;
		if( debutPattern < 0 || i >= phrase.length() ) 
			return false;
		
		for(int j = pattern.length()-1; j >= 0; i--, j--) {
			_compteur++;
			if( pattern.charAt(j) != phrase.charAt(i) ) {	
				
				i += Math.max( _delta1[charCodeDelta1(phrase.charAt(i))], _delta2[j]);
				return false;
			}
				
		}
			
		return true;
	}
	
	public boolean equals(String pattern, String phrase, int i)
	{
		int debutPattern = i - pattern.length() + 1;
		if( debutPattern < 0 || i >= phrase.length() ) 
			return false;
		
		for(int j = pattern.length()-1; j >= 0; i--, j--) {
			_compteur++;
			if( pattern.charAt(j) != phrase.charAt(i) ) 
				return false;
				
		}
			
		return true;
	}

	public int[] buildDelta1(String pattern) 
	{
		int[] delta1 = new int[28];//Toutes les lettres de l'alphabet + '.' + '-'
		
		for(int i = 0; i < 28; i++) 
			delta1[i] = pattern.length();
		
		for(int i = 0; i < pattern.length(); i++) {
			int rangChar;
			if(pattern.charAt(i) == '-')
				rangChar = 27;
			else if(pattern.charAt(i) == '.')
				rangChar = 26;
			else {
				rangChar = ((int)pattern.charAt(i))- 65;
			}
			delta1[rangChar] = pattern.length()-i-1;
		}
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
	
	//Est-ce que le sous-pattern de j+1 à la fin et le sous-pattern de même longueur partant de k sont égaux sans compter les dépassement
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
	
	private void buildDeltasIfNull(String pattern) {
		if(_delta1 == null)
			_delta1 = buildDelta1(pattern);
		if(_delta2 == null)
			_delta2 = buildDelta2(pattern);
	}
	
	private int charCodeDelta1(char c) {
		if(c == '-')
			return 27;
		if(c == '.')
			return 26;
		
		return ((int)c) - 65;
	}
}
