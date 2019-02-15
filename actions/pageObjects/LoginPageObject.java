package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import common.AbstractPage;
import pageUI.loginPageUI;

public class LoginPageObject extends AbstractPage{
	WebDriver driver;
	public LoginPageObject( WebDriver driverUse) {
		driver = driverUse;
		setDriver(driverUse);	
	}
	
	public void inputTextboxLogin(String xpath,String value) {
		sendkeyToElement(xpath, value);
	}
	
	public String getLoginURL() {
		return getCurrentURL();
	}
	
	public void goURL(String url) {
		goURLLink(url);
	}
	
	public void InputName(String name) {
		waitForControlVisible(loginPageUI.NAME_TEXTBOX);
		inputTextboxLogin(loginPageUI.NAME_TEXTBOX,name);
	}
	
	public void InputPassword(String password) {
		waitForControlVisible(loginPageUI.PASSWORD_TEXTBOX);
		inputTextboxLogin(loginPageUI.PASSWORD_TEXTBOX,password);
	}
	
	public HomePageObject clickButtonLogin() {
		waitForControlVisible(loginPageUI.LOGIN_BUTTON);
		clickToElement(loginPageUI.LOGIN_BUTTON);
		return new HomePageObject(driver);
	}
	
	
	
}
