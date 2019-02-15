package com.bankguru.account;

import org.testng.annotations.Test;

import common.AbstractPage;
import common.AbstractTest;
import junit.framework.Assert;
import pageUI.Constants;
import pageUI.registerPageUI;
import pageObjects.FactoryPageObject;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.RegisterPageObject;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;

public class Register_Login_Level4_PageFactoryManager extends AbstractTest {

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
		registerPageObject = FactoryPageObject.newRegisterPageObject(driver);
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
		loginPageObject.clickButtonLogin();
		Thread.sleep(1000);
		homePageObject = FactoryPageObject.newHomePageObject(driver);
		homePageObject.checkDisplayedText();

	}


	@AfterClass
	public void afterClass() {
	}

}
