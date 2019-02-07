package yahtzee;

public abstract class Category {
	
	public abstract int score(int[] roll);
	
	protected int numberOf(int filter, int[] roll) {
		int sum = 0;
		for(int i = 0; i < roll.length; i++)
			if(roll[i] == filter)
				sum++;
		return sum;
	}

}
