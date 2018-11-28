package facteurs_premiers;

import java.util.ArrayList; import java.util.List; 

public class DecompositionEnFacteursPremiers { 
	
	List<Integer> factors;  
	public List<Integer> compute(int n) { 
		
		this.factors = new ArrayList<>();   
		int factor;
		
		for( int num = n ; num > 1; num /= factor) {
			
			for(factor = 2; num % factor != 0; factor++) {}
			factors.add(factor);

		}		 
		return factors;  
		
	}
	
}
