package common;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class AbstractPage {
	WebDriver driver;

	public void getTitle(String url) {
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

	public void getTextAlert() {
		driver.switchTo().alert().getText();
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
		WebElement object = driver.findElement(By.xpath(locator));
		return object.isDisplayed();
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
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
