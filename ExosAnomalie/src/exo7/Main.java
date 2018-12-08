package exo7;

public class Main {

	public static void main(String[] args) {
		try {
			final int N = 10;
			Tableau<Integer> tab = new Tableau<Integer>(N);
			for (int i = 0; i < N-1; i++)
			{
				if (i % 2 == 0)
					tab.setIeme(i, i);
				else 
					tab.setIeme(i, -i);
			}
				
			int nb = 0;
			int compare;
			for (int i = 1; i < N; i++) {
				compare = tab.getIeme(i).compareTo(tab.getIeme(0));

				if (compare > 0) 
					nb++;
			}
			System.out.println(nb + " éléments sont plus grand que tab[0]");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
