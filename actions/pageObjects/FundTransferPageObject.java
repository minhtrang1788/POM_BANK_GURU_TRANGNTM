package pageObjects;

import org.openqa.selenium.WebDriver;

import common.AbstractPage;
import pageUI.FundTransferPageUI;

public class FundTransferPageObject extends AbstractPage {
	WebDriver driver;

	public boolean isDispledFundTransferPage() {
		return isControlDisplayed(FundTransferPageUI.FUND_TRANSFER_TITLE);
	}

	public FundTransferPageObject(WebDriver driverUse) {
		driver = driverUse;
		setDriver(driverUse);
	}

}
