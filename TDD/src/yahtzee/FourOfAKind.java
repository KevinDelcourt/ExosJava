package yahtzee;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

public class FourOfAKind extends Category{

	@Override
	public int score(int[] roll) {


		if(IntStream.of(roll).distinct().count() == 2) {
			int numberOfFirst = numberOf(roll[0],roll);
			if(numberOfFirst == 1 || numberOfFirst == 4)
				return IntStream.of(roll).sum();

		}		
		return 0;
	}

}
