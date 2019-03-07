package pageObjects;

import org.openqa.selenium.WebDriver;

import common.AbstractPage;
import pageUI.DepositPageUI;
import pageUI.FundTransferPageUI;

public class FundTransferPageObject extends AbstractPage {
	WebDriver driver;

	public FundTransferPageObject(WebDriver driverUse) {
		driver = driverUse;
		setDriver(driverUse);
	}

}
