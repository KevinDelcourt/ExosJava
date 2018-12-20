package tri_table;

public abstract class TrieurParTableCorrection {

	protected int[] itemTri�s;

	public TrieurParTableCorrection(int cardinalDomaineD�finitionValeursATrier) {
		this.itemTri�s = new int[cardinalDomaineD�finitionValeursATrier];
	}
	
	public void addItem(int valeur) {
		itemTri�s[valeur]++;
	}
	
	public boolean itemTrouv�(int valeur) {
		return this.itemTri�s[valeur] > 0;
	}
	
	public ItemIterator iterator() {
		return new ItemIterator();
	}
	
	public class ItemIterator{
		
		private int curseur;
		
		public ItemIterator() {
			this.curseur = -1;
		}
		
		public boolean hasNext() {
			for(int i = curseur+1; i < itemTri�s.length; i++) {
				if(itemTrouv�(i))
					return true;
			}
			return false;
		}
		
		public int next() {
			for(int i = curseur+1; i < itemTri�s.length; i++) {
				if(itemTrouv�(i)) {
					curseur = i;
					return curseur;
				}
			}
			return -1;
		}
	}
}
