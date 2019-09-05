package com.axcelinno;

import static org.junit.Assert.*;

import org.junit.Test;

public class AppTest {

	@Test
	public void test() {
		App test = new App();
		//fail("Not yet implemented");
		assertEquals("sample", test.sample());
<<<<<<< HEAD
		assertEquals(4, test.add(2, 2));
=======
		assertEquals(25, test.newfeature());
		
>>>>>>> develop
	}

	@Test
	public void notequals() {
		App test = new App();
		assertNotSame("fun", test.sample());
	}

}
