package pageObjects;
import common.AbstractPage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import pageUI.Constants;
import pageUI.HomePageUI;
import pageUI.LoginPageUI;
import pageUI.RegisterPageUI;

public class HomePageObject extends AbstractPage{
	
	WebDriver driver;
	
	public  HomePageObject(WebDriver driverUse) {
		driver = driverUse;
		setDriver(driverUse);	
	}
	
	public void isDispledHomePage() throws InterruptedException {
		Thread.sleep(1000);
		Assert.assertTrue(isControlDisplayed(HomePageUI.WELCOME_LINK));
	}

	
}
