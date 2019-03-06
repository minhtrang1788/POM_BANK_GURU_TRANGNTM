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

	public boolean isDispledBalanceEnquiryPage()   {
		return isControlDisplayed(BalanceEnquiryPageUI.BALANCE_ENQUIRY_TITLE);
	}
	
	public void clickSubmit() {
		waitForControlVisible(BalanceEnquiryPageUI.BALANCE_ENQUIRY_BTN_SUBMIT);
		clickToElement(BalanceEnquiryPageUI.BALANCE_ENQUIRY_BTN_SUBMIT);
	}
	
	public boolean isDispledBalanceEnquirySuccessPage(String accNo)   {
		return isControlDisplayed(String.format(BalanceEnquiryPageUI.BALANCE_ENQUIRY_TITLE_SUCCESS,accNo) );
	}
}
