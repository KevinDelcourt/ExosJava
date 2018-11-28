package exo1;


public class Couple<T1, T2> {

	private T1 premier;
	private T2 second;

	public Couple(T1 premier, T2 second) {
		this.premier = premier;
		this.second  = second;
	}
	
	public void setPremier(T1 premier) {
		this.premier = premier;
	}
	
	public void setSecond(T2 second) {
		this.second = second;
	}
	
	public T1 getPremier() {
		return this.premier;
	}

	public T2 getSecond() {
		return this.second;
	}
	
}
