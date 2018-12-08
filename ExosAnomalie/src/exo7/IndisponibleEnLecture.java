package exo7;

public class IndisponibleEnLecture extends Exception {
	
	private static final long serialVersionUID = 1;

    public IndisponibleEnLecture(int i) {
        super ("indice " + i + " indisponible en lecture.s");
    }
}
