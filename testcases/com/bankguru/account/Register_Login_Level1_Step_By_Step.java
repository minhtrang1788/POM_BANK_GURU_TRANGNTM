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

public class Register_Login_Level1_Step_By_Step extends AbstractTest {

	WebDriver driver;
	private String name;
	private String password;
	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
	}
	
	public void goURL(String url) {
		
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
	}
	@Test
	public void TC_01_register() {
		goURL("http://demo.guru99.com");
		WebElement nameInput = driver.findElement(By.xpath("//input[@name='emailid']"));
		nameInput.sendKeys("testserverbank02@gmail.com");
		//input[@name='btnLogin']
		driver.findElement(By.xpath("input[@name='btnLogin']")).click();
		name = driver.findElement(By.xpath("//td[contains(text(),'User ID')]/following-sibling::td")).getText().toString();
		password = driver.findElement(By.xpath("//td[contains(text(),'Password')]/following-sibling::td")).getText().toString();
		
	}
	
	@Test
	public void TC_02_Login() throws InterruptedException {
		goURL("http://demo.guru99.com/v4/index.php");
		WebElement nameInput = driver.findElement(By.xpath("//input[@name='uid']"));
		nameInput.sendKeys(name);
		WebElement passInput = driver.findElement(By.xpath("//input[@name='password']"));
		passInput.sendKeys(password);
		//input[@name='btnLogin']
		driver.findElement(By.xpath("input[@name='btnLogin']")).click();
		Thread.sleep(1000);
		Assert.assertTrue(driver.findElement(By.xpath("//marquee[contains(text(),'Welcome To Manager')]")).isDisplayed());
		
		
	}

	

	@AfterClass
	public void afterClass() {
	}

}
