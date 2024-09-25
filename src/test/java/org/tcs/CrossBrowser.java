package org.tcs;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CrossBrowser extends BaseClass {
	
	@Parameters("browserName")
	@Test
	private void cross(String browserName) {
		switch (browserName) {
		case "chrome":
			chromeBrowserLaunch();
			enterApplnUrl("https://www.facebook.com/");
			WebElement emailBox = findLocatorById("email");
			elementSendKeys(emailBox, "prasanna");
			WebElement passBox = findLocatorById("pass");
			elementSendKeys(passBox, "prasa@123");
			
		break;
		case "firefox":
			firefoxBrowserLaunch();
			enterApplnUrl("https://www.facebook.com/");
			WebElement emailTxtBox = findLocatorById("email");
			elementSendKeys(emailTxtBox, "prasanna");
			WebElement passTxtBox = findLocatorById("pass");
			elementSendKeys(passTxtBox, "prasa@123");
		break;
		case "edge":
			edgeBrowserLaunch();
			enterApplnUrl("https://www.facebook.com/");
			WebElement txtEmail = findLocatorById("email");
			elementSendKeys(txtEmail, "prasanna");
			WebElement txtPass = findLocatorById("pass");
			elementSendKeys(txtPass, "prasa@123");
		break;	
		default:
			break;
		}
	}
	
}
