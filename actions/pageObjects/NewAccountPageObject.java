package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import common.AbstractPage;
import pageUI.HomePageUI;
import pageUI.LoginPageUI;
import pageUI.NewAccountPageUI;
import pageObjects.NewAccountPageObject;

public class NewAccountPageObject extends AbstractPage {
	WebDriver driver;

	public NewAccountPageObject(WebDriver driverUse) {
		driver = driverUse;
		setDriver(driverUse);
	}

	public void isDispledAccountPage() throws InterruptedException {
		Thread.sleep(1000);
		Assert.assertTrue(isControlDisplayed(NewAccountPageUI.ACCOUNT_TITLE));
	}

}
