package common;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import pageObjects.DepositPageObject;
import pageObjects.FundTransferPageObject;
import pageObjects.NewAccountPageObject;
import pageObjects.NewCustomerPageObject;
import pageUI.AbstractPageUI;
import pageUI.EditCustomerPageUI;
import pageUI.FundTransferPageUI;
import pageUI.LoginPageUI;

public class AbstractPage {
	WebDriver driver;
	int shortTime = 5;
	int LongTime = 30;
	protected final Log log;

	protected AbstractPage() {
		log = LogFactory.getLog(getClass());
	}

	public void setDriver(WebDriver driverUse) {
		driver = driverUse;
	}

	public WebDriver getDriver() {
		return driver;
	}

	public void goURLLink(String url) {
		driver.get(url);

	}

	public String getCurrentURL() {
		return driver.getCurrentUrl();
	}

	public String getPageSource() {
		return driver.getPageSource();
	}

	public void back() {
		driver.navigate().back();
	}

	public void forward() {
		driver.navigate().forward();
	}

	public void refresh() {
		driver.navigate().refresh();
	}

	public void acceptAlert() {
		driver.switchTo().alert().accept();
	}

	public void cancelAlert() {
		driver.switchTo().alert().dismiss();
	}

	public String getTextAlert() {
		return driver.switchTo().alert().getText();
	}

	public void sendkeyToAlert(String text) {
		driver.switchTo().alert().sendKeys(text);
	}

	public void clickToElement(String locator) {
		WebElement object = driver.findElement(By.xpath(locator));
		object.click();
	}

	public void sendkeyToElement(String locator, String content) {
		WebElement object = driver.findElement(By.xpath(locator));
		object.clear();
		object.sendKeys(content);
	}

	public void selectItemInHtmlDropdown(String locator, String value) {
		WebElement object = driver.findElement(By.xpath(locator));
		Select select = new Select(object);
		select.selectByValue(value);
	}

	public String getSelectedItemInHtmlDropdown(String locator) {
		WebElement object = driver.findElement(By.xpath(locator));
		Select select = new Select(object);
		return select.getFirstSelectedOption().getText();
	}

	public void selectItemInCustomDropdown(String scrolltoXpath, String parent, String children, String checkValue) {
		JavascriptExecutor js;
		js = (JavascriptExecutor) driver;
		WebElement scroll = driver.findElement(By.xpath(scrolltoXpath));
		js.executeScript("arguments[0].scrollIntoView(true);", scroll);
		WebElement dropdown = driver.findElement(By.xpath(parent));
		dropdown.click();
		List<WebElement> listChild = driver.findElements(By.xpath(children));
		for (WebElement child : listChild) {
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			if (child.getText().equals(checkValue)) {
				child.click();
				break;
			}
		}

	}

	public String getAttributeValue(String locator, String attribute) {
		WebElement object = driver.findElement(By.xpath(locator));
		return object.getAttribute(attribute);
	}

	public String getTextElement(String locator) {
		WebElement object = driver.findElement(By.xpath(locator));
		return object.getText();
	}

	public int countElementNumber(String locator) {
		List<WebElement> objects = driver.findElements(By.xpath(locator));
		return objects.size();
	}

	public void checkTheCheckbox(String locator) {
		WebElement object = driver.findElement(By.xpath(locator));
		if (!object.isSelected())
			object.click();
	}

	public void uncheckTheCheckbox(String locator) {
		WebElement object = driver.findElement(By.xpath(locator));
		if (object.isSelected())
			object.click();
	}

	public boolean isControlDisplayed(String locator) {
		overwriteTimeOutWait(driver, 30);
		try {
			WebElement object = driver.findElement(By.xpath(locator));
			return object.isDisplayed();
		} catch (Exception ex) {
			System.out.println("error:" + ex);
			return false;
		}
	}

	public boolean isControlNotDisplayed(String locator) {
		WebElement object;
		overwriteTimeOutWait(driver, shortTime);
		try {
			object = driver.findElement(By.xpath(locator));

		} catch (Exception ex) {
			overwriteTimeOutWait(driver, LongTime);
			return true;

		}
		overwriteTimeOutWait(driver, LongTime);
		if (object.isDisplayed())
			return false;
		return true;
	}

