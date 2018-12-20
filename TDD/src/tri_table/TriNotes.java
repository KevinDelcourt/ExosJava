package tri_table;

public class TriNotes extends TrieurParTable<Integer> {

	public TriNotes() {
		super(21);
	}

	public String triDesNotes(Integer[] notes) {
		if(notes == null)
			return "";
		
		Integer[] notesTriées = trier(notes);
		
		return affichageNotes(notesTriées);
			
	}

	private String affichageNotes(Integer[] notesTriées) {
		
		String affichage = "";
		int compteur = 0;
		int noteACompter = notesTriées[0];
		int i;
		for(i = 0; i < notesTriées.length; i++) {
			if(notesTriées[i] == noteACompter)
				compteur++;
			else {
				affichage += "("+compteur+","+noteACompter+")";
				noteACompter = notesTriées[i];
				compteur = 1;
			}
		}
		affichage += "("+compteur+","+notesTriées[i-1]+")";
		
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
