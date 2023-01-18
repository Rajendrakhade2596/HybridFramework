package com.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.base.BaseClass;
import com.pages.DashboardPage;

public class DashboardPageTest extends BaseClass {

	public WebDriver driver = null;

	DashboardPage dashboardpage = null;

	@BeforeClass
	public void setUp() {
		log.info("Initializing Browser.");
		driver = initialization();
		log.info("Loading login page and navigating to Dashboard page.");
		dashboardpage = loadLoginpage().NavigateToDashboardPage();
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
		log.info("Webdriver instance quit successfully.");
	}

	@Test
	public void TC001_verify_CoursesName_And_Details_Of_Courses() throws Exception {

		log.info("Verify a course name & details of respective course on dashboard page.");
		Assert.assertTrue(dashboardpage.checkCoursesAndCourseDetail());
	}

	@Test
	public void TC002_verify_More_Info_Links() throws Exception {

		log.info("Verify more info links on dashboard page.");
		Assert.assertTrue(dashboardpage.checkMoreInfoLinkIsClickable());
	}

	@Test
	public void TC003_verify_SideMenubar_Links() throws Exception {

		log.info("Verify text of side menubar links on dashboard page.");
		Assert.assertTrue(dashboardpage.checkSideMenubarLink());
	}

	@Test
	public void TC004_verify_Title_After_Clicking_On_SidebarMenu() throws Exception {

		log.info("Verify all webpage title after clicking on side menubar links.");
		Assert.assertTrue(dashboardpage.checkSideMenubarLinkIsClickable());
	}

}
