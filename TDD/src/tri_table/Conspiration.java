package tri_table;

public class Conspiration {

	private int[] tab = new int[26];
	
	public String tri(String string) {
		String chaineNonTri�e = enleverToutSaufMinuscule(string.toLowerCase());
		
		for(int i = 0; i < chaineNonTri�e.length();i ++) {
			int charCode = (int)chaineNonTri�e.charAt(i) - (int)'a';
			tab[charCode]++;
		}
		
		String chaineTri�e = "";
		
		for(int i = 0; i < tab.length; i++) {
			for(int n = 0; n < tab[i];n++)
				chaineTri�e += (char)('a' + i);
		}
		
		return chaineTri�e;
	}

	private boolean estMinuscule(char c) {
		
		int charValue = c;
		return (int)'a' <= charValue && (int)'z' >= charValue;
	}
	
	private String enleverToutSaufMinuscule(String string) {
		String resultat = "";
		for(int i = 0; i < string.length(); i++)
			if(estMinuscule(string.charAt(i)))
				resultat += string.charAt(i);
		
		return resultat;
	}
}
