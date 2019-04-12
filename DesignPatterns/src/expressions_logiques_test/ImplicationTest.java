package expressions_logiques_test;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runners.Parameterized.Parameters;

import expressions_logiques.Implication;
import expressions_logiques.VariableBooléenne;

public class ImplicationTest extends OperandeBinaireTest {

	public ImplicationTest(boolean gauche, boolean droite, boolean expected) {
		super(gauche, droite, expected);
	}

	@Before
	public void setUp() throws Exception {
		this.ob = new Implication();
	}

	@Parameters(name = "{0} Implique {1} : {2}")
    public static Collection<Object[]> getTableDeVeriteImplication() {
        return Arrays.asList(new Object[][] {
        	{false,false,true},
        	
        	{false,true,true},
        	
        	{true,false,false},
        	
        	{true,true,true}
        });
    }

}
