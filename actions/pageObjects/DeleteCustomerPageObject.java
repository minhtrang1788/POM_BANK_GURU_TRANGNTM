package pageObjects;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import common.AbstractPage;
import pageUI.BalanceEnquiryPageUI;
import pageUI.DeleteAccPageUI;
import pageUI.DeleteCustomerPageUI;
import pageUI.DepositPageUI;
import pageUI.HomePageUI;
import pageUI.LoginPageUI;
import pageUI.NewAccountPageUI;

public class DeleteCustomerPageObject extends AbstractPage {
	WebDriver driver;

	public DeleteCustomerPageObject(WebDriver driverUse) {
		driver = driverUse;
		setDriver(driverUse);
	}


	public boolean isDispledDeleteCusPage()   {
		return isControlDisplayed(DeleteCustomerPageUI.DELETE_CUSTOMER_TITLE);
	}
	
	public void clickSubmit() {
		waitForControlVisible(DeleteCustomerPageUI.DELETE_CUSTOMER_BTN_SUBMIT);
		clickToElement(DeleteCustomerPageUI.DELETE_CUSTOMER_BTN_SUBMIT);
	}
	
	public void clickOkAlert()   {
		acceptAlert();
	}
}
