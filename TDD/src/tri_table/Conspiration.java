package tri_table;

public class Conspiration extends TrieurParTable<Character> {

	public Conspiration() {
		super(26);
	}
	
	public String tri(String string) {
		String chaineNonTri�e = enleverToutSaufMinuscule(string.toLowerCase());
		Character[] charsNonTri�s = new Character[chaineNonTri�e.length()];
		for(int i = 0; i < chaineNonTri�e.length(); i++) 
			charsNonTri�s[i] = chaineNonTri�e.charAt(i);
		
		Character[] charsTri�s = trier(charsNonTri�s);
		
		String ChaineTri�e = "";
		for(int i = 0; i < charsTri�s.length; i++) 
			ChaineTri�e += charsTri�s[i];
		
		return ChaineTri�e;
	}

	private boolean estMinuscule(char c) {
		return (int)'a' <= c && (int)'z' >= c;
	}
	
	private String enleverToutSaufMinuscule(String string) {
		String resultat = "";
		for(int i = 0; i < string.length(); i++)
			if(estMinuscule(string.charAt(i)))
				resultat += string.charAt(i);
		
		return resultat;
	}

	@Override
	protected int toInt(Character elem) {
		return (int)elem - (int)'a';
	}

	@Override
	protected Character toElem(int i) {
		return (char)('a' + i);
	}

}
