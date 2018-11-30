package tri_table;

public class Conspiration {

	public String tri(String string) {
		
		for(int i = 0; i < string.length(); i++) {
			if(estUneLettreMinuscule(string.charAt(i))){
				
			}
		}
		return string.toLowerCase();
	}

	public boolean estUneLettreMinuscule(char c) {
		
		int charValue = c;
		
		return charValue >= 1 && 26 <= charValue;
	}
}
