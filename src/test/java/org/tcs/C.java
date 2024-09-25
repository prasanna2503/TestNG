package org.tcs;

import org.testng.Assert;
import org.testng.annotations.Test;

public class C {
	
	@Test
	private void tc1() {
		
	}
	@Test
	private void tc2() {
		Assert.assertTrue(true);
	}
	//when the methods gets failed it will go to the listners tag in .xml file and then go to FailedAll class to set the re run count in failed class form how many times re run the program
	@Test
	private void tc3() {
		
	}
	@Test
	private void tc4() {
		Assert.assertTrue(false);
	}
}
