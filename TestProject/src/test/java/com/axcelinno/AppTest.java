package com.axcelinno;

import static org.junit.Assert.*;

import org.junit.Test;

public class AppTest {

	@Test
	public void test() {
		App test = new App();
		//fail("Not yet implemented");
		assertEquals("sample", test.sample());
		assertEquals(4, test.add(2, 2));
	}

	@Test
	public void notequals() {
		App test = new App();
		assertNotSame("fun", test.sample());
	}

}
