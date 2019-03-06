package com.bankguru.account;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.sun.jna.platform.win32.VerRsrc;

import org.testng.annotations.Test;

import common.AbstractPage;
import common.AbstractTest;
import pageUI.Constants;
import pageUI.RegisterPageUI;
import pageObjects.BalanceEnquiryPageObject;
import pageObjects.DeleteAccPageObject;
import pageObjects.DeleteCustomerPageObject;
import pageObjects.DepositPageObject;
import pageObjects.EditCustomerFormPageObject;
import pageObjects.EditCustomerPageObject;
import pageObjects.FactoryPageObject;
import pageObjects.FundTransferPageObject;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.NewAccountPageObject;
import pageObjects.NewCustomerPageObject;
import pageObjects.RegisterPageObject;
import pageObjects.SuccessRegisterNewCustomerPageObject;
import pageObjects.WithdrawPageObject;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;

public class Register_Login_Excercise_9_testcase extends AbstractPage {

	public static WebDriver driver;
	private LoginPageObject loginPageObject;
	private HomePageObject homePageObject;
	private NewCustomerPageObject newCustomerPageObject;
	private EditCustomerPageObject editCustomerPageObject;
	private NewAccountPageObject newAccountPageObject;
	private DepositPageObject depositPageObject;
	private WithdrawPageObject withdrawPageObject;
	private FundTransferPageObject fundTransferPageObject;
	private BalanceEnquiryPageObject balanceEnquiryPageObject;
	private EditCustomerFormPageObject editCustomerFormPageObject;
	private DeleteAccPageObject deleteAccPageObject;
	private DeleteCustomerPageObject deleteCustomerPageObject;
	private SuccessRegisterNewCustomerPageObject successRegisterNewCustomerPageObject;
	private AbstractTest abstractTest = new AbstractTest();
	private String name = "mngr179811";
	private String password = "qAsynYq";
	private String customerName = "AUTOMATION TESTING";
	private String dateOfBirth_chrome = "01011989";
	private String dateOfBirth = "1989-01-01";
	private String address = "PO Box 911 8331 Duis Aveneu";
	private String city = "Tampa";
	private String state = "FL";
	private String pin = "466250";
	private String mobile = "455442476";
	private String pass = "automation";
	private String customerId;
	private String address2 = "Da Nang";
	private String city2 = "Da Nang";
	private String state2 = "MT";
	private String pin2 = "123456";
	private String mobile2 = "0935044603";
	private int initDeposit = 50000;
	private int amountTranfer = 5000;
	private int amountWithdraw = 15000;
	private String descDeposit = "Deposit";
	private String accountNumber;
	private String accPayee = "57417";
	private int ammoutTranferToAcc = 10000;
	private String browser = "firefox";
	
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = abstractTest.openMultiBrowser(browserName);
		browser = browserName;
	}

	@Test
	public void TC_01_newCustomer() throws InterruptedException {
		log.info("STEP 1: Open Guru 99 site");
		loginPageObject = FactoryPageObject.newLoginPageObject(driver);
		loginPageObject.goURL(Constants.LOGIN_LINK);

		log.info("STEP 2: Login with name and pass");
		loginPageObject.InputName(name);
		loginPageObject.InputPassword(password);
		loginPageObject.clickButtonLogin();
		homePageObject = FactoryPageObject.newHomePageObject(driver);
		verifyTrue(homePageObject.isDispledHomePage());

		log.info("STEP 3: Login with name and pass");
		homePageObject.openNewCustomerPage(driver);

		log.info("STEP 4: Fill all info for customer form");
		newCustomerPageObject = FactoryPageObject.newCustomerPageObject(driver);
		verifyTrue(newCustomerPageObject.isDispledCustomerPage());

		newCustomerPageObject.sendDynamicInputText("name", customerName);
		if(browser.equals("firefox"))
			newCustomerPageObject.sendDynamicInputText("dob", dateOfBirth);
		else
			newCustomerPageObject.sendDynamicInputText("dob", dateOfBirth_chrome);
		newCustomerPageObject.inputAdress(address);
		newCustomerPageObject.sendDynamicInputText("city", city);
		newCustomerPageObject.sendDynamicInputText("state", state);
		newCustomerPageObject.sendDynamicInputText("pinno", pin);
		newCustomerPageObject.sendDynamicInputText("telephoneno", mobile);
		String email = getEmailString();
		newCustomerPageObject.sendDynamicInputText("emailid", email);
		newCustomerPageObject.sendDynamicInputText("password", pass);

		log.info("STEP 5: Click submit button");
		newCustomerPageObject.clickSubmit();
		
		successRegisterNewCustomerPageObject = FactoryPageObject.newSuccessRegisterNewCustomerPageObject(driver);
		verifyTrue(successRegisterNewCustomerPageObject.isDispledSuccessRegisterCustomer());
		Assert.assertEquals(successRegisterNewCustomerPageObject.getDynamicInputText("Customer Name"), customerName);
		Assert.assertEquals(successRegisterNewCustomerPageObject.getDynamicInputText("Birthdate"), dateOfBirth);
		Assert.assertEquals(successRegisterNewCustomerPageObject.getDynamicInputText("Address"), address);
		Assert.assertEquals(successRegisterNewCustomerPageObject.getDynamicInputText("City"), city);
		Assert.assertEquals(successRegisterNewCustomerPageObject.getDynamicInputText("State"), state);
		Assert.assertEquals(successRegisterNewCustomerPageObject.getDynamicInputText("Pin"), pin);
		Assert.assertEquals(successRegisterNewCustomerPageObject.getDynamicInputText("Mobile No."), mobile);
		Assert.assertEquals(successRegisterNewCustomerPageObject.getDynamicInputText("Email"), email);

		customerId = successRegisterNewCustomerPageObject.getCustomerId();
	}

	@Test
	public void TC_02_EditCustomer() throws InterruptedException {
		log.info("STEP 1: Open edit customer page");
		newCustomerPageObject.openDynamicObjectPage(driver, "Edit Customer");
		editCustomerPageObject = FactoryPageObject.editCustomerPageObject(driver);
		verifyTrue(editCustomerPageObject.isDispledDynamicTitlePage(driver,"Edit Customer Form"));

		log.info("STEP 2: enter customerID");
		editCustomerPageObject.inputCustomerID(customerId);

		log.info("STEP 3: click submit button");
		editCustomerPageObject.clickSubmit();
		editCustomerFormPageObject = FactoryPageObject.editCustomerFormPageObject(driver);

		log.info("STEP 4: Fill edit info customer");
		verifyTrue(editCustomerPageObject.isDispledDynamicTitlePage(driver,"Edit Customer"));

		editCustomerFormPageObject.inputAdress(address2);
		editCustomerFormPageObject.sendDynamicInputText("city", city2);
		editCustomerFormPageObject.sendDynamicInputText("state", state2);
		editCustomerFormPageObject.sendDynamicInputText("pinno", pin2);
		editCustomerFormPageObject.sendDynamicInputText("telephoneno", mobile2);
		editCustomerFormPageObject.sendDynamicInputText("emailid", getEmailString());

		log.info("STEP 5: Click submit button");
		editCustomerFormPageObject.clickSubmit();

	}

	@Test
	public void TC_03_Add_New_Account() {
		log.info("STEP 1: Open new account page");
		editCustomerFormPageObject.openDynamicObjectPage(driver, "New Account");
		newAccountPageObject = FactoryPageObject.newAccountPageObject(driver);
		
		log.info("STEP 2: Verify new account page is displayed");
		verifyTrue(newAccountPageObject.isDispledDynamicTitlePage(driver,"Add new account form"));
		
		log.info("STEP 3: fill alls input for new account form");
		newAccountPageObject.sendDynamicInputText("cusid", customerId);
		newAccountPageObject.selectAccountType();
		newAccountPageObject.sendDynamicInputText("inideposit", String.valueOf(initDeposit));
		
		log.info("STEP 4: Click submit form new account");
		newAccountPageObject.clickSubmit();
		
		log.info("STEP 5: Verify create new account successfull");
		verifyTrue(newAccountPageObject.isDispledDynamicTitlePage(driver,"Account Generated Successfully!!!"));
		accountNumber = newAccountPageObject.getDynamicInputText("Account ID");
		
		log.info("STEP 6: Verify current amount is correct");
		Assert.assertEquals(newAccountPageObject.getDynamicInputText("Current Amount"), String.valueOf(initDeposit));

	}

	@Test
	public void TC_04_Tranfer_Money() {
		log.info("STEP 1: Open new deposite page");
		newAccountPageObject.openDynamicObjectPage(driver, "Deposit");
		depositPageObject = FactoryPageObject.newDepositPageObject(driver);

		log.info("STEP 2: verify deposit page is displayed");
		verifyTrue(depositPageObject.isDispledDynamicTitlePage(driver,"Amount Deposit Form"));
		
		log.info("STEP 3: Fill information for deposit form");
		depositPageObject.sendDynamicInputText("accountno", accountNumber);
		depositPageObject.sendDynamicInputText("ammount", String.valueOf(amountTranfer));
		depositPageObject.sendDynamicInputText("desc", descDeposit);
		
		log.info("STEP 4: Click button submit form deposit");
		depositPageObject.clickSubmit();
		
		log.info("STEP 5: Verify deposit successfull");
		verifyTrue(depositPageObject.isDispledDynamicTitlePage(driver,"Transaction details of Deposit for Account "+accountNumber));
		
		log.info("STEP 6: Verify current balance is correct");
		Assert.assertEquals(depositPageObject.getDynamicInputText("Current Balance"),
				String.valueOf(initDeposit + amountTranfer));
	}

	@Test
	public void TC_05_Withdraw_Money() throws InterruptedException {
		log.info("STEP 1: Open new withdrawal page");
		depositPageObject.openDynamicObjectPage(driver, "Withdrawal");
		withdrawPageObject = FactoryPageObject.newWithdrawPageObject(driver);
		
		log.info("STEP 2: Verify withdrawal page is displayed");
		verifyTrue(withdrawPageObject.isDispledDynamicTitlePage(driver,"Amount Withdrawal Form"));
		
		log.info("STEP 3: Fill all info in withdrawal form");
		withdrawPageObject.sendDynamicInputText("accountno", accountNumber);
		withdrawPageObject.sendDynamicInputText("ammount", String.valueOf(amountWithdraw));
		withdrawPageObject.sendDynamicInputText("desc", "Withdraw");
		
		log.info("STEP 4: Click button submit form withdrawal");
		withdrawPageObject.clickSubmit();
		
		log.info("STEP 5: Verify withdraw successfull");
		verifyTrue(withdrawPageObject.isDispledDynamicTitlePage(driver,"Transaction details of Withdrawal for Account "+accountNumber));
		
		log.info("STEP 6: Verify current balance is correct");
		Assert.assertEquals(withdrawPageObject.getDynamicInputText("Current Balance"),
				String.valueOf(initDeposit + amountTranfer - amountWithdraw));
	}

	

	@Test
	public void TC_06_FundTrafer_Money() {
		log.info("STEP 1: Open new new fund tranfer page");
		withdrawPageObject.openDynamicObjectPage(driver, "Fund Transfer");
		fundTransferPageObject = FactoryPageObject.newFundTransferPageObject(driver);

		log.info("STEP 2: Verify fund tranfer page is displayed");
		verifyTrue(fundTransferPageObject.isDispledFundTransferPage());
		verifyTrue(withdrawPageObject.isDispledDynamicTitlePage(driver,"Fund transfer"));
		
		log.info("STEP 3: Fill all info in fund tranfer form");
		fundTransferPageObject.sendDynamicInputText("payersaccount", accountNumber);
		fundTransferPageObject.sendDynamicInputText("payeeaccount", accPayee);
		fundTransferPageObject.sendDynamicInputText("ammount", String.valueOf(ammoutTranferToAcc));
		fundTransferPageObject.sendDynamicInputText("desc", "Tranfer");
		
		log.info("STEP 4: Click button submit form fund tranfer");
		fundTransferPageObject.clickSubmit();
		
		log.info("STEP 5: Verify current balance is correct");
		Assert.assertEquals(fundTransferPageObject.getDynamicInputText("Amount"), String.valueOf(ammoutTranferToAcc));
	}

	@Test
	public void TC_07_Check_Current_Account_Balance() {
		log.info("STEP 1: Open Balance Enquiry page");
		fundTransferPageObject.openDynamicObjectPage(driver, "Balance Enquiry");
		balanceEnquiryPageObject = FactoryPageObject.newBalanceEnquiryPageObject(driver);

		log.info("STEP 2: Verify Balance Enquiry page is displayed");
		verifyTrue(balanceEnquiryPageObject.isDispledDynamicTitlePage(driver,"Balance Enquiry Form"));
		
		log.info("STEP 3: Input account number");
		balanceEnquiryPageObject.sendDynamicInputText("accountno", accountNumber);
		
		log.info("STEP 4: Click button submit form Balance Enquiry");
		balanceEnquiryPageObject.clickSubmit();
		
		log.info("STEP 5: Verify check Balance Enquiry successfull");
		verifyTrue(balanceEnquiryPageObject.isDispledDynamicTitlePage(driver,"Balance Details for Account "+accountNumber));
		
		log.info("STEP 6: Verify current balance is correct");
		Assert.assertEquals(balanceEnquiryPageObject.getDynamicInputText("Balance"),
				String.valueOf(initDeposit + amountTranfer - amountWithdraw - ammoutTranferToAcc));
	}

	@Test
	public void TC_08_Delete_Account() {
		log.info("STEP 1: Open Delete Account page");
		balanceEnquiryPageObject.openDynamicObjectPage(driver, "Delete Account");
		deleteAccPageObject = FactoryPageObject.newDeleteAccPageObject(driver);
		
		log.info("STEP 2:Verify Delete Account page is displayed");
		verifyTrue(deleteAccPageObject.isDispledDynamicTitlePage(driver,"Delete Account Form"));
		
		log.info("STEP 3: Input account number");
		deleteAccPageObject.sendDynamicInputText("accountno", accountNumber);

		log.info("STEP 4: Click button submit ");
		deleteAccPageObject.clickSubmit();
		deleteAccPageObject.clickOkAlert();
		
		log.info("STEP 5: Verify message content : Account Deleted Sucessfully");
		Assert.assertEquals(deleteAccPageObject.getTextAlert(), "Account Deleted Sucessfully");
		deleteAccPageObject.clickOkAlert();

	}

	@Test
	public void TC_09_Delete_Exist_Customer() {
		log.info("STEP 1: Open Delete customer page");
		deleteAccPageObject.openDynamicObjectPage(driver, "Delete Customer");
		deleteCustomerPageObject = FactoryPageObject.newDeleteCustomerPageObject(driver);
		
		log.info("STEP 2:Verify Delete Account page is displayed");
		verifyTrue(deleteCustomerPageObject.isDispledDynamicTitlePage(driver,"Delete Customer Form"));
		
		log.info("STEP 2:Input customer ID");
		deleteCustomerPageObject.sendDynamicInputText("cusid", customerId);

		log.info("STEP 4: Click button submit ");
		deleteCustomerPageObject.clickSubmit();
		deleteCustomerPageObject.clickOkAlert();
		
		log.info("STEP 5: Verify message content : Customer deleted Successfully");
		Assert.assertEquals(deleteCustomerPageObject.getTextAlert(), "Customer deleted Successfully");
		deleteCustomerPageObject.clickOkAlert();

	}

	@AfterClass
	public void afterClass() {
		closeBrowserAndDriver(driver);
	}

}
