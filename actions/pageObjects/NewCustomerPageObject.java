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

	public void isDispledCustomerPage() throws InterruptedException {

		Assert.assertTrue(isControlDisplayed(NewCustomerPageUI.CUSTOMER_TITLE));
	}

	public void isNotDispledHomePage() throws InterruptedException {

		Assert.assertTrue(isControlNotDisplayed(NewCustomerPageUI.WELCOME_LINK));
	}

	public void isNotDispledCustomerForm() throws InterruptedException {

		Assert.assertTrue(isControlNotDisplayed(NewCustomerPageUI.CUSTOMER_FORM));
	}
	
	public void isDispledCustomerSucessPage() throws InterruptedException {
		waitForControlVisible(NewCustomerPageUI.CUSTOMER_SUCCESS_TITLE);
		Assert.assertTrue(isControlDisplayed(NewCustomerPageUI.CUSTOMER_SUCCESS_TITLE));
	}

	public void inputCustomerName(String value) {
		waitForControlVisible(NewCustomerPageUI.CUSTOMER_NAME);
		sendkeyToElement(NewCustomerPageUI.CUSTOMER_NAME, value);
	}

	public void inputDateOfBirth(String value) {
		waitForControlVisible(NewCustomerPageUI.CUSTOMER_DOB);
		sendkeyToElement(NewCustomerPageUI.CUSTOMER_DOB, value);
	}

	public void inputAdress(String value) {
		waitForControlVisible(NewCustomerPageUI.CUSTOMER_ADDRESS);
		sendkeyToElement(NewCustomerPageUI.CUSTOMER_ADDRESS, value);
	}

	public void inputCity(String value) {
		waitForControlVisible(NewCustomerPageUI.CUSTOMER_CITY);
		sendkeyToElement(NewCustomerPageUI.CUSTOMER_CITY, value);
	}

	public void inputState(String value) {
		waitForControlVisible(NewCustomerPageUI.CUSTOMER_STATE);
		sendkeyToElement(NewCustomerPageUI.CUSTOMER_STATE, value);
	}

	public void inputPin(String value) {
		waitForControlVisible(NewCustomerPageUI.CUSTOMER_PIN);
		sendkeyToElement(NewCustomerPageUI.CUSTOMER_PIN, value);
	}

	public void inputMobile(String value) {
		waitForControlVisible(NewCustomerPageUI.CUSTOMER_MOBILE);
		sendkeyToElement(NewCustomerPageUI.CUSTOMER_MOBILE, value);
	}

	public void inputEmail() {
		waitForControlVisible(NewCustomerPageUI.CUSTOMER_EMAIL);
		sendkeyToElement(NewCustomerPageUI.CUSTOMER_EMAIL, getEmailString());
	}

	public void inputPassword(String value) {
		waitForControlVisible(NewCustomerPageUI.CUSTOMER_PASSWORD);
		sendkeyToElement(NewCustomerPageUI.CUSTOMER_PASSWORD, value);
	}

	public void clickSubmit() {
		waitForControlVisible(NewCustomerPageUI.CUSTOMER_BTN_SUBMIT);
		clickToElement(NewCustomerPageUI.CUSTOMER_BTN_SUBMIT);
	}

	public String getCustomerId() {
		waitForControlVisible(NewCustomerPageUI.CUSTOMER_ID);
		return getTextElement(NewCustomerPageUI.CUSTOMER_ID);
	}

}
