package pageObjects;
import common.AbstractPage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageUI.Constants;
import pageUI.RegisterPageUI;

public class RegisterPageObject extends AbstractPage{
	
	
	WebDriver driver;
	
	public  RegisterPageObject(WebDriver driverUse) {
		setDriver(driverUse);
		driver = driverUse;
		goURLLink(Constants.LOGIN_LINK);
		
	}
	public LoginPageObject goLoginLink(String url) {
		goURLLink(url);
		return new LoginPageObject(driver);
	}
	public void inputTextbox(String xpath,String value) {
		waitForControlVisible(xpath);
		sendkeyToElement(xpath, value);
	}
	
	public String getURL() {
		return driver.getCurrentUrl();
	}
	
	
	
	public void InputEmail( ) {
		waitForControlVisible(RegisterPageUI.EMAIL_INPUT);
		inputTextbox(RegisterPageUI.EMAIL_INPUT,getEmailString());
	}
	
	
	public void clickButtonRegister() {
		waitForControlVisible(RegisterPageUI.REGISTER_BUTTON);
		clickToElement(RegisterPageUI.REGISTER_BUTTON);
	}
	public void clickHere() {
		driver.findElement(By.xpath("//a[text()='here']")).click();
	}
	
	public String getName() {
		waitForControlVisible(RegisterPageUI.NAME_INPUT);
		return getTextElement(RegisterPageUI.NAME_INPUT);
	}
	
	public String getPassword() {
		waitForControlVisible(RegisterPageUI.PASSWORD_INPUT);
		return getTextElement(RegisterPageUI.PASSWORD_INPUT);
	}
	
	
}
