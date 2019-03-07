package pageObjects;
import common.AbstractPage;

import org.openqa.selenium.WebDriver;
import pageUI.HomePageUI;
import pageUI.NewCustomerPageUI;

public class HomePageObject extends AbstractPage{
	
	WebDriver driver;
	
	public  HomePageObject(WebDriver driverUse) {
		driver = driverUse;
		setDriver(driverUse);	
	}
	public boolean isDispledHomePage() throws InterruptedException {
		return isControlDisplayed(HomePageUI.WELCOME_LINK);
		
	}
	
	public boolean isNotDispledNewCustomer() throws InterruptedException {

		return isControlNotDisplayed(NewCustomerPageUI.CUSTOMER_TITLE);
	}

	public boolean isNotDispledCustomerForm() throws InterruptedException {

		return isControlNotDisplayed(NewCustomerPageUI.CUSTOMER_FORM);
	}

	
}
