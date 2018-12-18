package tri_table;

public abstract class TrieurParTable<T> {
	
	protected int[] tab;
	
	public TrieurParTable(int nbElem) {
		this.tab = new int[nbElem];
	}
	
	protected T[] trier(T[] elemNonTri�) {
		for(int i = 0; i < elemNonTri�.length; i++) {
			tab[toInt(elemNonTri�[i])]++;
		}
		
		T[] elemTri� = elemNonTri�;
		int rang_elem = 0;
		for(int i = 0; i < tab.length; i++) 
			for(int n = 0; n < tab[i];n++) {
				elemTri�[rang_elem] = toElem(i);
				rang_elem++;
			}	 
		
		return elemTri�;
	}
	
	protected abstract int toInt(T elem);
	
	protected abstract T toElem(int i);
}
