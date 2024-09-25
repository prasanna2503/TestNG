package com.task;

import java.io.IOException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.tcs.BaseClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GroceryTask extends BaseClass {
	
	@BeforeClass
	private void beforeClass() {
		chromeBrowserLaunch();
		maximizeWindow();
		enterApplnUrl("https://www.omrbranch.com/");
		implicitWait(60);
	}
	
	@AfterClass(enabled = false)
	private void afterClass() {
		closeApplnWindow();
	}
	
	@BeforeMethod(enabled = false)
	private void beforeMethod() {
		System.out.println("Start Time:" +System.currentTimeMillis());
	}
	
	@AfterMethod(enabled = false)
	private void afterMethod() {
		System.out.println("End Time:"+System.currentTimeMillis());
	}
	
	@Test
	private void tc1() throws IOException {
		
		WebElement emailBox = findLocatorById("email");
		elementSendKeys(emailBox, getCellData("Sheet1", 1, 0));
		
		WebElement password = findLocatorById("pass");
		elementSendKeys(password, getCellData("Sheet1", 1, 1));
		
		WebElement loginBtn = findLocatorByXpath("//button[@value='login']");
		elementClick(loginBtn);
	}
	
	@Test
	private void tc2() throws IOException {
		WebElement productSearch = findLocatorById("search");
		insertDataAndEnter(productSearch, getCellData("Sheet1",1, 2));
		
		WebElement addProduct = findLocatorByXpath("(//a[text()='Add'])[1]");
		elementClick(addProduct);
		
		WebElement productModal = findLocatorByClassName("modal_form");
		visbilityOfElement(productModal);
		
		WebElement addToCart = findLocatorByXpath("(//button[text()='Add'])[1]");
		elementClick(addToCart);
	}
	
	@Test
	private void tc3() {
		WebElement cartBody = findLocatorById("cart_innerbox_main");
		visbilityOfElement(cartBody);
		
		WebElement goToCartBtn = findLocatorByXpath("//a[text()=' Go To Cart ']");
		elementClick(goToCartBtn);
	}
	
	@Test
	private void tc4() throws IOException, InterruptedException {
		WebElement addAddress = findLocatorByClassName("addAddress");
		elementClick(addAddress);
		
		WebElement addAddressTitle = findLocatorById("addaddressTitle");
		visbilityOfElement(addAddressTitle);
		
		WebElement addressType = findLocatorById("address_type");
		selectOptionByIndex(addressType, 4);
		
		WebElement firstName = findLocatorByName("first_name");
		elementSendKeys(firstName, getCellData("Sheet1", 1, 3));
		
		WebElement lastName = findLocatorByName("last_name");
		elementSendKeys(lastName, getCellData("Sheet1", 1, 4));
		
		WebElement mobile = findLocatorByName("mobile");
		elementSendKeys(mobile, getCellData("Sheet1", 1, 5));
		
		WebElement apartment = findLocatorByName("apartment");
		elementSendKeys(apartment, getCellData("Sheet1", 1, 6));
		
		WebElement addrress = findLocatorByName("address");
		elementSendKeys(addrress, getCellData("Sheet1", 1, 7));
		
		WebElement state = findLocatorByName("state");
		selectOptionByIndex(state, 2);
		
		WebElement city = findLocatorByName("city");
		selectOptionByValue(city, "266");
		
		WebElement pincode = findLocatorByName("zipcode");
		elementSendKeys(pincode, getCellData("Sheet1", 1, 8));
		
		WebElement saveAddress = findLocatorByClassName("saveAddress");
		elementClick(saveAddress);
		Thread.sleep(1000);
	}
	
	@Test
	private void tc5() throws IOException, InterruptedException {
		WebElement paymentType = findLocatorById("payment_type");
		selectOptionByIndex(paymentType, 1);
		Thread.sleep(1000);
		WebElement cardType = findLocatorByXpath("//label[text()=' Visa ']");
		elementClick(cardType);
		
		WebElement cardNum = findLocatorByName("card_no");
		elementSendKeys(cardNum, getCellData("Sheet1", 1, 9));
		
		WebElement month = findLocatorById("month");
		selectOptionByIndex(month, 12);
		
		WebElement year = findLocatorById("year");
		selectOptionByIndex(year, 7);
		
		WebElement cvv = findLocatorByName("cvv");
		elementSendKeys(cvv, getCellData("Sheet1", 1, 10));
	}
	
	@Test
	private void tc6() {
		WebElement placeOrder = findLocatorById("placeOrder");
		elementClick(placeOrder);
	}
	
	@Test
	private void tc7() throws IOException {
		WebElement emailBox = findLocatorById("email");
		elementSendKeys(emailBox, getCellData("Sheet1", 1, 0));
		
		WebElement password = findLocatorById("pass");
		elementSendKeys(password, getCellData("Sheet1", 1, 1));
		
		WebElement loginBtn = findLocatorByXpath("//button[@value='login']");
		elementClick(loginBtn);
	}
	
	@Test
	private void tc8() {
		WebElement profile = findLocatorByXpath(" //a[contains(text(),'Welcome')]");
		elementClick(profile);
		
		WebElement myAccount = findLocatorByXpath("//a[text()='My Account']");
		elementClick(myAccount);
	}
	
	@Test
	private void tc9() throws InterruptedException {
		WebElement ordersTab = findLocatorById("v-pills-orders-tab");
		elementClick(ordersTab);
		Thread.sleep(2000);
		WebElement moreDetails = findLocatorByXpath("(//a[text()='More Details'])[1]");
		elementClick(moreDetails);
		Thread.sleep(2000);	
	}
	
	@Test
	private void tc10() throws IOException, InterruptedException {
			
		WebElement orderText = findLocatorByXpath("//p[text()='Order No: ']");
		String orderNo = elementGetText(orderText);
		createCellAndSetCellData("Sheet1", 1, 11, orderNo);
		
	}
	
	
	
}
