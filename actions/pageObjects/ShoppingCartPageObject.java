package pageObjects;

import common.AbstractPage;

import org.openqa.selenium.WebDriver;

import pageUI.AbstractPageUI;
import pageUI.HomePageUI;
import pageUI.MobilePageUI;
import pageUI.NewCustomerPageUI;
import pageUI.ShoppingCartPageUI;

public class ShoppingCartPageObject extends AbstractPage {

	WebDriver driver;

	public ShoppingCartPageObject(WebDriver driverUse) {
		driver = driverUse;
		setDriver(driverUse);
	}

	public void clickApplyPromoCode() {
		waitForControlVisible(ShoppingCartPageUI.APPLY_BUTTON);
		clickToElement(ShoppingCartPageUI.APPLY_BUTTON);
	}

}
