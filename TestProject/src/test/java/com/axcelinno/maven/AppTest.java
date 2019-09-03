package com.axcelinno.maven;

import static org.junit.Assert.*;

import org.junit.Test;

import com.axcellino.maven.App;

public class AppTest {

	/*
	 * need to import class before you can run a test
	 * */
	
	@Test
	public void test() {
		//fail("Not yet implemented");
		App test = new App();
		assertEquals("sample", test.sample());
		assertNotSame("fun", test.sample());
	}

}
