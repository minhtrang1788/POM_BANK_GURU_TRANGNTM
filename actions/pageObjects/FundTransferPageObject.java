package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import common.AbstractPage;
import pageUI.FundTransferPageUI;
import pageUI.HomePageUI;
import pageUI.LoginPageUI;

public class FundTransferPageObject extends AbstractPage {
	WebDriver driver;

	public void isDispledFundTransferPage() throws InterruptedException {
		Thread.sleep(1000);
		Assert.assertTrue(isControlDisplayed(FundTransferPageUI.FUND_TRANSFER_TITLE));
	}

	public FundTransferPageObject(WebDriver driverUse) {
		driver = driverUse;
		setDriver(driverUse);
	}

}
