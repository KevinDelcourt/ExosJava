package tp1;

import java.util.Collection;
import java.util.Hashtable;
import java.util.Map.Entry;
import java.util.Set;

public class TestMap {
	
	private Hashtable<Mot,Integer> hashtable = new Hashtable<Mot,Integer>();
	
	public void add(Mot m,int value) {	
		hashtable.put(m, value);
	}
	
	public void scan(String txt) {
		
		String[] mots = txt.toLowerCase().split(" ");
		
		for(int i = 0; i < mots.length; i++) 
			add( new Mot(mots[i]) , mots[i].length() );
		
	}
	
	public void affichageIterator() {
		
		for( Entry<Mot, Integer> entry : hashtable.entrySet()) 
			System.out.println( entry.getKey() + " de longueur " + entry.getValue() );
			
	}
	
	public boolean contains(Mot m) {
		
		return hashtable.containsKey(m);
	}
	
	public void remove(int value) {
		
		Collection<Integer> arr = hashtable.values();
			
		arr.remove( value );
			
	}
	
	public void remove(Mot key) {
		
		Set<Mot> arr = hashtable.keySet();
			
		arr.remove( key );
			
	}
	
	public static void main(String[] args) {
		
		TestMap test = new TestMap();
		
		test.scan("Le Lorem Ipsum est simplement du faux texte employ� dans la composition et la mise en page avant impression. Le Lorem Ipsum est le faux texte standard de l'imprimerie depuis les ann�es 1500, quand un imprimeur anonyme assembla ensemble des morceaux de texte pour r�aliser un livre sp�cimen de polices de texte. Il n'a pas fait que survivre cinq si�cles, mais s'est aussi adapt� � la bureautique informatique, sans que son contenu n'en soit modifi�. Il a �t� popularis� dans les ann�es 1960 gr�ce � la vente de feuilles Letraset contenant des passages du Lorem Ipsum, et, plus r�cemment, par son inclusion dans des applications de mise en page de texte, comme Aldus PageMaker.");
		
		System.out.println("Cl� \"et\" pr�sente? "+ test.contains( new Mot("et") ) );
		System.out.println("Cl� \"blob\" pr�sente? "+ test.contains( new Mot("blob") ) );
		
		test.affichageIterator();
		
		test.remove(12);
		test.remove(1);
		
		test.remove( new Mot("de") );

		test.add( new Mot("a_______________") , 2);
		
		test.affichageIterator();
		
		
		
	}
	
}
