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
	public static NewCustomerPageObject newCustomerPageObject(WebDriver driver) {
		return new NewCustomerPageObject(driver);
	}
	
	public static NewAccountPageObject newAccountPageObject(WebDriver driver) {
		return new NewAccountPageObject(driver);
	}
	
	public static DepositPageObject newDepositPageObject(WebDriver driver) {
		return new DepositPageObject(driver);
	}
	
	public static FundTransferPageObject newFundTransferPageObject(WebDriver driver) {
		return new FundTransferPageObject(driver);
	}
	
}
