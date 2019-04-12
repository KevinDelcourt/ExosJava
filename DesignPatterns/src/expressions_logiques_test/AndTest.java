package expressions_logiques_test;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runners.Parameterized.Parameters;

import expressions_logiques.And;
import expressions_logiques.VariableBooléenne;

public class AndTest extends OperandeBinaireTest{
	
	public AndTest(boolean gauche, boolean droite, boolean expected) {
		super(gauche, droite, expected);
	}

	@Before
	public void setUp() throws Exception {
		this.ob = new And();
	}
	
	@Parameters(name = "{0} And {1} : {2}")
    public static Collection<Object[]> getTableDeVeriteAnd() {
        return Arrays.asList(new Object[][] {
        	{false,false,false},
        	
        	{false,true,false},
        	
        	{true,false,false},
        	
        	{true,true,true}
        });
    }

}
