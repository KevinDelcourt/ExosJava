package exo7;

public class IndiceInvalide extends Exception {
	
	private static final long serialVersionUID = 1L;

    public IndiceInvalide(int i) {
        super ("indice " + i + " invalide");
    }
}
