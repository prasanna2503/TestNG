package org.tcs;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Hello {
	
	@DataProvider(name="data")
	private Object[][] testData() {
		Object[][] obj = new Object[][] {{"kprasanna2406@gmail.com","Lovely@0612"},{"arun@gmail.com","Lovely@0612"},
			{"bala@gmail.com","Lovely@0612"},{"v@gmail.com","Lovely@0612"}};
		return obj;
	}
	
}
