package com.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.base.BaseClass;
import com.pages.UsersPage;

public class UsersPageTest extends BaseClass {

	public WebDriver driver = null;

	UsersPage userspage = null;

	@BeforeClass
	public void SetUp() {
		log.info("Initializing Browser.");
		driver = initialization();
		log.info("Loading login page and navigating to User page.");
		userspage = loadLoginpage().NavigateToDashboardPage().NavigateToUserPage();
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
		log.info("Webdriver instance quit successfully.");
	}

	@Test
	public void TC001_verify_Users_Table_Data() throws Exception {
		
		log.info("Verify users webtable data on user page.");
		Assert.assertTrue(userspage.checkUsersTableData());
	}

	@Test
	public void TC002_verify_Users_And_Courses_Data() throws Exception {
		
		log.info("Verify data of user name & with respective user course.");
		Assert.assertTrue(userspage.checkUserNameAndCourses());
	}

	@Test
	public void TC003_verify_Users_And_State() throws Exception {
		
		log.info("Verify data of user name & with respective user state.");
		Assert.assertTrue(userspage.checkUserNameAndState());
	}

	@Test
	public void TC004_verify_Users_Email_Address() throws Exception {
		
		log.info("Verify data of user name & with respective user email address.");
		Assert.assertTrue(userspage.checkUserEmailAddress());
	}

	@Test
	public void TC005_verify_Users_Gender() throws Exception {
		
		log.info("Verify data of user name & with respective user gender.");
		Assert.assertTrue(userspage.checkUserGender());
	}

	@Test
	public void TC006_verify_Users_MobileNumber() throws Exception {
	
		log.info("Verify data of user name & with respective user mobile number.");
		Assert.assertTrue(userspage.checkUserMobileNumber());
	}

	@Test
	public void TC007_verify_Users_Can_Be_Deleted() throws Exception {
		
		log.info("Verify users can be deleted with delete button.");
		Assert.assertTrue(userspage.checkUserCanBeDeleted());
	}

	@Test
	public void TC008_verify_Add_New_User_Functionality() throws Exception {
		
		log.info("Verify new user added successfully message after entering a valid information.");
		Assert.assertTrue(userspage.checkAddNewUserFUnctionality());
	}

}
