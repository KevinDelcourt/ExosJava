package exo3;

public class Main {

	public static void main (String[] args) {
		try {
			Chronometre c = new Chronometre(new Naturel(1), new Naturel(20), new Naturel(35));
			c.compteARebours();
		}
		catch (ConstraintError e) {
			System.out.println ("valeurs incorrectes");
		}
	}
}
