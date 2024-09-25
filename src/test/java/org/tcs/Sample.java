package org.tcs;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Sample extends BaseClass {
	
	@BeforeClass
	private void beforeClass() {
		chromeBrowserLaunch();
		maximizeWindow();
		enterApplnUrl("https://adactinhotelapp.com/");
		implicitWait();
	}
	
	
	@AfterClass(enabled = false)
	private void afterClass() {
		closeApplnWindow();
	}
	
	
	@Test(dataProvider = "data",dataProviderClass = Hello.class)
	private void login(String username,String password) throws IOException {
		WebElement uesrTxt = findLocatorById("username");
		elementSendKeys(uesrTxt, username);
		
		WebElement passTxt = findLocatorById("password");
		elementSendKeys(passTxt, password);
		
		WebElement btnLogin = findLocatorById("login");
		elementClick(btnLogin);
	}	 
}

