
public class FizzBuzz {

	
	public String getFizzOrBuzz(int i) {
		
		if( i % 15 == 0 )
			return "FizzBuzz";
		if( i % 5 == 0 )
			return "Buzz";
		if( i % 3 == 0 )
			return "Fizz";
		
		return ""+i;
		
	}
	
	public void affichageFizzBuzz(int max) {
		for(int i = 1; i <= max; i++) {
			System.out.println(getFizzOrBuzz(i));
		}
	}
	
	public static void main(String[] args) {
		FizzBuzz fb = new FizzBuzz();
		fb.affichageFizzBuzz(100);
	}
}
