package tri_table;

public abstract class TrieurParTable<ClasseATrier> {
	
	private int[] itemTri�s;
	
	public TrieurParTable(int cardinalDomaineD�finitionValeursATrier) {
		this.itemTri�s = new int[cardinalDomaineD�finitionValeursATrier];
	}
	
	protected ClasseATrier[] trier(ClasseATrier[] itemsNonTri�) {
		for(int i = 0; i < itemsNonTri�.length; i++) {
			addItem(toValue(itemsNonTri�[i]));
		}
		
		ClasseATrier[] retourTri� = itemsNonTri�;
		int rang_elem = 0;
		for(int i = 0; i < itemTri�s.length; i++) 
			for(int n = 0; n < itemTri�s[i];n++) {
				retourTri�[rang_elem] = toItem(i);
				rang_elem++;
			}	 
		
		return retourTri�;
	}
	
	private void addItem(int valeur) {
		itemTri�s[valeur]++;
	}
	
	protected abstract int toValue(ClasseATrier elem);
	
	protected abstract ClasseATrier toItem(int value);
}
