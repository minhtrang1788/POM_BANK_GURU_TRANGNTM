package pageObjects;
import common.AbstractPage;

import org.openqa.selenium.WebDriver;

import pageUI.AbstractPageUI;
import pageUI.HomePageUI;
import pageUI.MobilePageUI;
import pageUI.NewCustomerPageUI;

public class TVPageObject extends AbstractPage{
	
	WebDriver driver;
	
	public  TVPageObject(WebDriver driverUse) {
		driver = driverUse;
		setDriver(driverUse);	
	}
	
	public String getPriceDynamicPhone(String name) {
		String xpathText = String.format(MobilePageUI.PRICE_DYNAMIC_PRODUCT, name);
		waitForControlVisible(xpathText);
		return getTextElement(xpathText);
	}
	
	public void clickDynamicProduct(String name) {
		String xpathText = String.format(MobilePageUI.LINK_DYNAMIC_PRODUCT, name);
		waitForControlVisible(xpathText);
		clickToElement(xpathText);
	}
	
	public void clickDynamicATCProduct(String name) {
		String xpathText = String.format(MobilePageUI.BUTTON_DYNAMIC_PRODUCT, name);
		waitForControlVisible(xpathText);
		clickToElement(xpathText);
	}
	
}
