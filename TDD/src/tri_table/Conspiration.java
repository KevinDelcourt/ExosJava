package tri_table;

public class Conspiration {

	private int[] tab = new int[26];
	
	public String tri(String string) {
		String chaineNonTriée = enleverToutSaufMinuscule(string.toLowerCase());
		
		for(int i = 0; i < chaineNonTriée.length();i ++) {
			int charCode = (int)chaineNonTriée.charAt(i) - (int)'a';
			tab[charCode]++;
		}
		
		String chaineTriée = "";
		
		for(int i = 0; i < tab.length; i++) {
			for(int n = 0; n < tab[i];n++)
				chaineTriée += (char)('a' + i);
		}
		
		return chaineTriée;
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
