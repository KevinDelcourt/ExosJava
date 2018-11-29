package tri_table;

public class Loterie {

	public String tirage(int[] boules) {
		
		if(boules == null)
			return "";
		
		triBoules(boules);
		return affichageBoules(boules);
	}

	private void triBoules(int[] boules) {
		boolean tableauTrié;
		do {
			tableauTrié = true;
			for(int i = 0; i < boules.length-1; i++) 
				if(boules[i] > boules[i+1]) {
					tableauTrié = false;
					int n = boules[i];
					boules[i] = boules[i+1];
					boules[i+1] = n;
				}
			
		}while(!tableauTrié);
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
