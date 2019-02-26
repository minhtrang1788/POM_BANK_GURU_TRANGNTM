package com.bankguru.account;

import org.testng.annotations.Test;

import common.AbstractPage;
import common.AbstractTest;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Register_Login_Level2_AbstractPage_MultiBrowser extends AbstractTest {

	public static WebDriver driver;
	private String name;
	private String password;
	private AbstractPage abstractPage;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = openMultiBrowser(browserName);
	}

	@Test
	public void TC_01_register() {
		abstractPage.goURLLink("http://demo.guru99.com");
		abstractPage.sendkeyToElement("//input[@name='emailid']", abstractPage.getEmailString());
		abstractPage.clickToElement("//input[@name='btnLogin']");
		name = abstractPage.getTextElement("//td[contains(text(),'User ID')]/following-sibling::td");
		password = abstractPage.getTextElement("//td[contains(text(),'Password')]/following-sibling::td");

	}

	@Test
	public void TC_02_Login() throws InterruptedException {
		abstractPage.goURLLink("http://demo.guru99.com/v4/index.php");
		abstractPage.sendkeyToElement("//input[@name='uid']", name);
		abstractPage.sendkeyToElement("//input[@name='password']", password);
		abstractPage.clickToElement("//input[@name='btnLogin']");
		Assert.assertTrue(abstractPage.isControlDisplayed("//marquee[contains(text(),'Welcome To Manager')]"));

	}

	@AfterClass
	public void afterClass() {
	}

}
