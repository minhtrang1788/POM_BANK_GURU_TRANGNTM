package pageObjects;

import org.openqa.selenium.WebDriver;

import common.AbstractPage;
import pageUI.NewAccountPageUI;
import pageUI.NewCustomerPageUI;
import pageObjects.NewAccountPageObject;

public class NewAccountPageObject extends AbstractPage {
	WebDriver driver;

	public NewAccountPageObject(WebDriver driverUse) {
		driver = driverUse;
		setDriver(driverUse);
	}

	public boolean isDispledAccountPage() throws InterruptedException {
		return isControlDisplayed(NewAccountPageUI.ACCOUNT_TITLE);
	}

	
	public void selectAccountType() {
		waitForControlVisible(NewAccountPageUI.ACCOUNT_SELECT_TYPE);
		selectItemInHtmlDropdown(NewAccountPageUI.ACCOUNT_SELECT_TYPE, "Current");
	}
	
}
