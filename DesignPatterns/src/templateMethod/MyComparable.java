package templateMethod;

public abstract class MyComparable {
	
	public abstract boolean egal(MyComparable mc);
	
	public abstract boolean inferieur(MyComparable mc);
	
	public boolean inferieurOuEgal(MyComparable mc) {
		return egal(mc) || inferieur(mc);
	}
	
	public boolean superieur(MyComparable mc) {
		return !inferieurOuEgal(mc);
	}
	
	public boolean superieurOuEgal(MyComparable mc) {
		return !inferieur(mc);
	}
}
