package tri_table;

public class Loterie {

	private int[] tab;
	
	public Loterie() {
		tab = new int[60];
	}
	
	public String tirage(int[] boules) {
		
		if(boules == null)
			return "";
		
		triBoules(boules);
		return affichageBoules(boules);
	}

	private void triBoules(int[] boules) {
		
		for(int i = 0; i < boules.length; i++) 
			tab[boules[i]] = 1;
		
		for(int n_tab = 0,n_boule = 0; n_tab < tab.length && n_boule < boules.length; n_tab++) 		
			if(tab[n_tab] == 1) {
				boules[n_boule] = n_tab;
				n_boule++;
			}
		
	}

	private String affichageBoules(int[] boules) {
		
		String retour = "";
		for(int i = 0; i < boules.length; i++){
			retour += boules[i];
			if(i < boules.length -1)
				retour += " ";
		}
		
		return retour;
	}
}
