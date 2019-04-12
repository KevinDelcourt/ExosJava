package expressions_logiques_test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ AndTest.class, EquivalenceTest.class, ImplicationTest.class, InhibitionTest.class, NotTest.class,
		OperandeBinaireToStringTest.class, OrTest.class, VariableBooléenneTest.class })
public class AllTests {

}
