package com.bankguru.account;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.Test;

import common.AbstractPage;
import common.AbstractTest;
import pageUI.Constants;
import pageUI.RegisterPageUI;
import pageObjects.DepositPageObject;
import pageObjects.EditCustomerPageObject;
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


public class Register_Login_Excercise_9_testcase extends AbstractTest {

	public static WebDriver driver;
	private String url;
	private LoginPageObject loginPageObject ;
	private RegisterPageObject registerPageObject ;
	private HomePageObject homePageObject ;
	private NewCustomerPageObject newCustomerPageObject;
	private EditCustomerPageObject editCustomerPageObject;
	private NewAccountPageObject newAccountPageObject;
	private DepositPageObject depositPageObject;
	private FundTransferPageObject fundTransferPageObject;
	private String name = "mngr179811";
	private String password = "qAsynYq";
	private String customerName = "AUTOMATION TESTING";
	private String dateOfBirth = "01/01/1989";
	private String address = "PO Box 911 8331 Duis Aveneu";
	private String city = "Tampa";
	private String state = "FL";
	private String pin = "466250";
	private String mobile = "455442476";
	private String email = "automation@gmail.com";
	private String pass = "automation";
	private String customerId ;
	
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = openMultiBrowser(browserName);
	}
	@Test
	public void TC_01_newCustomer() throws InterruptedException {
		
		loginPageObject = FactoryPageObject.newLoginPageObject(driver);
		loginPageObject.goURL(Constants.LOGIN_LINK);
		loginPageObject.InputName(name);
		loginPageObject.InputPassword(password);
		loginPageObject.clickButtonLogin();
		Thread.sleep(1000);
		homePageObject = FactoryPageObject.newHomePageObject(driver);
		homePageObject.isDispledHomePage();
		homePageObject.openNewCustomerPage(driver);
		newCustomerPageObject = FactoryPageObject.newCustomerPageObject(driver);
		newCustomerPageObject.isDispledCustomerPage();
		newCustomerPageObject.inputCustomerName(customerName);
		newCustomerPageObject.inputDateOfBirth(dateOfBirth);
		newCustomerPageObject.inputAdress(address);
		newCustomerPageObject.inputCity(city);
		newCustomerPageObject.inputState(state);
		newCustomerPageObject.inputPin(pin);
		newCustomerPageObject.inputMobile(mobile);
		newCustomerPageObject.inputEmail();
		newCustomerPageObject.inputPassword(pass);
		newCustomerPageObject.clickSubmit();
		newCustomerPageObject.isDispledCustomerSucessPage();
		customerId = newCustomerPageObject.getCustomerId();
	}
	@Test
	public void TC_02_EditCustomer() throws InterruptedException {
		newCustomerPageObject.openDynamicObjectPage(driver, "Edit Customer");
		editCustomerPageObject = FactoryPageObject.editCustomerPageObject(driver);
		editCustomerPageObject.isDispledEditCustomerPage();
		editCustomerPageObject.inputCustomerID(customerId);
		editCustomerPageObject.clickSubmit();

	}
	
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
