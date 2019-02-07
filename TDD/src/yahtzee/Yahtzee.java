package yahtzee;

import java.util.stream.IntStream;

public class Yahtzee extends Category {

	public int score(int[] roll) {
		if(IntStream.of(roll).distinct().count() == 1)
			return 50;
		
		return 0;
	}

}
