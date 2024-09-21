package org.tcs;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Sample extends BaseClass {
	
	@BeforeClass
	private void beforeClass() {
		browserLaunch();
		maximizeWindow();
		enterApplnUrl("https://adactinhotelapp.com/");
		implicitWait();
	}
	
	@AfterClass
	private void afterClass() {
		closeApplnWindow();
	}
	
	@BeforeMethod
	private void beforeMethod() {
		System.out.println("Start Time:" +System.currentTimeMillis());
	}
	
	@AfterMethod
	private void afterMethod() {
		System.out.println("End Time:" +System.currentTimeMillis());
	}
	
	@Test
	private void login() throws IOException {
		WebElement uesrTxt = findLocatorById("username");
		elementSendKeys(uesrTxt, getCellData("Sheet1", 1, 0));
		
		WebElement passTxt = findLocatorById("password");
		elementSendKeys(passTxt, getCellData("Sheet1", 1, 1));
		
		WebElement btnLogin = findLocatorById("login");
		elementClick(btnLogin);
	}
}

