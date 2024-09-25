package org.tcs;

import org.testng.Assert;
import org.testng.annotations.Test;

public class B {

	@Test
	private void tc1() {
		
	}
	@Test(retryAnalyzer = Failed.class)
	private void tc2() {
		Assert.assertTrue(false);
	}
	//when the methods gets failed it will go to the failed class form how many times re run the program
	@Test
	private void tc3() {
		
	}
	@Test(retryAnalyzer = Failed.class)
	private void tc4() {
		Assert.assertTrue(false);
	}
}
