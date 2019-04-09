package templateMethod;

public class ArrayTriable extends ConteneurTriable {

	private MyComparable[] data;
	private int NbElements;

	public ArrayTriable(int size) {
		this.data = new MyComparable[size];
		this.NbElements = 0;
	}

	public int getLength() {
		return this.NbElements;
	}

	protected MyComparable getElement(int j) {
		return data[j];
	}

	protected void setElement(int j, MyComparable element) {
		data[j] = element;
	}


	public boolean addElement(MyComparable element) {
		if (this.NbElements <= this.data.length) {
			this.data[NbElements] = element;
			this.NbElements+= 1;
			return true;
		}
		return false;
	}


}
