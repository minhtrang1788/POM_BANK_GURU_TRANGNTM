package pageObjects;

import org.openqa.selenium.WebDriver;

import common.AbstractPage;
import pageUI.DepositPageUI;
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

	public void clickSubmit() {
		waitForControlVisible(FundTransferPageUI.FUND_TRANSFER_BTN_SUBMIT);
		clickToElement(FundTransferPageUI.FUND_TRANSFER_BTN_SUBMIT);
	}
}
