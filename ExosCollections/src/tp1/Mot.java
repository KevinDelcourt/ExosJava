package tp1;

public class Mot {
	
	private String mot;
	private int countMot = 1;
	
	public Mot(String mot) {
		
		this.mot = mot;

	}

	public int getCountMot() {
		return countMot;
	}

	public void incrementCountMot() {
		countMot++;
	}

	public String getMot() {
		return mot;
	}

	@Override
	public boolean equals(Object o) {
		
		if ( !(o instanceof Mot) ) {
            return false;
        }
		
		Mot mot = (Mot)o;
		
		return mot.getMot().equals(this.getMot());
	}
}
