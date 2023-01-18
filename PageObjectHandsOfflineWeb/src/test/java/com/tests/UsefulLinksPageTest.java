package com.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.base.BaseClass;
import com.pages.UsefulLinksPage;

public class UsefulLinksPageTest extends BaseClass {

	WebDriver driver = null;

	UsefulLinksPage usefullinkspage = null;

	@BeforeClass
	public void SetUp() {
		log.info("Initializing Browser.");
		driver = initialization();
		log.info("Loading login page and navigating to usefullinks page.");
		usefullinkspage = loadLoginpage().NavigateToDashboardPage().NavigateToUsefulLinksPage();

	}

	@AfterClass
	public void tearDown() {
		driver.quit();
		log.info("Webdriver instance quit successfully.");
	}

	@Test
	public void TC001_verify_Useful_Links_Table_Data() throws Exception {

		log.info("Verify usefullinks webtable data on usefullinks page.");
		Assert.assertTrue(usefullinkspage.checkUsefulLinksTableData());
	}

	@Test
	public void TC002_verify_Content_Links_Of_Useful_Links_Page() throws Exception {

		log.info("Verify content links title of usefullinks page.");
		Assert.assertTrue(usefullinkspage.checkContentLinkOfUsefulLinksPage());
	}

}
