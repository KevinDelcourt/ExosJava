package yahtzee;

import java.util.Arrays;
import java.util.stream.IntStream;

public abstract class Straight extends Category {
	
	private int[] expected;
	
	Straight(int[] expected){
		this.expected = expected;
	}
	
	public int score(int[] roll) {
		if(Arrays.equals(IntStream.of(roll).sorted().toArray(), expected))
			return IntStream.of(roll).sum();
		
		return 0;
	}
	
}
