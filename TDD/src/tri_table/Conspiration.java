package tri_table;

public class Conspiration {

	public String tri(String string) {
		String chaineNonTri�e = enleverToutSaufMinuscule(string.toLowerCase());
		
		return chaineNonTri�e;
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
