package com.pages;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.base.BasePage;
import com.repo.DownloadPageRepo;

public class DownloadsPage extends DownloadPageRepo {

	public WebDriver driver = null;

	public DownloadsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/*************************** Downloads Page Methods ***************************/

	/* Method Number 01 */

	public boolean checkDownloadsPageTableData() throws Exception {

		ArrayList<String> actList = new ArrayList<String>();

		ArrayList<String> expList = BasePage.readExcelSheetDataUsingArraylist("OfflineWebSiteData.xlsx",
				"downloadData");

		for (int i = 0; i < downloadsTableData.size(); i++) {

			String value = downloadsTableData.get(i).getText();

			actList.add(value);

		}

		log.info("Actual list : " + actList);
		log.info("Expected list : " + expList );

		if (actList.equals(expList)) {

			log.info("Downloads table data matches with as expected.");

			return true;

		} else {

			log.info("Downloads table data doesn't matches with as expected.");

			return false;
		}
	}

	
	/* Method Number 02 */

	public boolean checkThirtyTwoBitSupportApplication() throws Exception {
		HashMap<String, String> actList = new HashMap<String, String>();
		HashMap<String, String> expList = new HashMap<String, String>();

		ArrayList<String> expkey = BasePage.readExcelSheetDataUsingArraylistSpecificData("OfflineWebSiteData.xlsx",
				"downloadData", 2);
		ArrayList<String> expvalue = BasePage.readExcelSheetDataUsingArraylistSpecificData("OfflineWebSiteData.xlsx",
				"downloadData", 4);

		for (int i = 0; i < thirtyTwoBitSupportApps.size(); i++) {

			String actvalue = thirtyTwoBitSupportApps.get(i).getText();

			String actkey = vendorList.get(i).getText();

			if (actvalue.equals("32bit")) {

				actList.put(actkey, actvalue);
			}
		}

		expList.put(expkey.get(0), expvalue.get(0));
		expList.put(expkey.get(3), expvalue.get(3));
		expList.put(expkey.get(5), expvalue.get(5));
		expList.put(expkey.get(6), expvalue.get(6));

		log.info("Actual list : " + actList);
		log.info("Expected list : " + expList );

		if (actList.equals(expList)) {

			log.info("Vendors name and their 32-bit system supported application matches with as expected.");

			return true;

		} else {

			log.info("Vendors name and their 32-bit system supported application doesn't matches with as expected.");

			return false;
		}
	}
	

	/* Method Number 03 */

	public boolean checkSixtyFourSupportApplication() throws Exception {
		HashMap<String, String> actList = new HashMap<String, String>();
		HashMap<String, String> expList = new HashMap<String, String>();

		ArrayList<String> expkey = BasePage.readExcelSheetDataUsingArraylistSpecificData("OfflineWebSiteData.xlsx",
				"downloadData", 2);
		ArrayList<String> expvalue = BasePage.readExcelSheetDataUsingArraylistSpecificData("OfflineWebSiteData.xlsx",
				"downloadData", 5);

		for (int i = 0; i < sixtyFourBitSupportApps.size(); i++) {

			String actvalue = sixtyFourBitSupportApps.get(i).getText();

			String actkey = vendorList.get(i).getText();

			if (actvalue.equals("64bit")) {

				actList.put(actkey, actvalue);
			}
		}

		expList.put(expkey.get(0), expvalue.get(0));
		expList.put(expkey.get(3), expvalue.get(3));
		expList.put(expkey.get(5), expvalue.get(5));
		expList.put(expkey.get(6), expvalue.get(6));

		log.info("Actual list : " + actList);
		log.info("Expected list : " + expList );

		if (actList.equals(expList)) {

			log.info("Vendors name and their 64-bit system supported application matches with as expected.");

			return true;

		} else {

			log.info("Vendors name and their 64-bit system supported application doesn't matches with as expected.");

			return false;
		}
	}
	
	/* Method Number 04 */
	
	@Test
	public boolean checkVersionOfApplication() throws Exception {
		HashMap<String, String> actList = new HashMap<String, String>();

		 HashMap<String, String> expList = BasePage
				.readSpecificExcelSheetDataUsingHashMap("OfflineWebSiteData.xlsx","downloadData", 2, 3);
		
		for (int i = 0; i < version.size(); i++) {

			String actvalue = version.get(i).getText();

			String actkey = vendorList.get(i).getText();

			actList.put(actkey, actvalue);
		}

		log.info("Actual list : " + actList);
		log.info("Expected list : " + expList );

		if (actList.equals(expList)) {

			log.info("Vendors name and their versions matches with as expected.");

			return true;

		} else {

			log.info("Vendors name and their versions doesn't matches with as expected.");

			return false;
		}

	}

	
	/* Method Number 05 */

	public boolean checkOfficialSourceLinkOfPerticularApplication() throws Exception {

		int windowSize;

		String mainWindow = driver.getWindowHandle();

		for (int i = 0; i < officialSourceLink.size(); i++) {

			officialSourceLink.get(i).click();
		}

		Set<String> handles = driver.getWindowHandles();

		windowSize = handles.size();

		for (String handle : handles) {

			Thread.sleep(3000);

			if (!(handle.equals(mainWindow))) {

				Thread.sleep(3000);

				driver.switchTo().window(handle);

				driver.switchTo().window(handle).close();
			}
		}

		driver.switchTo().window(mainWindow);

		if (windowSize == 8) {

			log.info("Official source links after clicking sixe of windows matches with as expected.");

			return true;

		} else {

			log.info("Official source links after clicking sixe of windows doesn't matches with as expected.");

			return false;

		}
	}


	/* Method Number 06 */

	public boolean checkLogoutPageLinkFunctionality() throws Exception {

		clickOnWebElement(logoutLink);

		String title = driver.getTitle();

		Thread.sleep(3000);

		if (title.equals("JavaByKiran | Log in")) {

			driver.navigate().back();

			log.info("Logout link after clicking page title matches as expected.");

			return true;
		} else {

			log.info("Logout link after clicking page title doesn't matches as expected.");

			return false;

		}
	}
	


}
