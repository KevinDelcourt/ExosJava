package tri_table;

public abstract class TrieurParTableCorrection {

	protected int[] itemTriés;

	public TrieurParTableCorrection(int cardinalDomaineDéfinitionValeursATrier) {
		this.itemTriés = new int[cardinalDomaineDéfinitionValeursATrier];
	}
	
	public void addItem(int valeur) {
		itemTriés[valeur]++;
	}
	
	public boolean itemTrouvé(int valeur) {
		return this.itemTriés[valeur] > 0;
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
			for(int i = curseur+1; i < itemTriés.length; i++) {
				if(itemTrouvé(i))
					return true;
			}
			return false;
		}
		
		public int next() {
			for(int i = curseur+1; i < itemTriés.length; i++) {
				if(itemTrouvé(i)) {
					curseur = i;
					return curseur;
				}
			}
			return -1;
		}
	}
}
