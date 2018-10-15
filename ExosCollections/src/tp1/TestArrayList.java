package tp1;

import java.util.ArrayList;

public class TestArrayList {
	
	private ArrayList<Mot> listeMot = new ArrayList<Mot>();

	private void addMot(Mot mot) {
		
		if( isPresent(mot)) {
			
			Mot m = listeMot.get( listeMot.lastIndexOf(mot) );
			m.incrementCountMot();
			
		}else 
			listeMot.add(mot);	
		
	}
	
	private boolean isPresent(Mot mot) {
		
		return listeMot.contains(mot);
	}
	
	public void scan(String txt) {
		
		String[] mots = txt.toLowerCase().split(" ");
		
		for(int i = 0; i < mots.length; i++) 
			addMot( new Mot(mots[i]) );
		
		
	}
	
	public String toString() {
		
		String output = "";
		
		if(listeMot.size() > 0) 
			for(Mot elem: listeMot) 
				output += elem.getMot() + " : " + elem.getCountMot() +"\n";				
		else
			output = "Liste vide !";
		
		return output;	
	}
	
	public boolean remove(Mot mot) {
		
		return listeMot.remove(mot);
		
	}
	
	public static void main(String[] args) {
		
		TestArrayList test = new TestArrayList();
		
		test.scan("Le Lorem Ipsum est simplement du faux texte employé dans la composition et la mise en page avant impression. Le Lorem Ipsum est le faux texte standard de l'imprimerie depuis les années 1500, quand un imprimeur anonyme assembla ensemble des morceaux de texte pour réaliser un livre spécimen de polices de texte. Il n'a pas fait que survivre cinq siècles, mais s'est aussi adapté à la bureautique informatique, sans que son contenu n'en soit modifié. Il a été popularisé dans les années 1960 grâce à la vente de feuilles Letraset contenant des passages du Lorem Ipsum, et, plus récemment, par son inclusion dans des applications de mise en page de texte, comme Aldus PageMaker.");
		
		System.out.println( test.toString() );
		
		test.remove(new  Mot("le"));
		
		System.out.println( "----- Sans \"le\" :" );
		System.out.println( test.toString() );
	}
}




