package tri_table;

public class Loterie {

	public String tirage(int[] boules) {
		
		if(boules == null)
			return "";
		
		return affichageBoules(boules);
	}

	private String affichageBoules(int[] boules) {
		
		String retour = "";
		for(int i = 0; i < boules.length; i++)
		{
			retour += boules[i];
			if(i < boules.length -1)
				retour += " ";
		}
		
		return retour;
	}
}
