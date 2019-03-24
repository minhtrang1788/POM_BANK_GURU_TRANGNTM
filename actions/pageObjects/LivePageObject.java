package pageObjects;
import common.AbstractPage;

import org.openqa.selenium.WebDriver;
import pageUI.HomePageUI;
import pageUI.LivePageUI;
import pageUI.NewCustomerPageUI;

public class LivePageObject extends AbstractPage{
	
	WebDriver driver;
	
	public  LivePageObject(WebDriver driverUse) {
		driver = driverUse;
		setDriver(driverUse);	
	}
	public boolean isDispledivePage() throws InterruptedException {
		return isControlDisplayed(LivePageUI.LIVE_PAGE_TITLE);
		
	}
	
	
}
