package expressions_logiques_test;


import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import expressions_logiques.OperandeBinaire;
import expressions_logiques.VariableBooléenne;

@RunWith(Parameterized.class)

public class OperandeBinaireTest{

	protected OperandeBinaire ob;

	private boolean gauche;
	private boolean droite;
	private boolean expected;
	
	public OperandeBinaireTest(boolean gauche, boolean droite, boolean expected) {
		this.gauche = gauche;
		this.droite = droite;
		this.expected = expected;
	}

	protected void setOperandesAvecValeurs(boolean valGauche, boolean valDroite) {
		VariableBooléenne gauche = new VariableBooléenne("a", "truc");
		VariableBooléenne droite = new VariableBooléenne("b", "machin");
		gauche.fixerValeurDeVérité(valGauche);
		droite.fixerValeurDeVérité(valDroite);
		this.ob.setOperandeGauche(gauche);
		this.ob.setOperandeDroit(droite);
	}
	
	@After
	public void tearDown() throws Exception {
		this.ob = null;
	}
	
	@Test
	public void testIsSatisfiable() {
		this.setOperandesAvecValeurs(this.gauche, this.droite);
		assertEquals(this.expected,this.ob.isSatisfiable());
	}

}
