package tp1;

import java.util.HashSet;

public class TestSet {
	
	private HashSet<Character> lettres = new HashSet<>();
	private HashSet<Character> voyelles = new HashSet<>();
	
	public TestSet() {
		
		voyelles.add('a');
		voyelles.add('e');
		voyelles.add('i');
		voyelles.add('o');
		voyelles.add('u');
		voyelles.add('y');		
	}
	
	public void init(String txt) {
		for(char ch: txt.toCharArray() ) {
			lettres.add(ch);
		}
	}
	
	public void affichage() {
		System.out.println( lettres );
	}
	
	public void affichage(String txt) {
		
		System.out.println( "\n"+txt );
		System.out.println( lettres );
	}
	
	public void removeVoyelles() {
		lettres.removeAll(voyelles);
	}
	
	public void retainVoyelles() {
		lettres.retainAll(voyelles);
	}
	
	
	
	public static void main(String[] args) {
		
		TestSet test = new TestSet();
		
		test.init( "ioirejgriigrogrooijoijeffjiijijryyyuuhfriugtgokof" );
		
		test.affichage("Avec voyelles:");
		
		test.removeVoyelles();
		
		test.affichage("Sans voyelles:");
	}

}
