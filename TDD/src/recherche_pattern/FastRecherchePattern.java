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

	public int[] buildDelta1(String pattern) {
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
				rangChar = (int)pattern.charAt(i)- 65;
			}
			delta1[rangChar] = pattern.length()-i;
		}
		return delta1;
	}

	public int[] buildDelta2(String pattern) {
		int[] delta2 = new int[pattern.length()];
		
		for(int j = 0; j < pattern.length(); j++) {
			int k;
			for(k = pattern.length() - 1; 
				!unify(pattern,k,j) || (k>=1 && pattern.charAt(k-1) == pattern.charAt(j)); 
				k--) {}
			delta2[j] = pattern.length() - k ;
		}
		
		return delta2;
	}
	
	//Est-ce que le sous-pattern de j+1 à la fin et le sous-pattern
	private boolean unify(String pattern, int k, int j) {
		
		boolean unify = true;
		for(int x = 0; x < pattern.length() - j - 1 ; x++) {
			try {
				unify = unify && pattern.charAt(x+j+1) == pattern.charAt(x+k);
			}catch(StringIndexOutOfBoundsException e) {}
		}
		
		return unify;
	}
}
