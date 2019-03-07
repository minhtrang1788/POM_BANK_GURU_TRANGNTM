package pageObjects;

import org.openqa.selenium.WebDriver;

import common.AbstractPage;
import pageUI.CustomerRegisterSuccessPageUI;
import pageUI.FundTransferPageUI;
import pageUI.NewCustomerPageUI;

public class SuccessRegisterNewCustomerPageObject extends AbstractPage {
	WebDriver driver;

	public SuccessRegisterNewCustomerPageObject(WebDriver driverUse) {
		driver = driverUse;
		setDriver(driverUse);
	}

}
