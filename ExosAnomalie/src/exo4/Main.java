package exo4;

public class Main {

	public static void main(String[] args) {
		try {
			Entree entree = new Entree();
			entree.lire3Essais();
			System.out.println ("valeur = " + entree.getValeur());
		}
		catch (Exception ex) {
			System.out.println("Plus d'essais possible!");
		}
	}
}
