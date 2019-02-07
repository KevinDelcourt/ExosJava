package yahtzee;

import java.util.stream.IntStream;

public class Chance extends Category{

	public int score(int[] roll) {
		return IntStream.of(roll).sum();
	}
	
}
