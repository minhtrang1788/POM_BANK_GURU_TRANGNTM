package pageObjects;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import common.AbstractPage;
import pageUI.HomePageUI;
import pageUI.LoginPageUI;
import pageUI.NewCustomerPageUI;

public class NewCustomerPageObject extends AbstractPage {
	WebDriver driver;

	public NewCustomerPageObject(WebDriver driverUse) {
		driver = driverUse;
		setDriver(driverUse);
	}
	
	public boolean isDispledCustomerPage() throws InterruptedException {

		return isControlDisplayed(NewCustomerPageUI.CUSTOMER_TITLE);
	}
	
	
	public boolean isNotDispledHomePage() throws InterruptedException {

		return isControlNotDisplayed(NewCustomerPageUI.WELCOME_LINK);
	}

	public boolean isNotDispledCustomerForm()  {

		return isControlNotDisplayed(NewCustomerPageUI.CUSTOMER_FORM);
	}
	
	
	public void inputAdress(String value) {
		waitForControlVisible(NewCustomerPageUI.CUSTOMER_ADDRESS);
		sendkeyToElement(NewCustomerPageUI.CUSTOMER_ADDRESS, value);
	}


}
