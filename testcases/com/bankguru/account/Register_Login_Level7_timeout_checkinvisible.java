package com.bankguru.account;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.Test;

import common.AbstractPage;
import common.AbstractTest;
import pageUI.Constants;
import pageUI.RegisterPageUI;
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

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;


public class Register_Login_Level7_timeout_checkinvisible extends AbstractTest {

	public static WebDriver driver;
	private String name,password,url;
	private LoginPageObject loginPageObject ;
	private RegisterPageObject registerPageObject ;
	private HomePageObject homePageObject ;
	private NewCustomerPageObject newCustomerPageObject;
	private NewAccountPageObject newAccountPageObject;
	private DepositPageObject depositPageObject;
	private FundTransferPageObject fundTransferPageObject;
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
		homePageObject = FactoryPageObject.newHomePageObject(driver);
		homePageObject.isDispledHomePage();

	}
	@Test
	public void TC_03_LifeCircle() throws InterruptedException  {
		homePageObject.openDynamicObjectPage(driver,"New Customer");
		newCustomerPageObject = FactoryPageObject.newCustomerPageObject(driver);
		Assert.assertTrue(newCustomerPageObject.isDispledCustomerPage());
		Assert.assertTrue(newCustomerPageObject.isNotDispledHomePage());
		Assert.assertTrue(newCustomerPageObject.isNotDispledCustomerForm());
		
		newCustomerPageObject.openDynamicObjectPage(driver,"New Account");
		newAccountPageObject = FactoryPageObject.newAccountPageObject(driver);
		Assert.assertTrue(newAccountPageObject.isDispledAccountPage());
		newAccountPageObject.openDynamicObjectPage(driver,"Deposit");
		depositPageObject = FactoryPageObject.newDepositPageObject(driver);
		Assert.assertTrue(depositPageObject.isDispledDepositPage());
		
		depositPageObject.openDynamicObjectPage(driver,"Fund Transfer");
		fundTransferPageObject = FactoryPageObject.newFundTransferPageObject(driver);
		Assert.assertTrue(fundTransferPageObject.isDispledFundTransferPage());
	}
	

	@AfterClass
	public void afterClass() {
	}

}
