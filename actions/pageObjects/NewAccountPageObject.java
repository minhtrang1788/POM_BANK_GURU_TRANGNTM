package pageObjects;

import org.openqa.selenium.WebDriver;

import common.AbstractPage;
import pageUI.NewAccountPageUI;
import pageObjects.NewAccountPageObject;

public class NewAccountPageObject extends AbstractPage {
	WebDriver driver;

	public NewAccountPageObject(WebDriver driverUse) {
		driver = driverUse;
		setDriver(driverUse);
	}

	public boolean isDispledAccountPage(){
		return isControlDisplayed(NewAccountPageUI.ACCOUNT_TITLE);
	}

}
