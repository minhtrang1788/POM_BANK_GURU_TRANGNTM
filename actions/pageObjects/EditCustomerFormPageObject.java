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

	public boolean isDispledEditCustomerFormPage() throws InterruptedException {

		return isControlDisplayed(EditCustomerFormPageUI.CUSTOMER_TITLE);
	}

	public boolean isNotDispledHomePage() throws InterruptedException {

		return isControlNotDisplayed(EditCustomerFormPageUI.WELCOME_LINK);
	}

	public boolean isNotDispledCustomerForm()  {

		return isControlNotDisplayed(EditCustomerFormPageUI.CUSTOMER_FORM);
	}
	
	public boolean isDispledCustomerSucessPage() {
		waitForControlVisible(EditCustomerFormPageUI.CUSTOMER_SUCCESS_TITLE);
		return isControlDisplayed(EditCustomerFormPageUI.CUSTOMER_SUCCESS_TITLE);
	}

	public void inputCustomerName(String value) {
		waitForControlVisible(EditCustomerFormPageUI.CUSTOMER_NAME);
		sendkeyToElement(EditCustomerFormPageUI.CUSTOMER_NAME, value);
	}

	public void inputDateOfBirth(String value) {
		waitForControlVisible(EditCustomerFormPageUI.CUSTOMER_DOB);
		sendkeyToElement(EditCustomerFormPageUI.CUSTOMER_DOB, value);
	}

	public void inputAdress(String value) {
		waitForControlVisible(EditCustomerFormPageUI.CUSTOMER_ADDRESS);
		sendkeyToElement(EditCustomerFormPageUI.CUSTOMER_ADDRESS, value);
	}

	public void inputCity(String value) {
		waitForControlVisible(EditCustomerFormPageUI.CUSTOMER_CITY);
		sendkeyToElement(EditCustomerFormPageUI.CUSTOMER_CITY, value);
	}

	public void inputState(String value) {
		waitForControlVisible(EditCustomerFormPageUI.CUSTOMER_STATE);
		sendkeyToElement(EditCustomerFormPageUI.CUSTOMER_STATE, value);
	}

	public void inputPin(String value) {
		waitForControlVisible(EditCustomerFormPageUI.CUSTOMER_PIN);
		sendkeyToElement(EditCustomerFormPageUI.CUSTOMER_PIN, value);
	}

	public void inputMobile(String value) {
		waitForControlVisible(EditCustomerFormPageUI.CUSTOMER_MOBILE);
		sendkeyToElement(EditCustomerFormPageUI.CUSTOMER_MOBILE, value);
	}

	public void inputEmail() {
		waitForControlVisible(EditCustomerFormPageUI.CUSTOMER_EMAIL);
		sendkeyToElement(EditCustomerFormPageUI.CUSTOMER_EMAIL, getEmailString());
	}

	public void inputPassword(String value) {
		waitForControlVisible(EditCustomerFormPageUI.CUSTOMER_PASSWORD);
		sendkeyToElement(EditCustomerFormPageUI.CUSTOMER_PASSWORD, value);
	}

	public void clickSubmit() {
		waitForControlVisible(EditCustomerFormPageUI.CUSTOMER_BTN_SUBMIT);
		clickToElement(EditCustomerFormPageUI.CUSTOMER_BTN_SUBMIT);
	}


}
