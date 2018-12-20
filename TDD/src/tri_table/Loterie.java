package tri_table;

public class Loterie extends TrieurParTable<Integer> {

	public Loterie() {
		super(60);
	}
	
	public String tirage(Integer[] boules) {
		
		if(boules == null)
			return "";
		return affichageBoules(trier(boules));
	}

	private String affichageBoules(Integer[] boules) {
		String retour = "";
		for(int i = 0; i < boules.length; i++){
			retour += boules[i];
			if(i < boules.length -1)
				retour += " ";
		}
		
		return retour;
	}

	@Override
	protected int toValue(Integer elem) {
		return elem;
	}

	@Override
	protected Integer toItem(int i) {
		return (Integer)i;
	}
}
