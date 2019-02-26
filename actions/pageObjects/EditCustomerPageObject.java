package pageObjects;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import common.AbstractPage;
import pageUI.EditCustomerPageUI;
import pageUI.HomePageUI;
import pageUI.LoginPageUI;
import pageUI.NewCustomerPageUI;

public class EditCustomerPageObject extends AbstractPage {
	WebDriver driver;

	public EditCustomerPageObject(WebDriver driverUse) {
		driver = driverUse;
		setDriver(driverUse);
	}

	public boolean isDispledEditCustomerPage()  {
		return isControlDisplayed(EditCustomerPageUI.CUSTOMER_TITLE);
	}

	public void inputCustomerID(String value) {
		waitForControlVisible(EditCustomerPageUI.CUSTOMER_INPUT_NAME);
		sendkeyToElement(EditCustomerPageUI.CUSTOMER_INPUT_NAME, value);
	}

	public void clickSubmit() {
		waitForControlVisible(EditCustomerPageUI.CUSTOMER_BTN_SUBMIT);
		clickToElement(EditCustomerPageUI.CUSTOMER_BTN_SUBMIT);
	}

}
