package com.bankguru.account;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import common.AbstractPage;
import common.AbstractTest;
import pageObjects.DepositPageObject;
import pageObjects.FactoryPageObject;
import pageObjects.FundTransferPageObject;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.NewAccountPageObject;
import pageObjects.NewCustomerPageObject;
import pageObjects.RegisterPageObject;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;

public class Register_Login_Global extends AbstractPage {

	public static String NAME, PASSWORD;
	public static String  URL;
	public static WebDriver  DRIVER;
	public AbstractTest abstractTest = new AbstractTest();
	private RegisterPageObject registerPageObject;

	
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		DRIVER = abstractTest.openMultiBrowser(browserName);
	}
	
	@Test
	public void register(Method methodName) {
		System.out.println("========"+methodName.getName()+"================");
		log.info("CREAT NEW PAGE REGiSTER");
		registerPageObject = FactoryPageObject.newRegisterPageObject(DRIVER);
		URL = registerPageObject.getURL();
		log.info("STEP 1 : CLICK TO REGiSTER");
		registerPageObject.clickHere();
		log.info("STEP 2 : INPUT EMAILE IN REGISTER FORM");
		registerPageObject.InputEmail();
		log.info("STEP 3 : CLICK SUBMIT IN REGISTER FORM");
		registerPageObject.clickButtonRegister();
		log.info("STEP 4 : GET NAME");
		NAME = registerPageObject.getName();
		log.info("STEP 5 : GET PASS");
		PASSWORD = registerPageObject.getPassword();

	}

	
	@AfterClass
	public void afterClass() {
		closeBrowserAndDriver(DRIVER);
	}

}
