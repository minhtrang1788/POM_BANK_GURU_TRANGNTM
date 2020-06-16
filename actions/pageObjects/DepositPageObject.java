package pageObjects;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import common.AbstractPage;
import pageUI.DepositPageUI;
import pageUI.HomePageUI;
import pageUI.LoginPageUI;
import pageUI.NewAccountPageUI;

public class DepositPageObject extends AbstractPage {
	WebDriver driver;

	public DepositPageObject(WebDriver driverUse) {
		driver = driverUse;
		setDriver(driverUse);
	}
	
	public boolean isDispledDepositPage() throws InterruptedException{
		return isControlDisplayed(DepositPageUI.DEPOSIT_TITLE);
	}

	
}
