package pageObjects;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import common.AbstractPage;
import pageUI.EditCustomerFormPageUI;
import pageUI.HomePageUI;
import pageUI.LoginPageUI;
import pageUI.NewCustomerPageUI;

public class EditCustomerFormPageObject extends AbstractPage {
	WebDriver driver;

	public EditCustomerFormPageObject(WebDriver driverUse) {
		driver = driverUse;
		setDriver(driverUse);
	}

	
	public boolean isNotDispledHomePage() throws InterruptedException {

		return isControlNotDisplayed(EditCustomerFormPageUI.WELCOME_LINK);
	}

	public boolean isNotDispledCustomerForm()  {

		return isControlNotDisplayed(EditCustomerFormPageUI.CUSTOMER_FORM);
	}
	
	
	public void inputAdress(String value) {
		waitForControlVisible(EditCustomerFormPageUI.CUSTOMER_ADDRESS);
		sendkeyToElement(EditCustomerFormPageUI.CUSTOMER_ADDRESS, value);
	}

	
}
