package primitiveLanguage;

/**
 * Classe Principale.
 * 
 * Sert à tester les méthodes et classes créées dans le TP
 * 
 * @author dlk1560a
 *
 */
public class Test {
	
	public static void main(String[] args) {
		
		Adresse a1 = new Adresse(8, "rue des oiseaux", 31400, "Toulouse");
		Adresse a2 = new Adresse(15, "boulevard de Strasbourg", 31000, "Toulouse");
		Adresse a3 = new Adresse(5, "route de toulouse", 31520, "Ramonville");
		
		Personne jeanDURAND = new Personne("DURAND","Jean", new Date(25,04,1960),a1 );
		Personne pierreDUPOND = new Personne("DUPOND","Pierre", new Date(25,04,1580),a2 );
		
		jeanDURAND.renseignement();	
		
		pierreDUPOND.renseignement();
		
		Banque banque = new Banque("La nouvelle Banque", a3 );
		
		
		Compte c1 = banque.ouvrir(jeanDURAND, new Date(13,11,2008));
		Compte c2 = banque.ouvrir(pierreDUPOND,  new Date(13,11,2009), (float)120.50);
		
		System.out.println( "\n"+c1 );
		System.out.println( "\n"+c2 );
		
		
		banque.virement(c2, c1, (float)500 );
		
		System.out.println( "\n"+c1 );
		System.out.println( "\n"+c2 );
		
		System.out.println( "\n Portefeuille : "+ banque.volumePortefeuille() +"€" );
	}
}
