package org.tcs;

	import java.io.File;
	import java.io.FileInputStream;
	import java.io.FileOutputStream;
	import java.io.IOException;
	import java.text.SimpleDateFormat;
	import java.time.Duration;
	import java.util.ArrayList;
	import java.util.Date;
	import java.util.List;
	import java.util.Set;

	import org.apache.commons.io.FileUtils;
	import org.apache.poi.ss.usermodel.Cell;
	import org.apache.poi.ss.usermodel.CellType;
	import org.apache.poi.ss.usermodel.DateUtil;
	import org.apache.poi.ss.usermodel.Row;
	import org.apache.poi.ss.usermodel.Sheet;
	import org.apache.poi.ss.usermodel.Workbook;
	import org.apache.poi.xssf.usermodel.XSSFWorkbook;
	import org.openqa.selenium.By;
	import org.openqa.selenium.JavascriptExecutor;
	import org.openqa.selenium.OutputType;
	import org.openqa.selenium.TakesScreenshot;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.interactions.Actions;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.Select;
	import org.openqa.selenium.support.ui.WebDriverWait;

	public class BaseClass {
		
		WebDriver driver;
		Select select;
		Actions actions;
		
		
		public void createCellAndSetCellData(String sheetName, int rownum, int cellnum, String data) throws IOException {
			File file = new File("C:\\Users\\LENOVO\\eclipse-workspace\\TestNGPractice\\Excel\\TestData.xlsx");
			FileInputStream fileInputStream = new FileInputStream(file);
			Workbook workbook = new XSSFWorkbook(fileInputStream);
			Sheet sheet = workbook.getSheet(sheetName);
			Row row = sheet.getRow(rownum);
			Cell cell = row.createCell(cellnum);
			cell.setCellValue(data);
			FileOutputStream fileOutputStream = new FileOutputStream(file);
			workbook.write(fileOutputStream);
		}

		
		public void updateCellData(String sheetName, int rownum, int cellnum, String oldData, String newData) throws IOException {
			File file = new File(
					"C:\\Users\\LENOVO\\eclipse-workspace\\TestNGPractice\\Excel\\TestData.xlsx");
			FileInputStream fileInputStream = new FileInputStream(file);
			Workbook workbook = new XSSFWorkbook(fileInputStream);
			Sheet sheet = workbook.getSheet(sheetName);
			Row row = sheet.getRow(rownum);
			Cell cell = row.getCell(cellnum);
			String value = cell.getStringCellValue();

			if (value.equals(oldData)) {
				cell.setCellValue(newData);
			}
			FileOutputStream fileOutputStream = new FileOutputStream(file);
			workbook.write(fileOutputStream);
		}
		
		
		public String getCellData(String sheetName, int rownum, int cellnum) throws IOException {
			String res = "";

			File file = new File("C:\\Users\\LENOVO\\eclipse-workspace\\TestNGPractice\\Excel\\TestData.xlsx");
			FileInputStream fileInputStream = new FileInputStream(file);
			Workbook workbook = new XSSFWorkbook(fileInputStream);
			Sheet sheet = workbook.getSheet(sheetName);
			Row row = sheet.getRow(rownum);
			Cell cell = row.getCell(cellnum);

			CellType type = cell.getCellType();

			switch (type) {
			case STRING:
				res = cell.getStringCellValue();

				break;

			case NUMERIC:

				if (DateUtil.isCellDateFormatted(cell)) {
					Date dateCellValue = cell.getDateCellValue();

					SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yy");
					res = dateFormat.format(dateCellValue);

				} else {

					double numericCellValue = cell.getNumericCellValue();

					long round = Math.round(numericCellValue);
					if (numericCellValue == round) {
						res = String.valueOf(round);

					} else {
						res = String.valueOf(numericCellValue);
					}

				}

				break;

			default:
				break;
			}
			return res;

		}

		public void textBoxClear(WebElement element) {
			visbilityOfElement(element);
			if (elementIsDisplayed(element) && elementIsEnabled(element)) {
				element.clear();
			}
		}

		public void switchToChildWindow() {
			String pWindow = driver.getWindowHandle();

			Set<String> windowHandles = driver.getWindowHandles();

			for (String eachWindow : windowHandles) {
				if (!pWindow.equals(eachWindow)) {
					driver.switchTo().window(eachWindow);
				}
			}

		}

		public void mouseOverAction(WebElement element) {
			actions = new Actions(driver);
			actions.moveToElement(element).perform();
		}
		
		public void rightClick(WebElement element) {
			actions = new Actions(driver);
			actions.contextClick(element).perform();
		}
		
		public void doubleClick(WebElement element) {
			actions = new Actions(driver);
			actions.doubleClick(element).perform();
		}

		public void scroll(WebElement element) {
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].scrollIntoView()", element);
		}

		public void navigateTo(String url) {
			driver.navigate().to(url);
		}

		public void navigateBack() {
			driver.navigate().back();
		}

		public void switchToFrameByIdOrName(String id) {
			driver.switchTo().frame(id);
		}

		public void switchToFrameByIndex(int index) {
			driver.switchTo().frame(index);
		}

		public void screenshot(String sName, WebElement element) throws IOException {
			File screenshotAs = element.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshotAs, new File(
					"C:\\Users\\LENOVO\\eclipse-workspace\\FrameworkClass930AMNewBatch\\Output\\" + sName + ".png"));
		}

		public void screenshot(String sName) throws IOException {
			TakesScreenshot screenshot = (TakesScreenshot) driver;
			File screenshotAs = screenshot.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshotAs, new File(
					"C:\\Users\\LENOVO\\eclipse-workspace\\FrameworkClass930AMNewBatch\\Output\\" + sName + ".png"));
		}

		public void visbilityOfElement(WebElement element) {
			WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(60));
			driverWait.until(ExpectedConditions.visibilityOf(element));

		}

		public void implicitWait() {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));

		}

		public void implicitWait(int secs) {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(secs));

		}

		public void browserLaunch() {
			driver = new ChromeDriver();
		}

		public void enterApplnUrl(String url) {
			driver.get(url);
		}

		public void maximizeWindow() {
			driver.manage().window().maximize();
		}

		public void elementSendKeys(WebElement element, String data) {
			visbilityOfElement(element);

			if (elementIsDisplayed(element) && elementIsEnabled(element)) {
				element.sendKeys(data);
			}
		}

		public void elementSendKeysJs(WebElement element, String data) {
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].setAttribute('value','" + data + "')", element);
		}

		public void elementClick(WebElement element) {
			visbilityOfElement(element);
			if (elementIsDisplayed(element) && elementIsEnabled(element)) {
				element.click();
			}
		}

		public String getApplnTitle() {
			String title = driver.getTitle();
			return title;
		}

		public WebElement findLocatorById(String attributeValue) {
			WebElement element = driver.findElement(By.id(attributeValue));
			return element;
		}

		public WebElement findLocatorByName(String attributeValue) {
			WebElement element = driver.findElement(By.name(attributeValue));
			return element;
		}

		public WebElement findLocatorByClassName(String attributeValue) {
			WebElement element = driver.findElement(By.className(attributeValue));
			return element;
		}

		public WebElement findLocatorByXpath(String exp) {
			WebElement element = driver.findElement(By.xpath(exp));
			return element;
		}

		public String getApplnUrl() {
			String currentUrl = driver.getCurrentUrl();
			return currentUrl;
		}

		public void closeApplnWindow() {
			driver.close();
		}

		public String elementGetText(WebElement element) {
			String text = null;
			visbilityOfElement(element);
			if (elementIsDisplayed(element)) {
				text = element.getText();
			}
			return text;
		}

		// value fixed
		public String elementGetAttributeValue(WebElement element) {
			String attribute = null;
			visbilityOfElement(element);
			if (elementIsDisplayed(element)) {
				attribute = element.getAttribute("value");
			}
			return attribute;
		}

		// value is NOT fixed
		public String elementGetAttributeValue(WebElement element, String attributeName) {
			String attribute = null;
			visbilityOfElement(element);
			if (elementIsDisplayed(element)) {

				attribute = element.getAttribute(attributeName);
			}
			return attribute;
		}

		public boolean elementIsDisplayed(WebElement element) {
			boolean displayed = element.isDisplayed();
			return displayed;
		}

		public boolean elementIsEnabled(WebElement element) {
			boolean enabled = element.isEnabled();
			return enabled;
		}

		public boolean elementIsSelected(WebElement element) {
			boolean selected = element.isSelected();
			return selected;
		}

		public void selectOptionByIndex(WebElement element, int index) {
			select = new Select(element);
			select.selectByIndex(index);
		}

		public void selectOptionByText(WebElement element, String text) {
			select = new Select(element);
			select.selectByVisibleText(text);
		}

		public void selectOptionByValue(WebElement element, String attributeValue) {
			select = new Select(element);
			select.selectByValue(attributeValue);
		}

		public List<String> getAllOptionsText(WebElement element) {
			select = new Select(element);
			List<WebElement> options = select.getOptions();

			List<String> allOptions = new ArrayList<>();

			for (WebElement webElement : options) {
				String text = webElement.getText();
				allOptions.add(text);

			}
			return allOptions;
		}
		
		public void clickOkAlert() {
			driver.switchTo().alert().accept();
		}
		
		public void clickCancleAlert() {
			driver.switchTo().alert().dismiss();
		}

}


