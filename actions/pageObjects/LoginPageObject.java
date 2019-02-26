package pageObjects;

import org.openqa.selenium.WebDriver;

import common.AbstractPage;
import pageUI.LoginPageUI;

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
		waitForControlVisible(LoginPageUI.NAME_TEXTBOX);
		inputTextboxLogin(LoginPageUI.NAME_TEXTBOX,name);
	}
	
	public void InputPassword(String password) {
		waitForControlVisible(LoginPageUI.PASSWORD_TEXTBOX);
		inputTextboxLogin(LoginPageUI.PASSWORD_TEXTBOX,password);
	}
	
	public HomePageObject clickButtonLogin() {
		waitForControlVisible(LoginPageUI.LOGIN_BUTTON);
		clickToElement(LoginPageUI.LOGIN_BUTTON);
		return new HomePageObject(driver);
	}
	
	
	
}
