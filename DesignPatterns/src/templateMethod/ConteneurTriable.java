package templateMethod;

public abstract class ConteneurTriable {

	protected abstract boolean addElement(MyComparable element);
	
	public abstract int getLength();
	
	protected abstract MyComparable getElement(int j);

	protected abstract void setElement(int j, MyComparable element);

	
	public void trier() {
		int i = this.getLength();
		boolean echange = true;
		while(i>0 && echange) {
			echange = false;
			for(int j = 0; j < i-1; j++) 
				if(this.getElement(j).superieur(this.getElement(j+1)) ) {
					echange = true;
					MyComparable tmp = this.getElement(j);
					this.setElement(j,this.getElement(+1));
					this.setElement(j+1, tmp);
				}
			i--;
		}
	}

}
