package expressions_logiques;

import java.util.AbstractList;
import java.util.ArrayList;
public class TableDesSymboles {
	
	private AbstractList<VariableBooléenne> variables;
	
	public TableDesSymboles() {
		this.variables = new ArrayList<VariableBooléenne>();
	}
	
	public void addVariable (VariableBooléenne variable) {
		this.variables.add(variable);
	}
	
	public void fixerValeurDeVérité(boolean... values) {
		
		for (int i = 0; i < Math.min(values.length,variables.size()); i++)
			this.variables.get(i).fixerValeurDeVérité(values[i]);
		
	}
	
	public void fixerValeurDeVérité(int value, int nbVariables) {
		
		boolean[] listeParamètres = new boolean[nbVariables];
		int décalage = 0;
		do {
			int remainder = value % 2;
			listeParamètres[nbVariables-1-décalage++] = remainder == 1;
			value /= 2;
		} while (value != 0);
		
		this.fixerValeurDeVérité(listeParamètres);
	}
	
	public String interprétation(int numVariable) {
		return this.variables.get(numVariable).interprétation();
	}
}