	public void overwriteTimeOutWait(WebDriver driver, int time) {
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
	}

	public boolean isControlselected(String locator) {
		WebElement object = driver.findElement(By.xpath(locator));
		return object.isSelected();
	}

	public boolean isControlEnabled(String locator) {
		WebElement object = driver.findElement(By.xpath(locator));
		return object.isEnabled();
	}

	public void switchWindowByID(int id) {
		Set<String> windows = driver.getWindowHandles();
		int i = 0;
		String selectedWindow = "";
		for (String window : windows) {
			i++;
			if (id == i) {
				selectedWindow = window;
				break;
			}

		}
		driver.switchTo().window(selectedWindow);
	}

	public void switchWindowByTitle(String title) {
		Set<String> windows = driver.getWindowHandles();
		int i = 0;
		String selectedWindow = "";
		for (String window : windows) {
			driver.switchTo().window(window);
			if (title == driver.getTitle()) {
				selectedWindow = window;
				break;
			}

		}
		driver.switchTo().window(selectedWindow);
	}

	public boolean closeAllWithoutParentWindows(String parentWindow) {
		Set<String> allWindows = driver.getWindowHandles();
		for (String runWindows : allWindows) {
			if (!runWindows.equals(parentWindow)) {
				driver.switchTo().window(runWindows);
				driver.close();
			}
		}
		driver.switchTo().window(parentWindow);
		if (driver.getWindowHandles().size() == 1)
			return true;
		else
			return false;
	}

	public void switchToIframe(int id) {
		driver.switchTo().frame(id);
	}

	public void doubleClickToElement(String locator) {
		WebElement object = driver.findElement(By.xpath(locator));
		Actions action = new Actions(driver);
		action.doubleClick(object).perform();
	}

	public void hoverMouseToElement(String locator1, String locator2) {
		WebElement object = driver.findElement(By.xpath(locator1));
		WebElement object2 = driver.findElement(By.xpath(locator2));
		Actions action = new Actions(driver);
		action.clickAndHold(object).moveToElement(object2).release().perform();
	}

	public void rightClick(String locator) {
		WebElement object = driver.findElement(By.xpath(locator));
		Actions action = new Actions(driver);
		action.contextClick(object).perform();
	}

	public void dragAndDrop(String locator1, String locator2) {
		WebElement object1 = driver.findElement(By.xpath(locator1));
		WebElement object2 = driver.findElement(By.xpath(locator2));
		Actions action = new Actions(driver);
		action.dragAndDrop(object1, object2).perform();
	}

	public void keyPress(Keys theKey) {
		Actions action = new Actions(driver);
		action.keyDown(theKey);
	}

	public void uploadSendKey(String locator, String filename) {
		WebElement object = driver.findElement(By.xpath(locator));
		object.sendKeys(filename);
	}

	public void uploadSendKeyMultifiles(String locator, String[] filename) {
		WebElement object = driver.findElement(By.xpath(locator));
		String nameUpload = "";
		for (int i = 0; i <= filename.length - 1; i++) {
			nameUpload = nameUpload + filename[i];
		}
		object.sendKeys(nameUpload);
	}

