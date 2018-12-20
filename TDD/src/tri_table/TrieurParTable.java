package tri_table;

public abstract class TrieurParTable<ClasseATrier> {
	
	private int[] itemTriés;
	
	public TrieurParTable(int cardinalDomaineDéfinitionValeursATrier) {
		this.itemTriés = new int[cardinalDomaineDéfinitionValeursATrier];
	}
	
	protected ClasseATrier[] trier(ClasseATrier[] itemsNonTrié) {
		for(int i = 0; i < itemsNonTrié.length; i++) {
			addItem(toValue(itemsNonTrié[i]));
		}
		
		ClasseATrier[] retourTrié = itemsNonTrié;
		int rang_elem = 0;
		for(int i = 0; i < itemTriés.length; i++) 
			for(int n = 0; n < itemTriés[i];n++) {
				retourTrié[rang_elem] = toItem(i);
				rang_elem++;
			}	 
		
		return retourTrié;
	}
	
	private void addItem(int valeur) {
		itemTriés[valeur]++;
	}
	
	protected abstract int toValue(ClasseATrier elem);
	
	protected abstract ClasseATrier toItem(int value);
}
