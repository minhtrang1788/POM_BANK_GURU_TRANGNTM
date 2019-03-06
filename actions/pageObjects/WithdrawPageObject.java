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

	public boolean isDispledWithdrawPage() throws InterruptedException {
		return isControlDisplayed(WithdrawPageUI.WITHDRAW_TITLE);
	}
	
	public void clickSubmit() {
		waitForControlVisible(WithdrawPageUI.WITHDRAW_BTN_SUBMIT);
		clickToElement(WithdrawPageUI.WITHDRAW_BTN_SUBMIT);
	}
	
	public boolean isDispledWithdrawSuccessPage(String accNo){
		return isControlDisplayed(String.format(WithdrawPageUI.WITHDRAW_TITLE_SUCCESS,accNo));
	}

}