	public void uploadSendKeyRobot(String locator, String filename) throws InterruptedException, AWTException {
		StringSelection selected = new StringSelection(filename);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selected, null);
		Thread.sleep(1000);
		driver.findElement(By.xpath(locator)).click();
		Robot robot = new Robot();
		Thread.sleep(1000);

		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);

		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		Thread.sleep(1000);

		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}

	public void uploadSendKeyAutoIT(String locator, String filename) throws IOException {
		String browserName = driver.toString().toLowerCase();

		if (browserName.contains("chrome")) {
			Runtime.getRuntime().exec(new String[] { ".\\upload\\chrome.exe", filename });
			// driver.findElement(By.cssSelector(".fileinput-button")).click();
		} else if (browserName.contains("firefox")) {
			Runtime.getRuntime().exec(new String[] { ".\\upload\\firefox.exe", filename });
		} else {
			Runtime.getRuntime().exec(new String[] { ".\\upload\\ie.exe", filename });

		}
	}

	public Object executeForBrowser(String javaSript) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			return js.executeScript(javaSript);
		} catch (Exception e) {
			e.getMessage();
			return null;
		}
	}

	public Object clickToElementByJS(String locator) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			WebElement element = driver.findElement(By.xpath(locator));
			return js.executeScript("arguments[0].click();", element);
		} catch (Exception e) {
			e.getMessage();
			return null;
		}
	}

	public Object scrollToBottomPage() {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			return js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		} catch (Exception e) {
			e.getMessage();
			return null;
		}
	}

	public void scrollToElement(String locator) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			WebElement element = driver.findElement(By.xpath(locator));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		} catch (Exception e) {
			e.getMessage();
		}
	}

	public void highLightElement(String locator) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			WebElement element = driver.findElement(By.xpath(locator));
			js.executeScript("arguments[0].style.border='2px groove green'", element);
		} catch (Exception e) {
			e.getMessage();
		}
	}

	public void removeAtributteOfElement(String locator, String att) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			WebElement element = driver.findElement(By.xpath(locator));
			((JavascriptExecutor) driver).executeScript("arguments[0].removeAttribute('" + att + "');", element);
		} catch (Exception e) {
			e.getMessage();
		}
	}

	public void waitForControlPresence(String locator) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
	}

	public void waitForControlVisible(String locator) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
	}

	public void waitForControlClickable(String locator) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));
	}

	public void waitForControlNotVisible(String locator) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(locator)));
	}

	public void waitForAlertPresence() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.alertIsPresent());
	}

	public static String getEmailString() {
		String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
		StringBuilder salt = new StringBuilder();
		Random rnd = new Random();
		while (salt.length() < 10) { // length of the random string.
			int index = (int) (rnd.nextFloat() * SALTCHARS.length());
			salt.append(SALTCHARS.charAt(index));
		}
		String saltStr = salt.toString() + "@example.com";
		return saltStr;

	}

	public AbstractPage openDynamicPage(WebDriver driver, String pageName) {
		System.out.println("pageName::::::" + pageName);
		String linkPage = String.format(AbstractPageUI.DYNAMIC_LINK, pageName);
		System.out.println("linkPage::::::" + linkPage);
		waitForControlVisible(linkPage);
		clickToElement(linkPage);
		switch (pageName) {
		case "New Account":
			return new NewAccountPageObject(driver);
		case "New Customer":
			return new NewCustomerPageObject(driver);
		case "Deposit":
			return new DepositPageObject(driver);
		case "Fund Transfer":
			return new FundTransferPageObject(driver);
		}
		return null;
	}

	public  void openDynamicObjectPage(WebDriver driver, String pageName) {
		String linkPage = String.format(AbstractPageUI.DYNAMIC_LINK, pageName);
		waitForControlVisible(linkPage);
		clickToElement(linkPage);
	}
	

	public boolean isDispledDynamicTitlePage(WebDriver driver, String titlePage) {
		String xpathTitle = String.format(AbstractPageUI.DYNAMIC_TITLE, titlePage);
		return isControlDisplayed(xpathTitle);

	}	
	
	public boolean isDispledDynamicTitleInLivePage(WebDriver driver, String titlePage) {
		String xpathTitle = String.format(AbstractPageUI.DYNAMIC_TITLE_LIVE, titlePage);
		return isControlDisplayed(xpathTitle);

	}	
	public DepositPageObject openDepositPage(WebDriver driver) {
		// TODO Auto-generated method stub
		waitForControlVisible(AbstractPageUI.DEPOSIT_LINK);
		clickToElement(AbstractPageUI.DEPOSIT_LINK);
		return new DepositPageObject(driver);
	}

	public NewAccountPageObject openNewAccountPage(WebDriver driver) {
		// TODO Auto-generated method stub
		waitForControlVisible(AbstractPageUI.NEW_ACCOUNT_LINK);
		clickToElement(AbstractPageUI.NEW_ACCOUNT_LINK);
		return new NewAccountPageObject(driver);
	}

	public NewCustomerPageObject openNewCustomerPage(WebDriver driver) {
		// TODO Auto-generated method stub
		waitForControlVisible(AbstractPageUI.NEW_CUSTOMER_LINK);
		clickToElement(AbstractPageUI.NEW_CUSTOMER_LINK);
		return new NewCustomerPageObject(driver);
	}

	public FundTransferPageObject openFundTransferPage(WebDriver driver) {
		// TODO Auto-generated method stub
		waitForControlVisible(AbstractPageUI.FUND_TRANSFER_LINK);
		clickToElement(AbstractPageUI.FUND_TRANSFER_LINK);
		return new FundTransferPageObject(driver);
	}

	private boolean checkPassed(boolean condition) {
		boolean pass = true;
		try {
			if (condition == true)
				log.info("===PASSED===");
			else
				log.info("===FAILED===");
			Assert.assertTrue(condition);
		} catch (Throwable e) {
			pass = false;

			// Add error vào ReportNG
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	protected boolean verifyTrue(boolean condition) {
		return checkPassed(condition);
	}

	private boolean checkFailed(boolean condition) {
		boolean pass = true;
		try {
			if (condition == true)
				log.info("===PASSED===");
			else
				log.info("===FAILED===");
			Assert.assertFalse(condition);
		} catch (Throwable e) {
			pass = false;
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	protected boolean verifyFalse(boolean condition) {
		return checkFailed(condition);
	}

	private boolean checkEquals(Object actual, Object expected) {
		boolean pass = true;
		try {
			if (actual == expected)
				log.info("===PASSED===");
			else
				log.info("===FAILED===");
			Assert.assertEquals(actual, expected);
		} catch (Throwable e) {
			pass = false;
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	protected boolean verifyEquals(Object actual, Object expected) {
		return checkEquals(actual, expected);
	}

	protected void closeBrowserAndDriver(WebDriver driver) {
		try {
			String osName = System.getProperty("os.name").toLowerCase();
			System.out.println("OS name = " + osName);

			String cmd = "";
			if (driver != null) {
				driver.quit();
			}

			if (driver.toString().toLowerCase().contains("chrome")) {
				if (osName.toLowerCase().contains("mac")) {
					cmd = "pkill chromedriver";
				} else if (osName.toLowerCase().contains("windows")) {
					cmd = "taskkill /F /FI \"IMAGENAME eq chromedriver*\"";
				}
				Process process = Runtime.getRuntime().exec(cmd);
				process.waitFor();
			}
			if (driver.toString().toLowerCase().contains("internetexplorer")) {
				if (osName.toLowerCase().contains("window")) {
					cmd = "taskkill /F /FI \"IMAGENAME eq IEDriverServer*\"";
					Process process = Runtime.getRuntime().exec(cmd);
					process.waitFor();
				}
			}
			log.info("---------- QUIT BROWSER SUCCESS ----------");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void sendDynamicInputText(String name, String value) {
		String inputTextXpath = String.format(AbstractPageUI.DYNAMIC_INPUT_TEXT, name);
		sendkeyToElement(inputTextXpath, value);
	}
	
	public String getDynamicInputText(String name) {
		String xpathText = String.format(AbstractPageUI.DYNAMIC_TEXT_SUCCESS_CUSTOMER_REGISTER, name);
		waitForControlVisible(xpathText);
		System.out.println("xpathText-------getText----"+getTextElement(xpathText));
		return getTextElement(xpathText);
	}
	
	public void clickDynamicSubmit(String name) {
		String xpathText = String.format(AbstractPageUI.DYNAMIC_BTN_SUBMIT, name);
		System.out.println("xpathText-----------"+xpathText);
		waitForControlVisible(xpathText);
		clickToElement(xpathText);
	}
	
	public void clickDynamicLink(String name) {
		String xpathText = String.format(AbstractPageUI.DYNAMIC_LINK, name);
		waitForControlVisible(xpathText);
		clickToElement(xpathText);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
