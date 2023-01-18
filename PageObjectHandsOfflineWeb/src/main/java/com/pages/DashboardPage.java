package com.pages;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import com.base.BasePage;
import com.repo.DashboardPageRepo;

public class DashboardPage extends DashboardPageRepo {

	public WebDriver driver = null;

	public DashboardPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	/*************************** Dashboard Page Methods ****************************/

	/* Method Number 01 */

	public boolean checkCoursesAndCourseDetail() throws Exception {
		HashMap<String, String> actMap = new HashMap<String, String>();
		
		HashMap<String, String> expMap = BasePage
				.readSpecificExcelSheetDataUsingHashMap("OfflineWebSiteData.xlsx", "DashboardCourse", 0, 1);  

		for (int i = 0; i < coursesName.size(); i++) {
			
			String key = coursesName.get(i).getText();
			
			String value = detailOfcourse.get(i).getText();

			actMap.put(key , value);

		}

		for (Entry<String, String> entry : expMap.entrySet()) {

			String key = entry.getKey();

			String value = entry.getValue();

			log.info(key + " : " + value);

		}
		for (Entry<String, String> entry : actMap.entrySet()) {

			String key = entry.getKey();

			String value = entry.getValue();

			log.info(key + " : " + value);

		}

		if (actMap.equals(expMap)) {

			log.info("courses and course details on dashboard page matches with as expected.");

			return true;

		} else {

			log.info("courses and course details on dashboard page doesn't matches with as expected.");

			return false;

		}
	}
	

	/* Method Number 02 */

	public boolean checkSideMenubarLink() throws Exception {
		ArrayList<String> actList = new ArrayList<String>();

		ArrayList<String> expList = BasePage
				.readExcelSheetDataUsingArraylist("OfflineWebSiteData.xlsx","sidemenudata");

		for (WebElement menu : sideMenubarLink) {

			String menuName = menu.getText();

			actList.add(menuName);

		}
		log.info("Actual list : " + actList);
		log.info("Expected list : " +expList);
		
		if (actList.equals(expList)) {
			
			log.info("Side menubar link text on dashboard page matches with as expected.");

			return true;

		} else {

			log.info("Side menubar link text on dashboard page doesn't matches with as expected.");

			return false;

		}
	}
	
	
	/* Method Number 03 */

	public boolean checkSideMenubarLinkIsClickable() throws Exception {
		ArrayList<String> actualList = new ArrayList<String>();

		ArrayList<String> expectedList = BasePage
				.readExcelSheetDataUsingArraylist("OfflineWebSiteData.xlsx","menutitle");

		for (int i = 0; i < sideMenubarLink.size(); i++) {

			clickOnWebElement(sideMenubarLink.get(i));

			String menuName = driver.getTitle();

			actualList.add(menuName);

		}
		log.info("Actual list : " + actualList);
		log.info("Expected list : " + expectedList);
		
		if (actualList.equals(expectedList)) {
			
			//LoginPage lp = new LoginPage(driver);
			
			//lp.LoadDashboardPage();

			driver.navigate().back();

			clickOnWebElement(dashboardLink);

			log.info("Side menubar link after clicking all page title matches with as expected.");

			return true;

		} else {

			log.info("Side menubar link after clicking all page title doesn't matches with as expected.");

			return false;

		}
	}

	
	/* Method Number 04 */

	public boolean checkMoreInfoLinkIsClickable() {
		
		String mainWindowHandle = driver.getWindowHandle();

		for (WebElement element : moreInfoLink) {

			element.click();
		}

		Set<String> handles = driver.getWindowHandles();

		for (String handle : handles) {

			if (!handle.equals(mainWindowHandle)) {

				driver.switchTo().window(handle).close();

			}
		}

		driver.switchTo().window(mainWindowHandle);

		if (handles.size() == 5) {

			log.info("More info link after clicking all window size matches with as expected.");

			return true;

		} else {

			log.info("More info link after clicking all window size doesn't matches with as expected.");

			return false;

		}
	}

	
	/* Load UsersPage */

	public UsersPage NavigateToUserPage() {

		clickOnWebElement(usersLink);

		UsersPage userspage = new UsersPage(driver);

		return userspage;
	}

	
	/* Load OperatorsPage */

	public OperatorsPage NavigateToOperatorsPage() {

		clickOnWebElement(operatorsLink);

		OperatorsPage operatorspage = new OperatorsPage(driver);

		return operatorspage;
	}

	
	/* Load OperatorsPage */

	public UsefulLinksPage NavigateToUsefulLinksPage() {

		clickOnWebElement(usefulLink);

		UsefulLinksPage usefullinkspage = new UsefulLinksPage(driver);

		return usefullinkspage;
	}

	
	/* Load OperatorsPage */

	public DownloadsPage NavigateToDownloadsPage() {

		clickOnWebElement(downloadsLink);

		DownloadsPage downloadspage = new DownloadsPage(driver);

		return downloadspage;
	}

}
