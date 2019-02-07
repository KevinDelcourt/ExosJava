package yahtzee;

import java.util.stream.IntStream;

public abstract class Simples extends Category {

	private int value;
	
	Simples(int value){
		this.value = value;
	}
	
	public int score(int[] roll) {
		return (int) IntStream.of(roll).filter(x -> x == value).count()*value;
	}
}
