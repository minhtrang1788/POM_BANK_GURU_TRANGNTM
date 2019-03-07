package pageObjects;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import common.AbstractPage;
import pageUI.BalanceEnquiryPageUI;
import pageUI.DepositPageUI;
import pageUI.HomePageUI;
import pageUI.LoginPageUI;
import pageUI.NewAccountPageUI;

public class BalanceEnquiryPageObject extends AbstractPage {
	WebDriver driver;

	public BalanceEnquiryPageObject(WebDriver driverUse) {
		driver = driverUse;
		setDriver(driverUse);
	}

	
}
