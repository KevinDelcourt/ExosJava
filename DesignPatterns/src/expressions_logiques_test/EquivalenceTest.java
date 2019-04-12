package expressions_logiques_test;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.runners.Parameterized.Parameters;

import expressions_logiques.Equivalence;

public class EquivalenceTest extends OperandeBinaireTest {

	public EquivalenceTest(boolean gauche, boolean droite, boolean expected) {
		super(gauche, droite, expected);
	}

	@Before
	public void setUp() throws Exception {
		this.ob = new Equivalence();
	}

	@Parameters(name = "{0} équivalent à {1} : {2}")
    public static Collection<Object[]> getTableDeVeriteEquivalence() {
        return Arrays.asList(new Object[][] {
        	{false,false,true},
        	
        	{true,false,false},
        	
        	{false,true,false},
        	
        	{true,true,true}
        });
    }

}
