package expressions_logiques_test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runners.Parameterized.Parameters;

import expressions_logiques.Or;
import expressions_logiques.VariableBooléenne;

public class OrTest extends OperandeBinaireTest {
	
	public OrTest(boolean gauche, boolean droite, boolean expected) {
		super(gauche, droite, expected);
		// TODO Auto-generated constructor stub
	}

	@Before
	public void setUp() throws Exception {
		this.ob = new Or();
	}
	
	@Parameters(name = "{0} Or {1} : {2}")
    public static Collection<Object[]> getTableDeVeriteOr() {
        return Arrays.asList(new Object[][] {
        	{false,false,false},
        	
        	{false,true,true},
        	
        	{true,false,true},
        	
        	{true,true,true}
        });
    }
}
