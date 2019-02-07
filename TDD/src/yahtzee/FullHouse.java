package yahtzee;

import java.util.function.IntPredicate;
import java.util.stream.IntStream;

public class FullHouse extends Category {

	public int score(int[] roll) {
		if(IntStream.of(roll).distinct().count() == 2) {
			int numberOfFirst = numberOf(roll[0],roll);
			if(numberOfFirst == 2 || numberOfFirst == 3)
				return IntStream.of(roll).sum();

		}
		
		return 0;
	}

}
