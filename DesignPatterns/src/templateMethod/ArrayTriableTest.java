package templateMethod;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ArrayTriableTest extends ConteneurTriableTest {

	@Before
	public void setUp() throws Exception {
		this.test = new ArrayTriable(20);
		super.setUp();
	}


}
