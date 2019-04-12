package expressions_logiques_test;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.runners.Parameterized.Parameters;

import expressions_logiques.Inhibition;

public class InhibitionTest extends OperandeBinaireTest {

	public InhibitionTest(boolean gauche, boolean droite, boolean expected) {
		super(gauche, droite, expected);
	}

	@Before
	public void setUp() throws Exception {
		this.ob = new Inhibition();
	}

	@Parameters(name = "{0} Inhibe {1} : {2}")
    public static Collection<Object[]> getTableDeVeriteInhibition() {
        return Arrays.asList(new Object[][] {
        	{false,false,false},
        	
        	{true,false,true},
        	
        	{false,true,false},
        	
        	{true,true,false}
        });
    }

}
