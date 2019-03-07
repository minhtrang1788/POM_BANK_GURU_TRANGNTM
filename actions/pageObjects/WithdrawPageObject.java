package pageObjects;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import common.AbstractPage;
import pageUI.DepositPageUI;
import pageUI.HomePageUI;
import pageUI.LoginPageUI;
import pageUI.NewAccountPageUI;
import pageUI.WithdrawPageUI;

public class WithdrawPageObject extends AbstractPage {
	WebDriver driver;

	public WithdrawPageObject(WebDriver driverUse) {
		driver = driverUse;
		setDriver(driverUse);
	}

}
