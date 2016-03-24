package testsearch;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestClass {
	protected int val1, val2;

	@Before
	public void setup(){
		val1 = 2;
		val2 = 3;
	}
	
	@Test
	public void searchAet() {
		double r = val1 +val2;
		assertTrue(r == 5);
	}
	
	@Test
	public void searchDep() {
		double r = val1 +val2;
		assertTrue(r == 6);
	}

}
