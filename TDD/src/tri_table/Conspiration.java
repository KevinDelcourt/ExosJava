package tri_table;

public class Conspiration extends TrieurParTable<Character> {

	public Conspiration() {
		super(26);
	}
	
	public String tri(String string) {
		String chaineNonTriée = enleverToutSaufMinuscule(string.toLowerCase());
		Character[] charsNonTriés = new Character[chaineNonTriée.length()];
		for(int i = 0; i < chaineNonTriée.length(); i++) 
			charsNonTriés[i] = chaineNonTriée.charAt(i);
		
		Character[] charsTriés = trier(charsNonTriés);
		
		String ChaineTriée = "";
		for(int i = 0; i < charsTriés.length; i++) 
			ChaineTriée += charsTriés[i];
		
		return ChaineTriée;
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
