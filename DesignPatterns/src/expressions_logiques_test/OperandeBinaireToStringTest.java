package expressions_logiques_test;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
	
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import expressions_logiques.And;
import expressions_logiques.Equivalence;
import expressions_logiques.Implication;
import expressions_logiques.Inhibition;
import expressions_logiques.OperandeBinaire;
import expressions_logiques.Or;
import expressions_logiques.VariableBooléenne;

@RunWith(Parameterized.class)
public class OperandeBinaireToStringTest{

	private OperandeBinaire ob;
	private String expected;
	
	public OperandeBinaireToStringTest(OperandeBinaire ob, String expected) {
		this.ob = ob;
		this.expected = expected;
	}
	
	@Parameters(name="{1}")
    public static Collection<Object[]> getParameters() {
        return Arrays.asList(new Object[][] {
        	{new And(),"(a.b)"},
        	
        	{new Or(),"(a+b)"},
        	
        	{new Implication(),"(a=>b)"},
        	
        	{new Inhibition(),"(a/b)"},
        	
        	{new Equivalence(),"(a<=>b)"}
        });
    }
    
    @Before
	public void setUp() throws Exception {
		this.ob.setOperandeGauche(null);
		this.ob.setOperandeDroit(null);
	}
    
	@Test
	public void testToStringPasOperande() {
		assertEquals("",this.ob.toString());
	}
	
	@Test
	public void testIsSatisfiablePasOperande() {
		assertFalse(this.ob.isSatisfiable());
	}
	
	@Test
	public void testToString() {
		this.ob.setOperandeGauche(new VariableBooléenne("a",""));
		this.ob.setOperandeDroit(new VariableBooléenne("b",""));
		assertEquals(this.expected,this.ob.toString());
	}

}



