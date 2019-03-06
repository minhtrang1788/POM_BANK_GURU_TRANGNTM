package pageObjects;

import org.openqa.selenium.WebDriver;

import common.AbstractPage;
import pageUI.CustomerRegisterSuccessPageUI;
import pageUI.FundTransferPageUI;
import pageUI.NewCustomerPageUI;

public class SuccessRegisterNewCustomerPageObject extends AbstractPage {
	WebDriver driver;

	public boolean isDispledSuccessRegisterCustomer() {
		return isControlDisplayed(CustomerRegisterSuccessPageUI.CUSTOMER_REGISTER_SUCCESS_TITLE);
	}

	public SuccessRegisterNewCustomerPageObject(WebDriver driverUse) {
		driver = driverUse;
		setDriver(driverUse);
	}

	public String getCustomerId() {
		waitForControlVisible(CustomerRegisterSuccessPageUI.CUSTOMER_ID);
		return getTextElement(CustomerRegisterSuccessPageUI.CUSTOMER_ID);
	}
}
