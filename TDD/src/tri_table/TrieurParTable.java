package tri_table;

public abstract class TrieurParTable<T> {
	
	protected int[] tab;
	
	public TrieurParTable(int nbElem) {
		this.tab = new int[nbElem];
	}
	
	protected T[] trier(T[] elemNonTrié) {
		for(int i = 0; i < elemNonTrié.length; i++) {
			tab[toInt(elemNonTrié[i])]++;
		}
		
		T[] elemTrié = elemNonTrié;
		int rang_elem = 0;
		for(int i = 0; i < tab.length; i++) 
			for(int n = 0; n < tab[i];n++) {
				elemTrié[rang_elem] = toElem(i);
				rang_elem++;
			}	 
		
		return elemTrié;
	}
	
	protected abstract int toInt(T elem);
	
	protected abstract T toElem(int i);
}
