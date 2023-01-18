package com.base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.pages.LoginPage;
import com.utility.PropertiesUtils;

public class BaseClass extends BasePage {
	
	public static WebDriver driver = null;

	public WebDriver initialization() {

		String browser = PropertiesUtils.readProperty("browser");

		if (browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"D:/chromedriver.exe");
			driver = new ChromeDriver();
			
			log.info("Chrome browser launched successfully.");
		}

		if (browser.equals("firefox")) {
			System.setProperty("webdriver.chrome.driver", "geckodriver.exe");
			driver = new FirefoxDriver();
			
			log.info("Firefox browser launched successfully.");

		}
		launchApplication();
		return driver;

	}

	public void launchApplication() {
		
		driver.manage().window().maximize();
		
		driver.get(PropertiesUtils.readProperty("url"));
		
		log.info("Loading URL using Webdriver instance.");
		
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	public LoginPage loadLoginpage() {
		
		LoginPage loginPage = new LoginPage(driver);
		
		return loginPage;
	}
	
    public void WebdriverWaitForElement(WebElement element , int time ) {
		
		WebDriverWait wait = new WebDriverWait(driver, time);
		
		wait.until(ExpectedConditions.visibilityOf(element));
	}

}
