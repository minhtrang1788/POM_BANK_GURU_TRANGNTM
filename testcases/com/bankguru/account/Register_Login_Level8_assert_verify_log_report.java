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

import org.apache.commons.el.Constants;
import org.openqa.selenium.WebDriver;

public class Register_Login_Level8_assert_verify_log_report extends AbstractPage {

	public static WebDriver driver;
	private String name, password, url;
	private LoginPageObject loginPageObject;
	private RegisterPageObject registerPageObject;
	private HomePageObject homePageObject;
	private NewCustomerPageObject newCustomerPageObject;
	private NewAccountPageObject newAccountPageObject;
	private DepositPageObject depositPageObject;
	private FundTransferPageObject fundTransferPageObject;
	public AbstractTest abstractTest = new AbstractTest();

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = Register_Login_Global.DRIVER;
	}
	

	
	@Test
	public void TC_02_Login(Method methodName) throws InterruptedException {
		System.out.println("========"+methodName.getName()+"================");
		log.info("STEP 1 : GO TO LOGIN LINK");
		loginPageObject = FactoryPageObject.newLoginPageObject(driver);
		loginPageObject.goURLLink(Register_Login_Global.URL);
		driver.get(pageUI.Constants.LOGIN_LINK);
		log.info("STEP 2 : INPUT NAME");
		loginPageObject.InputName(Register_Login_Global.NAME);
		log.info("STEP 3 : INPUT PASSWORD");
		loginPageObject.InputPassword(Register_Login_Global.PASSWORD);
		log.info("STEP 4 : CLICK BUTTON LOGIN");
		loginPageObject.clickButtonLogin();
		log.info("STEP 5 : OPEN HOME PAGE");
		homePageObject = FactoryPageObject.newHomePageObject(driver);
		log.info("STEP 6 : HOME PAGE IS DISPLAY");
		verifyTrue(homePageObject.isDispledHomePage());
		log.info("STEP 7 : NEW CUSTOMER FORM IS NOT DISPLAY");

		verifyTrue(homePageObject.isNotDispledCustomerForm());
		log.info("STEP 8 : NEW CUSTOMER IS NOT DISPLAY");
		verifyTrue(homePageObject.isNotDispledNewCustomer());

	}

	@Test
	public void TC_03_LifeCircle() throws InterruptedException {
		
		homePageObject.openDynamicObjectPage(driver, "New Customer");
		newCustomerPageObject = FactoryPageObject.newCustomerPageObject(driver);
		verifyTrue(newCustomerPageObject.isDispledCustomerPage());
		verifyTrue(newCustomerPageObject.isNotDispledHomePage());
		verifyTrue(newCustomerPageObject.isNotDispledCustomerForm());

		newCustomerPageObject.openDynamicObjectPage(driver, "New Account");
		newAccountPageObject = FactoryPageObject.newAccountPageObject(driver);
		verifyTrue(newAccountPageObject.isDispledAccountPage());

		newAccountPageObject.openDynamicObjectPage(driver, "Deposit");
		depositPageObject = FactoryPageObject.newDepositPageObject(driver);
		verifyTrue(depositPageObject.isDispledDepositPage());

		depositPageObject.openDynamicObjectPage(driver, "Fund Transfer");
		fundTransferPageObject = FactoryPageObject.newFundTransferPageObject(driver);
		verifyTrue(fundTransferPageObject.isDispledFundTransferPage());
	}

	@AfterClass
	public void afterClass() {
		closeBrowserAndDriver(driver);
	}

}
