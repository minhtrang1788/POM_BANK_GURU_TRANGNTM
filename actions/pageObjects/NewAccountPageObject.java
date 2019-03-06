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

	public boolean isDispledAccountPage(){
		return isControlDisplayed(NewAccountPageUI.ACCOUNT_TITLE);
	}

	public void selectAccountType() {
		waitForControlVisible(NewAccountPageUI.ACCOUNT_SELECT_TYPE);
		selectItemInHtmlDropdown(NewAccountPageUI.ACCOUNT_SELECT_TYPE, "Current");
	}
	
	public void clickSubmit() {
		waitForControlVisible(NewAccountPageUI.ACCOUNT_BTN_SUBMIT);
		clickToElement(NewAccountPageUI.ACCOUNT_BTN_SUBMIT);
	}
	
	public boolean isDispledAccountSuccessPage(){
		return isControlDisplayed(NewAccountPageUI.ACCOUNT_CREATED_SUCCESS_TITLE);
	}
}
