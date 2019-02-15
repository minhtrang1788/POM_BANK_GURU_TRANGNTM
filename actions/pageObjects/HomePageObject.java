package pageObjects;
import common.AbstractPage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import pageUI.Constants;
import pageUI.loginPageUI;
import pageUI.registerPageUI;

public class HomePageObject {
	
	private AbstractPage abstractPage;	
	WebDriver driver;
	
	public  HomePageObject(WebDriver driverUse) {
		driver = driverUse;
		abstractPage = new AbstractPage();
		abstractPage.setDriver(driver);
		
	}
	
	public void checkDisplayedText() throws InterruptedException {
		Thread.sleep(1000);
		Assert.assertTrue(abstractPage.isControlDisplayed(loginPageUI.WELCOME_LINK));
	}
}
