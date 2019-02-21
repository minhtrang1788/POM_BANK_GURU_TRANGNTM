package com.bankguru.account;

import org.testng.annotations.Test;

import common.AbstractPage;
import common.AbstractTest;

import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.RegisterPageObject;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;

public class Register_Login_Level3_PageObject extends AbstractTest {

	public static WebDriver driver;
	private String name,password,url;
	private LoginPageObject loginPageObject ;
	private RegisterPageObject registerPageObject ;
	private HomePageObject homePageObject ;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = openMultiBrowser(browserName);
	}

	@Test
	public void TC_01_register() {
		registerPageObject = new RegisterPageObject(driver);
		url = registerPageObject.getURL();
		registerPageObject.clickHere();
		registerPageObject.InputEmail();
		registerPageObject.clickButtonRegister();
		name = registerPageObject.getName();
		password = registerPageObject.getPassword();

	}

	@Test
	public void TC_02_Login() throws InterruptedException {
		loginPageObject = registerPageObject.goLoginLink(url);
		loginPageObject.InputName(name);
		loginPageObject.InputPassword(password);
		homePageObject = loginPageObject.clickButtonLogin();
		Thread.sleep(1000);
		homePageObject.isDispledHomePage();

	}


	@AfterClass
	public void afterClass() {
	}

}
