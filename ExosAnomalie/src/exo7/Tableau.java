package exo7;

import java.util.List;
import java.util.ArrayList;

public class Tableau<T> {
	
	private List<T> corps;
	
	public Tableau(int n) {
		this.corps = new ArrayList<T>();
		for (int i = 0; i < n; i++)
			this.corps.add(null);
	}
	
	public int nbElements() {
		return this.corps.size();
	}
	
	public T getIeme(int i) throws IndiceInvalide, IndisponibleEnLecture {	
		//assert this.existeIeme(i);
		if(this.existeIeme(i))
			return this.corps.get(i);
		
		throw new IndisponibleEnLecture(i);
	}
	
	public void setIeme(int i, T e) throws IndiceInvalide {
		if (i < 0 || i > this.corps.size() - 1)
			throw new IndiceInvalide(i);
		this.corps.set(i, e);
	}
	
	public boolean existeIeme(int i) throws IndiceInvalide{
		if (i < 0 || i > this.corps.size() - 1)
			throw new IndiceInvalide(i);
		return this.corps.get(i) != null;
	}
	
	public String toString() { 
		String s = "";
		for (int i = 0; i < this.corps.size(); i++)
			if (this.corps.get(i) != null)
				s += "tab[" + i + "] = " + this.corps.get(i) + "\n";
		return s;
	}
	
}
