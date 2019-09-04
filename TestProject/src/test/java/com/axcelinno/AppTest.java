package com.axcelinno;

import static org.junit.Assert.*;

import org.junit.Test;

public class AppTest {

	@Test
	public void test() {
		App test = new App();
		//fail("Not yet implemented");
		assertEquals("sample", test.sample());
		assertEquals(25, test.newfeature());
	}
	
	@Test
	public void notequals() {
		App test = new App();
		assertNotSame("fun", test.sample());
	}

}
