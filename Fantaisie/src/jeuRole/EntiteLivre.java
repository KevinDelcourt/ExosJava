package jeuRole;

import livre.Fichier;
import livre.Livre;

public abstract class EntiteLivre {
	
	static Livre livre;

	public static void setLivre(Livre livre) {
		EntiteLivre.livre = livre;
	}

	

}
