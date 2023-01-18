package com.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.base.BaseClass;
import com.pages.DownloadsPage;

public class DownloadsPageTest extends BaseClass {

	public WebDriver driver = null;

	DownloadsPage downloadspage = null;

	@BeforeClass
	public void setUp() {
		log.info("Initializing Browser.");
		driver = initialization();
		log.info("Loading login page and navigating to downloads page.");
		downloadspage = loadLoginpage().NavigateToDashboardPage().NavigateToDownloadsPage();
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
		log.info("Webdriver instance quit successfully.");
	}

	@Test
	public void TC001_verify_Downloads_Page_Table_Data() throws Exception {

		log.info("Verify downloads webtable data on downloads page.");
		Assert.assertTrue(downloadspage.checkDownloadsPageTableData());
	}

	@Test
	public void TC002_verify_Thirty_Two_Bit_Support_Application() throws Exception {

		log.info("Verify 32-bit system support application on downloads page.");
		Assert.assertTrue(downloadspage.checkThirtyTwoBitSupportApplication());
	}

	@Test
	public void TC003_verify_Sixty_Four_Bit_Support_Application() throws Exception {

		log.info("Verify 64-bit system support application on downloads page.");
		Assert.assertTrue(downloadspage.checkSixtyFourSupportApplication());
	}

	@Test
	public void TC004_verify_Version_Of_Application() throws Exception {

		log.info("Verify version of application on downloads page.");
		Assert.assertTrue(downloadspage.checkVersionOfApplication());
	}

	@Test
	public void TC005_verify_Official_SourceLink_Of_Perticular_Application() throws Exception {

		log.info("Verify official source link of perticular application is working.");
		Assert.assertTrue(downloadspage.checkOfficialSourceLinkOfPerticularApplication());
	}

	@Test
	public void TC006_verify_Logout_Page_Link_Functionality() throws Exception {

		log.info("Verify title when clicking on logout link.");
		Assert.assertTrue(downloadspage.checkLogoutPageLinkFunctionality());
	}

}
