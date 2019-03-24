package com.bankguru.ecommerce;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import common.AbstractPage;
import common.AbstractTest;
import pageUI.Constants;
import pageObjects.BalanceEnquiryPageObject;
import pageObjects.DeleteAccPageObject;
import pageObjects.DeleteCustomerPageObject;
import pageObjects.DepositPageObject;
import pageObjects.EditCustomerFormPageObject;
import pageObjects.EditCustomerPageObject;
import pageObjects.FactoryPageObject;
import pageObjects.FundTransferPageObject;
import pageObjects.HomePageObject;
import pageObjects.LivePageObject;
import pageObjects.LoginPageObject;
import pageObjects.MobilePageObject;
import pageObjects.NewAccountPageObject;
import pageObjects.NewCustomerPageObject;
import pageObjects.ShoppingCartPageObject;
import pageObjects.SingleMobilePageObject;
import pageObjects.SuccessRegisterNewCustomerPageObject;
import pageObjects.TVPageObject;
import pageObjects.WithdrawPageObject;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import org.openqa.selenium.WebDriver;

public class Ecommerce_Testcase extends AbstractPage {

	public static WebDriver driver;
	private AbstractTest abstractTest = new AbstractTest();
	private LivePageObject livePageObject;
	private MobilePageObject mobilePageObject;
	private ShoppingCartPageObject shoppingCartPageObject;
	private TVPageObject tVPageObject;
	private SingleMobilePageObject singleMobilePageObject;
	private String browser;
	private String priceSony;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		System.out.println("browserName:::::::" + browserName);
		driver = abstractTest.openMultiBrowser(browserName);
		browser = browserName;
	}

	
	public void TC_01_mobile() throws InterruptedException {
		log.info("STEP 1: Open Guru 99 site");
		System.out.println("STEP 1: Open Guru 99 site");
		livePageObject = FactoryPageObject.newLivePageObject(driver);

		livePageObject.goURLLink(Constants.LIVE_PAGE_LINK);

		log.info("STEP 2: Click link mobile");
		System.out.println("STEP 2: Click link mobile");
		livePageObject.clickDynamicLink("Mobile");
		mobilePageObject = FactoryPageObject.newMobilePageObject(driver);
		verifyTrue(mobilePageObject.isDispledDynamicTitleInLivePage(driver, "Mobile"));

		log.info("STEP 3: Get value of phone Sony xperia");
		System.out.println("STEP 3: Get value of phone Sony xperia");
		priceSony = mobilePageObject.getPriceDynamicPhone("Sony Xperia");

		log.info("STEP 4: click on phone Sony xperia" + priceSony);
		System.out.println("STEP 4: click on phone Sony xperia");
		mobilePageObject.clickDynamicProduct("Sony Xperia");
		singleMobilePageObject = FactoryPageObject.newSingleMobilePageObject(driver);

		log.info("STEP 5: verify price of phone sony");
		verifyEquals(singleMobilePageObject.getPricePhone(), priceSony);

	}
	
	private long totalPrice = 0;
	@Test
	public void TC_02_mobile() throws InterruptedException {
		log.info("STEP 1: Open Guru 99 site");
		livePageObject = FactoryPageObject.newLivePageObject(driver);

		livePageObject.goURLLink(Constants.LIVE_PAGE_LINK);

		log.info("STEP 2: Click link mobile");
		livePageObject.clickDynamicLink("Mobile");
		mobilePageObject = FactoryPageObject.newMobilePageObject(driver);
		verifyTrue(mobilePageObject.isDispledDynamicTitleInLivePage(driver, "Mobile"));

		log.info("STEP 3: Click ATC phone ");
		mobilePageObject.clickDynamicATCProduct("Sony Xperia");
		mobilePageObject.getPriceDynamicPhone("Sony Xperia");
		shoppingCartPageObject = FactoryPageObject.newShoppingCartPageObject(driver);

		log.info("STEP 4: click on TV menu");
		shoppingCartPageObject.clickDynamicLink("TV");
		tVPageObject = FactoryPageObject.newTVPageObject(driver);
		
		log.info("STEP 5: Add to cart TV menu");
		tVPageObject.clickDynamicATCProduct("LG LCD");
		shoppingCartPageObject = FactoryPageObject.newShoppingCartPageObject(driver);

		log.info("STEP 6: input promocode");
		shoppingCartPageObject.sendDynamicInputText("coupon_code", "GURU50");
		shoppingCartPageObject.clickApplyPromoCode();

	}

	@AfterClass
	public void afterClass() {
		// closeBrowserAndDriver(driver);
	}

}
