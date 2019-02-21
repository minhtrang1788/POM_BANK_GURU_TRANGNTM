package pageObjects;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import common.AbstractPage;
import pageUI.DepositPageUI;
import pageUI.HomePageUI;
import pageUI.LoginPageUI;

public class DepositPageObject extends AbstractPage {
	WebDriver driver;

	public DepositPageObject(WebDriver driverUse) {
		driver = driverUse;
		setDriver(driverUse);
	}

	public void isDispledDepositPage() throws InterruptedException {
		Thread.sleep(1000);
		Assert.assertTrue(isControlDisplayed(DepositPageUI.DEPOSIT_TITLE));
	}

}
