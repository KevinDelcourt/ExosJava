package expressions_logiques;

import java.util.AbstractList;
import java.util.ArrayList;
public class TableDesSymboles {
	
	private AbstractList<VariableBool�enne> variables;
	
	public TableDesSymboles() {
		this.variables = new ArrayList<VariableBool�enne>();
	}
	
	public void addVariable (VariableBool�enne variable) {
		this.variables.add(variable);
	}
	
	public void fixerValeurDeV�rit�(boolean... values) {
		
		for (int i = 0; i < Math.min(values.length,variables.size()); i++)
			this.variables.get(i).fixerValeurDeV�rit�(values[i]);
		
	}
	
	public void fixerValeurDeV�rit�(int value, int nbVariables) {
		
		boolean[] listeParam�tres = new boolean[nbVariables];
		int d�calage = 0;
		do {
			int remainder = value % 2;
			listeParam�tres[nbVariables-1-d�calage++] = remainder == 1;
			value /= 2;
		} while (value != 0);
		
		this.fixerValeurDeV�rit�(listeParam�tres);
	}
	
	public String interpr�tation(int numVariable) {
		return this.variables.get(numVariable).interpr�tation();
	}
}
