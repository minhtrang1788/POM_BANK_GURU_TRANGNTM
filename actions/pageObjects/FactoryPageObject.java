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
	
	public static EditCustomerPageObject editCustomerPageObject(WebDriver driver) {
		return new EditCustomerPageObject(driver);
	}
	
	public static EditCustomerFormPageObject editCustomerFormPageObject(WebDriver driver) {
		return new EditCustomerFormPageObject(driver);
	}
	
	public static SuccessRegisterNewCustomerPageObject newSuccessRegisterNewCustomerPageObject(WebDriver driver) {
		return new SuccessRegisterNewCustomerPageObject(driver);
	}
	
	public static WithdrawPageObject newWithdrawPageObject(WebDriver driver) {
		return new WithdrawPageObject(driver);
	}
	
	public static BalanceEnquiryPageObject newBalanceEnquiryPageObject(WebDriver driver) {
		return new BalanceEnquiryPageObject(driver);
	}
	
	public static DeleteAccPageObject newDeleteAccPageObject(WebDriver driver) {
		return new DeleteAccPageObject(driver);
	}
	
	public static DeleteCustomerPageObject newDeleteCustomerPageObject(WebDriver driver) {
		return new DeleteCustomerPageObject(driver);
	}
	
	public static LivePageObject newLivePageObject(WebDriver driver) {
		return new LivePageObject(driver);
	}
	
	public static MobilePageObject newMobilePageObject(WebDriver driver) {
		return new MobilePageObject(driver);
	}
	
	public static SingleMobilePageObject newSingleMobilePageObject(WebDriver driver) {
		return new SingleMobilePageObject(driver);
	}
	
	public static ShoppingCartPageObject newShoppingCartPageObject(WebDriver driver) {
		return new ShoppingCartPageObject(driver);
	}
	
	public static TVPageObject newTVPageObject(WebDriver driver) {
		return new TVPageObject(driver);
	}
}
