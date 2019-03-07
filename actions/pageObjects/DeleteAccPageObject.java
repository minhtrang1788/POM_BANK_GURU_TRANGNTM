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

public class DeleteAccPageObject extends AbstractPage {
	WebDriver driver;

	public DeleteAccPageObject(WebDriver driverUse) {
		driver = driverUse;
		setDriver(driverUse);
	}
	
	public void clickOkAlert()   {
		acceptAlert();
	}
}
