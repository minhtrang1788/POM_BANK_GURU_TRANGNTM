package pageObjects;

import org.openqa.selenium.WebDriver;

public class FactoryPageObject {
	

	public static RegisterPageObject newRegisterPageObject(WebDriver driver) {
		return new RegisterPageObject(driver);
	}
	
	public static HomePageObject newHomePageObject(WebDriver driver) {
		return new HomePageObject(driver);
	}

	public static LoginPageObject newLoginPageObject(WebDriver driver) {
		return new LoginPageObject(driver);
	}
	
}
