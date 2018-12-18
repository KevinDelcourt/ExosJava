package tri_table;

public abstract class TrieurParTable<T> {
	
	protected int[] tab;
	
	public TrieurParTable(int nbElem) {
		this.tab = new int[nbElem];
	}
	
	protected T[] trier(T[] elemNonTriť) {
		for(int i = 0; i < elemNonTriť.length; i++) {
			tab[toInt(elemNonTriť[i])]++;
		}
		
		T[] elemTriť = elemNonTriť;
		int rang_elem = 0;
		for(int i = 0; i < tab.length; i++) 
			for(int n = 0; n < tab[i];n++) {
				elemTriť[rang_elem] = toElem(i);
				rang_elem++;
			}	 
		
		return elemTriť;
	}
	
	protected abstract int toInt(T elem);
	
	protected abstract T toElem(int i);
}
