package com.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.base.BaseClass;
import com.base.BasePage;
import com.pages.LoginPage;

public class LoginPageTest extends BaseClass {

	WebDriver driver = null;
	LoginPage loginPage;

	@BeforeClass
	public void setUp() {
		log.info("Initializing Browser.");
		driver = initialization();
		log.info("Loading login page.");
		loginPage = loadLoginpage();
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
		log.info("Webdriver instance quit successfully.");

	}

	@Test
	public void TC001_verify_Logo_Is_Displayed() {
		
		log.info("verify the logo on login page");
		Assert.assertTrue(loginPage.checkLoginPageLogo());
	}

	@Test
	public void TC002_verify_Valid_Heading_On_Loginpage() {
		
		log.info("Verify the heading on login page");
		Assert.assertTrue(loginPage.checkLoginPageHeading());
	}

	@Test
	public void TC003_verify_Valid_CourseName_On_Loginpage() {
	
		log.info("Verify the coursename on login page");
		Assert.assertTrue(loginPage.checkCourseName());
	}

	@Test
	public void TC004_verify_Email_Error_Message() {
		
		log.info("Verify an email error message when login credentials entered.");
		Assert.assertTrue(loginPage.checkEmailErrorMassage());
	}

	@Test
	public void TC005_verify_Password_Error_Message() {
		
		log.info("Verify a password error message when login credentials entered.");
		Assert.assertTrue(loginPage.checkPasswordErrorMassage());
	}

	@Test
	public void TC006_verify_Enter_Invalid_Email_Error_Message() {
		
		log.info("Verify an email invalid error message when login credentials entered.");
		Assert.assertTrue(loginPage.checkEnterInvalidEmailErrorMassage());
	}

	@Test
	public void TC007_verify_Enter_Invalid_Password_Error_Message() {
		
		log.info("Verify a password invalid error message when login credentials entered.");
		Assert.assertTrue(loginPage.checkEnterInvalidPasswordErrorMassage());
	}

	@Test
	public void TC008_verify_Register_Link_Is_Clickable() {

		log.info("Verify register link is working/clickable.");
        Assert.assertTrue(loginPage.checkRegisterLinkClickable());
	}

	@Test(dataProvider = "setData")
	public void TC009_verify_Valid_Login_Credential_Scenario(String uname, String pass) {
	
		log.info("Verify a valid login credentials entered using dataprovider.");
		Assert.assertTrue(loginPage.checkLoginCredentials(uname, pass));
	}

	@DataProvider
	public Object[][] setData() throws Exception {
		String[][] value = BasePage.readExcelSheetDataUsing2DArray("OfflineWebSiteData.xlsx", "logindata");

		return value;
	}

}
