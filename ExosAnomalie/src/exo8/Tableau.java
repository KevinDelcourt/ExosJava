package exo8;

import java.util.List;
import java.util.ArrayList;

public class Tableau<T> {
	
	private List<T> corps;
	
	private int nbElements;
	
	public Tableau(int n) {
		this.corps = new ArrayList<T>();
		this.nbElements = n;
		for (int i = 0; i < this.nbElements; i++)
			this.corps.add(null);
	}
	
	public int nbElements() {
		return this.nbElements;
	}
	
	public boolean existeIeme(int i) {
		assert i >= 0 && i <= this.nbElements - 1 : "indice " + i + " en dehors des bornes";
		return this.corps.get(i) != null;
	}
	
	public T getIeme(int i) {
		assert i >= 0 && i <= this.nbElements - 1 : "indice " + i + " en dehors des bornes";
		assert this.corps.get(i) != null : "élément d'indice " + i + " non significatif";
		return this.corps.get(i);
	}
	
	public void setIeme(int i, T e) {
		assert i >= 0 && i <= this.nbElements - 1 : "indice " + i + " en dehors des bornes";
		this.corps.set(i, e);
	}
	
	public String toString() { 
		String s = "";
		for (T e : this.corps)
			if (e != null)
				s += e;
		return s + "\n";
	}
	
}
