package pageObjects;
import common.AbstractPage;

import org.openqa.selenium.WebDriver;

import pageUI.AbstractPageUI;
import pageUI.HomePageUI;
import pageUI.MobilePageUI;
import pageUI.NewCustomerPageUI;
import pageUI.SingleMobilePageUI;

public class SingleMobilePageObject extends AbstractPage{
	
	WebDriver driver;
	
	public  SingleMobilePageObject(WebDriver driverUse) {
		driver = driverUse;
		setDriver(driverUse);	
	}
	
	public String getPricePhone() {
		waitForControlVisible(SingleMobilePageUI.PRICE_SINGLE_PRODUCT);
		return getTextElement(SingleMobilePageUI.PRICE_SINGLE_PRODUCT);
	}
	
	public String clickDynamicProduct(String name) {
		String xpathText = String.format(MobilePageUI.LINK_DYNAMIC_PRODUCT, name);
		waitForControlVisible(xpathText);
		return getTextElement(xpathText);
	}
	
}
