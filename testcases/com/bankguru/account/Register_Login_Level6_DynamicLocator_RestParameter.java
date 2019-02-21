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

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;


public class Register_Login_Level6_DynamicLocator_RestParameter extends AbstractTest {

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
		Thread.sleep(1000);
		homePageObject = FactoryPageObject.newHomePageObject(driver);
		homePageObject.isDispledHomePage();

	}
	@Test
	public void TC_03_LifeCircle() throws InterruptedException  {
		//New customer -> new account -> Deposit -> FundTransfer
		/*newCustomerPageObject = (NewCustomerPageObject) homePageObject.openDynamicPage(driver,"New Account");
		
		newAccountPageObject = (NewAccountPageObject) newCustomerPageObject.openDynamicPage(driver,"New Account");
		
		depositPageObject = (DepositPageObject) newAccountPageObject.openDynamicPage(driver,"Deposit");
		
		fundTransferPageObject = (FundTransferPageObject) depositPageObject.openDynamicPage(driver,"Fund Transfer");*/
		
		homePageObject.openDynamicObjectPage(driver,"New Customer");
		newCustomerPageObject = FactoryPageObject.newCustomerPageObject(driver);
		newCustomerPageObject.isDispledCustomerPage();
		
		newCustomerPageObject.openDynamicObjectPage(driver,"New Account");
		newAccountPageObject = FactoryPageObject.newAccountPageObject(driver);
		newAccountPageObject.isDispledAccountPage();
		
		newAccountPageObject.openDynamicObjectPage(driver,"Deposit");
		depositPageObject = FactoryPageObject.newDepositPageObject(driver);
		depositPageObject.isDispledDepositPage();
		
		depositPageObject.openDynamicObjectPage(driver,"Fund Transfer");
		fundTransferPageObject = FactoryPageObject.newFundTransferPageObject(driver);
		fundTransferPageObject.isDispledFundTransferPage();
	}
	

	@AfterClass
	public void afterClass() {
	}

}
