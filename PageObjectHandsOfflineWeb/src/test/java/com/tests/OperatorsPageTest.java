package com.tests;

import com.base.BaseClass;
import com.pages.OperatorsPage;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class OperatorsPageTest extends BaseClass {

	public WebDriver driver = null;

	OperatorsPage operatorspage = null;

	@BeforeClass
	public void setUp() {
		log.info("Initializing Browser.");
		driver = initialization();
		log.info("Loading login page and navigating to operators page.");
		operatorspage = loadLoginpage().NavigateToDashboardPage().NavigateToOperatorsPage();
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
		log.info("Webdriver instance quit successfully.");
	}

	@Test
	public void TC001_verify_Operators_List_Table_Data() throws Exception {

		log.info("Verify operators webtable data on operators page.");
		Assert.assertTrue(operatorspage.checkOperatorsListTableData());
	}

	@Test
	public void TC002_verify_Technical_Person_In_Operators_List() throws Exception {

		log.info("Verify all technical operators on operators page.");
		Assert.assertTrue(operatorspage.checkTechnicalPersonFromOperatorsListTable());
	}

	@Test
	public void TC003_verify_Way_To_Connect_Without_WhatsApp_Only_To_Operator() throws Exception {

		log.info("Verify connect without whatsapp to operators.");
		Assert.assertTrue(operatorspage.checkWayToConnectWithoutWhatAppOnlyToOperators());
	}

	@Test
	public void TC004_verify_Way_To_Connect_WhatsApp_Only_To_Operator() throws Exception {

		log.info("Verify connect with whatsapp to operators.");
		Assert.assertTrue(operatorspage.checkWayToConnectWithWhatAppOnlyToOperators());
	}

	@Test
	public void TC005_verify_Monday_Timing_Of_Operators() throws Exception {

		log.info("Verify monday is working time of operators.");
		Assert.assertTrue(operatorspage.checkTimingOnMondayOfOperators());
	}

	@Test
	public void TC006_verify_Timing_Of_Operators() throws Exception {

		log.info("Verify working timing of all operators.");
		Assert.assertTrue(operatorspage.checkTimingOfOperators());
	}

	@Test
	public void TC007_verify_Mobile_Number_Of_Operators() throws Exception {

		log.info("Verify mobile number of all operators.");
		Assert.assertTrue(operatorspage.checkMobileNumberOfPersonFromOperatorsListTable());
	}
}
