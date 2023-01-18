package com.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.base.BaseClass;
import com.pages.RegistrationPage;

public class RegistrationPageTest extends BaseClass {

	public WebDriver driver = null;

	RegistrationPage registerpage = null;

	@BeforeClass
	public void SetUp() {
		log.info("Initializing Browser.");
		driver = initialization();
		log.info("Loading login page and navigating to register page.");
		registerpage = loadLoginpage().navigateToRegisterPage();
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
		log.info("Webdriver instance quit successfully.");
	}

	@Test
	public void TC001_verify_New_User_Registration_Functionality() throws Exception {

		log.info("Verify a message after adding a new user registration.");
		Assert.assertTrue(registerpage.checkRegisterNewMembership());
	}

	@Test
	public void TC002_erify_Already_User_Link_Is_Clickable() throws Exception {

		log.info("Verify already user link is working/clickable.");
		Assert.assertTrue(registerpage.checkAlreadyRegisterLinkIsClickable());
	}

	@Test
	public void TC003_verify_Blank_UserName_Error_Message() throws Exception {

		log.info("Verify an error message when blank user name entered.");
		Assert.assertTrue(registerpage.checkUserNameErrorMessage());
	}

	@Test
	public void TC004_verify_Blank_MobileNumber_Error_Message() throws Exception {

		log.info("Verify an error message when blank mobile number entered.");
		Assert.assertTrue(registerpage.checkMobileNumberErrorMessage());
	}

	@Test
	public void TC005_verify_Blank_Email_Error_Message() throws Exception {

		log.info("Verify an error message when blank email address entered.");
		Assert.assertTrue(registerpage.checkEmailErrorMessage());
	}

	@Test
	public void TC006_verify_Blank_Password_Error_Message() throws Exception {

		log.info("Verify an error message when blank password entered.");
		Assert.assertTrue(registerpage.checkPasswordErrorMessage());
	}

}
