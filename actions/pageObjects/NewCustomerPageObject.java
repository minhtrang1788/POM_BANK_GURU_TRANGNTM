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

	public void tests(String value) {
		
		System.out.println("value:::"+value);
	}
	public void isDispledCustomerPage() throws InterruptedException {
		Thread.sleep(1000);
		Assert.assertTrue(isControlDisplayed(NewCustomerPageUI.CUSTOMER_TITLE));
	}

}
