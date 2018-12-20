package tri_table;

public class TriNotes extends TrieurParTable<Integer> {

	public TriNotes() {
		super(21);
	}

	public String triDesNotes(Integer[] notes) {
		if(notes == null)
			return "";
		
		Integer[] notesTri�es = trier(notes);
		
		return affichageNotes(notesTri�es);
			
	}

	private String affichageNotes(Integer[] notesTri�es) {
		
		String affichage = "";
		int compteur = 0;
		int noteACompter = notesTri�es[0];
		int i;
		for(i = 0; i < notesTri�es.length; i++) {
			if(notesTri�es[i] == noteACompter)
				compteur++;
			else {
				affichage += "("+compteur+","+noteACompter+")";
				noteACompter = notesTri�es[i];
				compteur = 1;
			}
		}
		affichage += "("+compteur+","+notesTri�es[i-1]+")";
		
		return affichage;
	}
	
	@Override
	protected int toValue(Integer elem) {
		return elem;
	}

	@Override
	protected Integer toItem(int value) {
		return value;
	}

}
