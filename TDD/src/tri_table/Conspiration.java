package tri_table;

public class Conspiration extends TrieurParTable<Character> {

	public Conspiration() {
		super(26);
	}
	
	public String tri(String string) {
		String chaineNonTriée = enleverToutSaufMinuscule(string.toLowerCase());
		Character[] charsNonTriés = stringToCharacterArray(chaineNonTriée);
		
		Character[] charsTriés = trier(charsNonTriés);
		
		return characterArrayToString(charsTriés);
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

	private Character[] stringToCharacterArray(String string) {
		Character[] retour = new Character[string.length()];
		
		for(int i = 0; i < string.length(); i++) {
			retour[i] = string.charAt(i);
		}
		
		return retour;
	}
	
	private String characterArrayToString(Character[] array) {
		String retour = "";
		
		for(int i = 0; i < array.length; i++) 
			retour += array[i];
		
		return retour;
	}
	
	@Override
	protected int toValue(Character elem) {
		return (int)elem - (int)'a';
	}

	@Override
	protected Character toItem(int i) {
		return (char)('a' + i);
	}

}
