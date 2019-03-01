package common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AbstractTest {
	WebDriver driver;
	
	public WebDriver openMultiBrowser(String browser) {
		if (browser.equals("chrome")) {
			//System.setProperty("webdriver.chrome.driver", ".\\lib\\chromedriver.exe");
			WebDriverManager.chromedriver().setup();// download version newest
			WebDriverManager.chromedriver().version("2.44").setup();;
			driver = new ChromeDriver();
			

		} else if (browser.equals("firefox")) {
			driver = new FirefoxDriver();
		} /*else if (browserName.equals("ie")) {

			System.setProperty("webdriver.ie.driver", ".\\resources\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		} */else if(browser.equals("chromeheadless"))
		{
			WebDriverManager.chromedriver().version("2.46").setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("headless");
			options.addArguments("window-size=1366x768");
			driver = new ChromeDriver(options);
		} else if(browser.equals("internetexplore"))
		{
			WebDriverManager.iedriver().arch64().setup();
		}
		return driver;
	}
	
}
