package templateMethod;

import java.util.LinkedList;
import java.util.List;

public class MyString extends MyComparable {

	public List<Character> data;
	
	public MyString(String s) {
		this.data = new LinkedList<Character>();
			for (int i = 0; i < s.length(); i++)
				this.data.add(i, Character.toLowerCase(s.charAt(i)));
	}

	public boolean egal(MyComparable mc) {
		if(mc instanceof MyString) 
			return ( data.size() == ((MyString)mc).data.size()) && data.equals(((MyString)mc).data);
		
		throw new ClassCastException();
	}

	public boolean inferieur(MyComparable mc) {
		if(!(mc instanceof MyString)) 
			throw new ClassCastException();
		
		MyString another = (MyString)mc;
		
		for(int i = 0; i < Math.min(data.size(), another.data.size()) ; i++) 
			if(this.data.get(i) != another.data.get(i))
				return this.data.get(i) < another.data.get(i);
		
		
		return this.data.size() < another.data.size();
	}

}
