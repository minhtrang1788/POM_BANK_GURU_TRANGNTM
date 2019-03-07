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


}
